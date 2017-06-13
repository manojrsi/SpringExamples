package com.retry.config;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.retry.backoff.FixedBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

import com.retry.exception.ApplicationException;

@SpringBootApplication
@EnableRetry
@ComponentScan(basePackages = { "com.retry" })
@PropertySource(value="classpath:application.properties")
public class SpringRetryApplication {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringRetryApplication.class);
	
	@Value("${retryCount:3}")
	public int retryCount;
	
	@Value("${retryDelay:3}")
	public int retryDelay;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringRetryApplication.class, args);
	}
	
    @Bean
    public RetryTemplate retryTemplate() {
    	//Adding Specific Exception 
    	Map<Class<? extends Throwable>,Boolean> exceptionMap = new HashMap<Class<? extends Throwable>,Boolean>();
    	exceptionMap.put(ApplicationException.class, true);
    	
    	SimpleRetryPolicy retryPolicy = new SimpleRetryPolicy(retryCount, exceptionMap, true);//retryCount=3 from application.properties 
        
    	LOGGER.info("retryCount: "+retryCount);
    	LOGGER.info("retryDelay: "+retryDelay);
    	
        FixedBackOffPolicy backOffPolicy = new FixedBackOffPolicy();
        backOffPolicy.setBackOffPeriod(retryDelay); // retryDelay=1.5 seconds delay

        RetryTemplate template = new RetryTemplate();
        template.setRetryPolicy(retryPolicy);
        template.setBackOffPolicy(backOffPolicy);
        
        return template;
    }
    
}
