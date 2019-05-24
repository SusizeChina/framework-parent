package com.lhq.cloud.quartz.core;

import java.util.Date;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class BaseJob implements Job {
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("test" + new Date().toString());
	};
}
