package com.cyy.common.job;

import com.cyy.common.service.PropertiesValue;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by Administrator on 2017/8/28.
 */
public class ApiJob implements Job {

    Logger logger = LoggerFactory.getLogger(ApiJob.class);

    @Resource
    private PropertiesValue value;

    public void execute(JobExecutionContext context){

        JobDataMap res = context.getJobDetail().getJobDataMap();

        int yc = new Random().nextInt(10);
        logger.info("seelp:" + yc +" s");
        try {
            Thread.sleep(yc * 1000);
        }catch (Exception e){
        }
        logger.info("job server value = " + value);

        if(res == null){
            logger.info("jobData is null;");
            return ;
        }
        String [] keys = res.getKeys();
        for(String key : keys){
            System.out.println(key+"="+res.get(key));
        }
        logger.info("job  is run jobData="+res);

    }

    public void run(){
        logger.info("this is run function，value="+value);
    }
}
