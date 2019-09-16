package com.lhq.cloud.quartz.core;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Date;

public class BaseJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("test" + new Date().toString());
    }

    ;
}
