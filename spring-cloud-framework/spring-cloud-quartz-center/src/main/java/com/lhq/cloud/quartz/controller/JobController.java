package com.lhq.cloud.quartz.controller;

import com.github.pagehelper.PageInfo;
import com.lhq.cloud.quartz.entity.JobAndTrigger;
import com.lhq.cloud.quartz.service.IJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/job")
public class JobController {
    @Autowired
    private IJobService iJobService;

    @PostMapping(value = "/addjob")
    public void addjob(@RequestParam(value = "jobClassName") String jobClassName,
                       @RequestParam(value = "jobGroupName") String jobGroupName,
                       @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
        iJobService.addJob(jobClassName, jobGroupName, cronExpression);
    }

    @PostMapping(value = "/pausejob")
    public void pausejob(@RequestParam(value = "jobClassName") String jobClassName,
                         @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        iJobService.jobPause(jobClassName, jobGroupName);
    }

    @PostMapping(value = "/resumejob")
    public void resumejob(@RequestParam(value = "jobClassName") String jobClassName,
                          @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        iJobService.jobresume(jobClassName, jobGroupName);
    }

    @PostMapping(value = "/reschedulejob")
    public void rescheduleJob(@RequestParam(value = "jobClassName") String jobClassName,
                              @RequestParam(value = "jobGroupName") String jobGroupName,
                              @RequestParam(value = "cronExpression") String cronExpression) throws Exception {
        iJobService.jobreschedule(jobClassName, jobGroupName, cronExpression);
    }

    @PostMapping(value = "/deletejob")
    public void deletejob(@RequestParam(value = "jobClassName") String jobClassName,
                          @RequestParam(value = "jobGroupName") String jobGroupName) throws Exception {
        iJobService.jobdelete(jobClassName, jobGroupName);
    }

    @GetMapping(value = "/queryjob")
    public Map<String, Object> queryjob(@RequestParam(value = "pageNum") Integer pageNum,
                                        @RequestParam(value = "pageSize") Integer pageSize) {
        PageInfo<JobAndTrigger> jobAndTrigger = iJobService.getJobAndTriggerDetails(pageNum, pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("JobAndTrigger", jobAndTrigger);
        map.put("number", jobAndTrigger.getTotal());
        return map;
    }

}
