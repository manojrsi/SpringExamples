package com.retry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.RecoveryCallback;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Service;

import com.retry.exception.ApplicationException;

/**
 * Application service class. In the "callTheWebService" method,
 * the web service client is invoked with retry template
 */

@Service
public class ApplicationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationService.class);
	
	static int count = 0;

	@Autowired
	private WebServiceClientSimulation	webServiceClientSimulation;

	@Autowired
	private RetryTemplate retryTemplate;

	/**
	 * Using JDK 8 
	 * @return
	 */
	public String callTheWebServiceWithLambda() throws ApplicationException {
		LOGGER.info("++ Calling retry with lambda before");
		// Call the web service with retry
		return retryTemplate.execute(
				( RetryCallback< String, ApplicationException > ) retryContext -> webServiceClientSimulation.invoke(),
				retryContext -> "Unsuccess. The retry reached maximum retry count :" + retryContext.getRetryCount() );

	}

	/**
	 * Retry Method callTheWebService without recovery
	 * 
	 * @return String
	 */
	public String callTheWebService() throws ApplicationException {
		count = 0;
		retryTemplate.execute(new RetryCallback<Void, ApplicationException>() {
			public Void doWithRetry(RetryContext context) throws ApplicationException {
				LOGGER.info("++ Calling retry before");
				LOGGER.info("Count : "+count);
				count++;

				webServiceClientSimulation.invoke();

				LOGGER.info("-- Calling retry before");
				return null;
			}        	
		});

		return "Success Retry";
	}


	/**
	 * Retry Method callTheWebService with recovery
	 * 
	 */
	public void callTheWebServiceWithRecovery() throws ApplicationException {
		count = 0;
		retryTemplate.execute(new RetryCallback<Void, ApplicationException>() {
			public Void doWithRetry(RetryContext context) throws ApplicationException {
				LOGGER.info("++ Calling retry with recovery before");
				LOGGER.info("Count : "+count);
				count++;

				webServiceClientSimulation.invoke();

				LOGGER.info("++ Calling retry with recovery before");
				return null;
			}
		} ,new RecoveryCallback<Void>() {
			public Void recover(RetryContext context) throws Exception {
				LOGGER.info("Calling recovery callback");
				return null;
			}			
		});

	}
}
