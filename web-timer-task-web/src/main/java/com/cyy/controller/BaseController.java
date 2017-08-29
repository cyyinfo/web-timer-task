package com.cyy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.cyy.common.enums.ErrorCode;
import com.cyy.common.util.ParamUtil;
import com.github.pagehelper.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23.
 */
public class BaseController {

    public ParamUtil getParamUtil(String body){
        return new ParamUtil(body);
    }


    public String error(ErrorCode code,String msg,JSONObject data){
        JSONObject json = new JSONObject();
        json.put("code",code.getCode());
        json.put("msg",msg);
        if(data != null){
            json.put("data",data);
        }
        return json.toJSONString();
    }
    public String error(String msg){
        return error(ErrorCode.ERROR,msg,null);
    }

    public String success(JSONObject data){
        return error(ErrorCode.SUCCESS,"ok",data);
    }

    public String success(){
        return error(ErrorCode.SUCCESS,"ok",null);
    }

    public <T> String success(List<T> lists){
        JSONObject json = new JSONObject();
        JSONArray data = new JSONArray();
        if(lists != null && lists.size() > 0 ){
            for(T t : lists){
                data.add(JSON.toJSON(t));
            }
        }
        json.put("lists",data);
        return success(json);
    }

    public <T> String success(Page<T> page){
        JSONObject json = new JSONObject();
        json.put("totalPage",page.getPages());
        json.put("totalRow",page.getTotal());
        JSONArray data = new JSONArray();
        if(page != null && page.size() > 0 ){
            for(T t : page){
                data.add(JSON.toJSON(t));
            }
        }
        json.put("list",data);
        return success(json);
    }

    public <T> T getModel(Class<T> cls,String body){
        return JSON.parseObject(body,cls);
    }

}
