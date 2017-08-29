package com.cyy.dao.timertask;

import com.cyy.model.task.TimerTask;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by Administrator on 2017/8/29.
 */
@Mapper
public interface TimerTaskMapper {

    List<TimerTask> find(TimerTask search);

    int add(TimerTask model);

    int update(TimerTask model);
}
