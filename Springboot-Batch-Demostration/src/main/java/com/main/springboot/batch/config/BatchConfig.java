/**
 * Code developed by Ashfaq (© [Year])
 * GitHub: https://github.com/DarkSharkAsh
 */

package com.main.springboot.batch.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.main.springboot.batch.model.Product;

@Configuration
public class BatchConfig {

	@Bean
	public Job jobBean(JobRepository jobRepository, JobCompleteionNotificationImpl listener, Step steps) {

		// IMP Note

		// 1 JobRepository bean here will automatically autowire no need to do a
		// seperate bean, and its implementation
		// class will be autowired this for Job meta data

		// 2 listener to add this we will have to implement JobExecutionListener and
		// overide before and after methods
		// and then pass the class name i.e JobCompleteionNotificationImpl and it will
		// automatically autowire here as its already
		// a componenet and its dependency is already satisfied

		// 3 steps to give it,actually its a bean so we will define a step bean and pass
		// here

		return new JobBuilder("jobCSV", jobRepository).// name of the job and jobRepository
				listener(listener)// to listen and do anything when the job starts or the job ends
				.start(steps).build();

	}

	@Bean
	public Step steps(JobRepository jobRepository, DataSourceTransactionManager transactionManager
			,FlatFileItemReader<Product> reader
			) {

		return new StepBuilder("JobStep", jobRepository).chunk(5, transactionManager).// in how many steps or peices of
																						// source data will be go
				reader(reader).// we have many files to read but we will use flatfileItemReader and need to
							// define a model which will have all the columns in the csv file
				processor().writer().build();
	}

	@Bean
	public FlatFileItemReader<Product> reader() {

		return new FlatFileItemReaderBuilder<Product>().name("itemReader").resource(new ClassPathResource("data.csv"))
				.delimited().names("productId", "title", "description", "price", "discount").targetType(Product.class)
				.build();

	}
}
