package com.lhq.cloud.quartz.service;

import com.github.pagehelper.PageInfo;
import com.lhq.cloud.quartz.entity.JobAndTrigger;

public interface IJobService {
    public PageInfo<JobAndTrigger> getJobAndTriggerDetails(int pageNum, int pageSize);

    public void addJob(String jobClassName, String jobGroupName, String cronExpression) throws Exception;

    public void jobPause(String jobClassName, String jobGroupName) throws Exception;

    public void jobresume(String jobClassName, String jobGroupName) throws Exception;

    public void jobreschedule(String jobClassName, String jobGroupName, String cronExpression) throws Exception;

    public void jobdelete(String jobClassName, String jobGroupName) throws Exception;
}
