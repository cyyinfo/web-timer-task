package com.cyy.model;

/**
 * Created by Administrator on 2017/8/22.
 */
public class BaseModel {

    private Long id;

    private String code;

    private String data; // 具体数据

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
