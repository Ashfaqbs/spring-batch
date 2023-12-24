/**
 * Code developed by Ashfaq (© [Year])
 * GitHub: https://github.com/DarkSharkAsh
 */



package com.main.springboot.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BatchConfig {

	@Bean
	public Job jobBean()
	{
		
		
		
		return new JobBuilder("jobCSV",jobRepository).//name of the job and jobRepository
				listener(listener) 
		
	}
	
	
	
}
