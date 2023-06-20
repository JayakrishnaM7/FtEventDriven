package com.ibm.poc.externalapi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.ibm.poc.model.FtRq;
import com.ibm.poc.model.TransferRequest;


public class Transaction {
	Logger logger = LoggerFactory.getLogger(Transaction.class);
	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<String> fundtransferApi(FtRq rq) {

		logger.info("entering into fundtransferApi");
		ResponseEntity<String> initiateResponse = null;
		HttpEntity<FtRq> entity=new HttpEntity<FtRq>(rq);
		try {
			initiateResponse = restTemplate.exchange(
					"http://20.248.142.251:8080/api/v1/transfer", HttpMethod.POST, entity,
					String.class);
		} catch (RestClientException e) {
			logger.info("error at fundtransfer API  ");
			e.printStackTrace();
		}
		logger.info("sent response successful  ::"+initiateResponse);
		return initiateResponse;

	}
	public ResponseEntity<String> fundtransferFailedApi(TransferRequest rq) {
		return new ResponseEntity<String>("fundtransfer unsuccessful", null, 201);
		
	}
	public ResponseEntity<String> fundtransferFailedApiLimitExceeded(TransferRequest rq) {
		return new ResponseEntity<String>("Day transfer not exceed 2,50,000", null, 201);
		
	}
}
