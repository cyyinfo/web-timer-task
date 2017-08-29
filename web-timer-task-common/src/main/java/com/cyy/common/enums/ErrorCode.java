package com.cyy.common.enums;

/**
 * Created by Administrator on 2017/8/23.
 */
public enum ErrorCode {
    ERROR(-1,"错误"),
    SUCCESS(200,"ok")
    ;
    ErrorCode(int code,String name){
        this.code = code;
        this.name = name;
    }
    private int code;

    private String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
