package com.retry.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.retry.exception.ApplicationException;
import com.retry.service.ApplicationService;

@RestController
@RequestMapping("/test")
public class RetryController {

	private static final Logger LOGGER = LoggerFactory.getLogger(RetryController.class);

	/** TEST_RETRY */
	private static final String TEST_RETRY = "/retry";

	@Autowired
	ApplicationService applicationService;

	@RequestMapping(value = TEST_RETRY, method = RequestMethod.GET)
	public ResponseEntity<?> retry() {
		LOGGER.info("++ retry request calling ++");
		try{
			applicationService.callTheWebService();
			//applicationService.callTheWebServiceWithLambda();
			//applicationService.callTheWebServiceWithRecovery();
			
		} catch(ApplicationException applicationException){
			LOGGER.error("ApplicationException caught : "+applicationException.getMessage());
		}

		return new ResponseEntity<String>("Successfull", HttpStatus.OK);
	} 

}