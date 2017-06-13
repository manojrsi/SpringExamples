package com.retry.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import com.retry.exception.ApplicationException;

/**
 * Web service client class.
 */
@Service
public class WebServiceClientSimulation {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationService.class);

	public String invoke() throws ApplicationException {
		// Simulate the implementation
		LOGGER.info("Web Service was called and executed" );

		if (true) {
			// An internal error has been occurred
			throw new ApplicationException();
		}

		return "Success";
	}
}
