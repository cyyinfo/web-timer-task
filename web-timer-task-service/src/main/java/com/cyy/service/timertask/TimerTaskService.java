package com.cyy.service.timertask;

import com.cyy.model.task.TimerTask;
import com.github.pagehelper.Page;

import java.util.Timer;

/**
 * Created by Administrator on 2017/8/29.
 */
public interface TimerTaskService {

    Page<TimerTask> find(TimerTask search,int currPage,int pageSize);

    boolean add(TimerTask model);

    boolean update(Long id,TimerTask model);
}
