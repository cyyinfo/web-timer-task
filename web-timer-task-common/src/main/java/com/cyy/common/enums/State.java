package com.cyy.common.enums;

import org.quartz.DisallowConcurrentExecution;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Administrator on 2017/8/29.
 */
@EnableScheduling
@DisallowConcurrentExecution
public enum  State {
    STOP(1),
    RUN(2),
    DELETE(3)
    ;
    State(int code){
        this.code = code;
    }
    private int code;
}
