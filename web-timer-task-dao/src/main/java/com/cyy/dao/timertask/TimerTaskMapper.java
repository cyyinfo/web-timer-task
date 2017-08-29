package com.cyy.dao.timertask;

import com.cyy.model.task.TimerTask;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
public interface TimerTaskMapper {

    List<TimerTask> find(TimerTask search);

    int add(TimerTask model);

    int update(TimerTask model);
}
