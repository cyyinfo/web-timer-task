package com.cyy.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * Created by Administrator on 2017/8/23.
 */
public class ParamUtil {

    private String body;

    private JSONObject data;

    public ParamUtil(String body){
        this.body = body;
        this.data = JSON.parseObject(this.body);
    }

    public String getString(String key){
        return  this.data.getString(key);
    }

}
