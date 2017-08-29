package com.cyy.common.job;

import com.cyy.common.service.PropertiesValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Random;

/**
 * Created by Administrator on 2017/8/29.
 */
@Configuration
@Component // 此注解必加
@EnableScheduling // 此注解必加
public class ApiMethodJob {

    Logger logger = LoggerFactory.getLogger(ApiJob.class);

    @Resource
    private PropertiesValue value;

    public void run(String api){

        int yc = new Random().nextInt(10);
        logger.info("seelp:" + yc +" s,api:"+api);
        try {
            Thread.sleep(yc * 1000);
        }catch (Exception e){
        }
        logger.info("this is run function，value="+value);
    }
}
