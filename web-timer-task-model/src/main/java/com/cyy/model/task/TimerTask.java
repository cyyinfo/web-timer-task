package com.cyy.model.task;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/29.
 */
public class TimerTask extends com.cyy.model.BaseModel{

    private Long id;

    private String name;

    private String description;

    private String cron;

    private int timeout;

    private String httpApiUrl;

    private int typeId;

    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date lastExecuteTimer;

    private int lastResult;

    private int concurrent;

    private int state;

    private Date createDate;

    private Date modifyDate;


    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getHttpApiUrl() {
        return httpApiUrl;
    }

    public void setHttpApiUrl(String httpApiUrl) {
        this.httpApiUrl = httpApiUrl;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public Date getLastExecuteTimer() {
        return lastExecuteTimer;
    }

    public void setLastExecuteTimer(Date lastExecuteTimer) {
        this.lastExecuteTimer = lastExecuteTimer;
    }

    public int getLastResult() {
        return lastResult;
    }

    public void setLastResult(int lastResult) {
        this.lastResult = lastResult;
    }

    public int getConcurrent() {
        return concurrent;
    }

    public void setConcurrent(int concurrent) {
        this.concurrent = concurrent;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }
}
