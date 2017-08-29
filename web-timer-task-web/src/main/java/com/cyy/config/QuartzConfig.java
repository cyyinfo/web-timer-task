package com.cyy.config;


import org.quartz.Scheduler;
import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.*;

/**
 * Created by Administrator on 2017/8/28.
 */
@Configuration
public class QuartzConfig {

    @Bean
    public Scheduler scheduled(ApplicationContext applicationContext) throws Exception{

        AutowiringSpringBeanJobFactory jobFactory = new AutowiringSpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);

        SchedulerFactoryBean  factory = new SchedulerFactoryBean();
        factory.setJobFactory(jobFactory);
        factory.setOverwriteExistingJobs(true);
        factory.setStartupDelay(0); // 启动
        factory.setAutoStartup(true);
        factory.setApplicationContext(applicationContext);
        factory.setWaitForJobsToCompleteOnShutdown(true);
        factory.afterPropertiesSet();
        factory.start();
        return factory.getScheduler();
    }


    private class AutowiringSpringBeanJobFactory extends SpringBeanJobFactory implements ApplicationContextAware{

        private transient AutowireCapableBeanFactory beanFactory;

        @Override
        public void setApplicationContext(final ApplicationContext context) {
            beanFactory = context.getAutowireCapableBeanFactory();
        }

        @Override
        protected Object createJobInstance(final TriggerFiredBundle bundle)
                throws Exception {
            final Object job = super.createJobInstance(bundle);
            beanFactory.autowireBean(job);
            return job;
        }
    }

}
