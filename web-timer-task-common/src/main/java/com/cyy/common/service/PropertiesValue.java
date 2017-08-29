package com.cyy.common.service;

import org.springframework.stereotype.Component;


/**
 * 所有的配置都写这里
 * @author Administrator
 */
@Component
public class PropertiesValue {


    private String test = "abc";


    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    @Override
    public String toString() {
        return "PropertiesValue={test:"+this.test+"}";
    }
}
