package com.cyy.service.timertask.impl;

import com.cyy.dao.timertask.TimerTaskMapper;
import com.cyy.model.task.TimerTask;
import com.cyy.service.BaseService;
import com.cyy.service.timertask.TimerTaskService;
import com.github.pagehelper.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/8/29.
 */
@Service
public class TimerTaskServiceImpl extends BaseService implements TimerTaskService {

    @Resource
    private TimerTaskMapper timerTaskMapper;

    public Page<TimerTask> find(TimerTask search,int currPage,int pageSize){
        this.setPage(currPage,pageSize);
        return (Page<TimerTask>) timerTaskMapper.find(search);
    }

    public boolean add(TimerTask model){
        int row = timerTaskMapper.add(model);
        return row > 0;
    }

    public boolean update(Long id,TimerTask model){
        model.setId(id);
        int row = timerTaskMapper.update(model);
        return row > 0;
    }
}
