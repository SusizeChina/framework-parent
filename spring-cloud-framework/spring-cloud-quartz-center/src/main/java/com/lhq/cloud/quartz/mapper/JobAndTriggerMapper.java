package com.lhq.cloud.quartz.mapper;

import com.lhq.cloud.quartz.entity.JobAndTrigger;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface JobAndTriggerMapper {
    public List<JobAndTrigger> getJobAndTriggerDetails();
}
