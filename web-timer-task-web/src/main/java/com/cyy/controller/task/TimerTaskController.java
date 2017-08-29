package com.cyy.controller.task;

import com.cyy.common.job.ApiMethodJob;
import org.quartz.*;
import org.springframework.scheduling.quartz.CronTriggerFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/28.
 */
@RestController
@RequestMapping("/task/")
public class TimerTaskController {

    @Resource
    private Scheduler scheduler;

    @Resource
    private ApiMethodJob jobObject;

    @RequestMapping("add")
    public String addJob(@RequestParam(value = "jobName")String jobName,@RequestParam(value = "api")String api) throws Exception{
        JobKey jobKey = new JobKey(jobName,"api_job_group");
        if(!scheduler.checkExists(jobKey)){
            /*
            JobDetailFactoryBean jobBean = new JobDetailFactoryBean();
            jobBean.setBeanName(jobKey.getName());
            jobBean.setGroup(jobKey.getGroup());
            jobBean.setJobClass(ApiJob.class);
            JobDataMap jobData = new JobDataMap();
            jobData.put("apiUrl","https://www.baidu.com");
            jobBean.setJobDataMap(jobData);
            jobBean.afterPropertiesSet();
            JobDetail job = jobBean.getObject();
            */
            /*
            JobDetail job =  JobBuilder.newJob(ApiJob.class)
                    .withIdentity(jobKey)
                    .usingJobData("apiUrl","http://www.baidu.com")
                    .build();
            */
            JobDetail job = this.getJobDetailFactoryBean(jobKey,api).getObject();
            /*
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("apiTrigger","api_trigger_group")
                    .build();
            */
            String cron = "0/5 * * * * ?";
            CronTrigger trigger = this.getBean(job,jobKey).getObject();
            scheduler.scheduleJob(job, trigger);
        }

        return "timer task add is ok,";
    }

    @RequestMapping("del")
    public String del()throws Exception{
        JobKey jobKey = new JobKey("apiJob","api_job_group");
        if(scheduler.checkExists(jobKey)){
            scheduler.deleteJob(jobKey);
            return "del job ok.";
        }
        return "del job error.";
    }


    private MethodInvokingJobDetailFactoryBean getJobDetailFactoryBean(JobKey jobKey,String api) throws Exception{
        MethodInvokingJobDetailFactoryBean bean = new MethodInvokingJobDetailFactoryBean();
        bean.setConcurrent(false);
        bean.setBeanName(jobKey.getName());
        bean.setGroup(jobKey.getGroup());
        bean.setTargetObject(jobObject);
        bean.setArguments(new Object[]{api});
        // bean.setTargetClass(ApiMethodJob.class);
        bean.setTargetMethod("run");
        bean.afterPropertiesSet();
        return bean;
    }

    private CronTriggerFactoryBean getBean(JobDetail job,JobKey jobKey) throws Exception{

        MethodInvokingJobDetailFactoryBean md = new MethodInvokingJobDetailFactoryBean();

        CronTriggerFactoryBean bean  = new CronTriggerFactoryBean();
        bean.setCronExpression("0/5 * * * * ?");
        bean.setStartDelay(0);
        bean.setBeanName("trigger"+jobKey.getName());
        bean.setGroup("trigger_group"+jobKey.getGroup());
        bean.setJobDetail(job);
        bean.afterPropertiesSet();
        return bean;
    }




}
