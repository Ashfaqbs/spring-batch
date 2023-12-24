/**
 * Code developed by Ashfaq (© [Year])
 * GitHub: https://github.com/DarkSharkAsh
 */



package com.main.springboot.batch.config;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.stereotype.Component;

@Component
public class JobCompleteionNotificationImpl implements JobExecutionListener{
@Override
public void afterJob(JobExecution jobExecution) {
	// TODO Auto-generated method stub
	JobExecutionListener.super.afterJob(jobExecution);
}

@Override
	public void beforeJob(JobExecution jobExecution) {
		// TODO Auto-generated method stub
		JobExecutionListener.super.beforeJob(jobExecution);
	}


}
