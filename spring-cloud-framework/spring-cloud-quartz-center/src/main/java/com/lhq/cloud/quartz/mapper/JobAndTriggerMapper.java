package com.lhq.cloud.quartz.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.lhq.cloud.quartz.entity.JobAndTrigger;

@Mapper
public interface JobAndTriggerMapper {
	public List<JobAndTrigger> getJobAndTriggerDetails();
}
