package com.ibm.poc.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.ibm.poc.consumer.FTinConsumer;
import com.ibm.poc.externalapi.Transaction;
import com.ibm.poc.model.FtRq;
import com.ibm.poc.publisher.AMLPublisher;
import com.ibm.poc.publisher.AadhaarPublisher;
import com.ibm.poc.publisher.BalanceLimitPublisher;
import com.ibm.poc.publisher.DailyLimitPublisher;
import com.ibm.poc.publisher.PanPublisher;
import com.ibm.poc.service.FtBankTransferNonupiI;

public class FtBankTransferNonupiImpl implements FtBankTransferNonupiI {
	Logger LOG = LoggerFactory.getLogger(FtBankTransferNonupiImpl.class);
	@Autowired
	AMLPublisher amlPublisher;
	@Autowired
	AadhaarPublisher aadhaarPublisher;
	@Autowired
	BalanceLimitPublisher balanceLimitPublisher;
	@Autowired
	DailyLimitPublisher dailyLimitPublisher;
	@Autowired
	PanPublisher panPublisher;

	@Autowired
	FTinConsumer fTinConsumer;
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	Transaction transaction;
	@Override
	public ResponseEntity<?> ftBankTransferNonupiprocess(FtRq ftRq) {
		amlPublisher.publishToTopicAMLVerification(ftRq);
		aadhaarPublisher.publishToTopicAadhaarVerification(ftRq);
		balanceLimitPublisher.publishToTopicBalanceLimitVerification(ftRq);
		dailyLimitPublisher.publishToTopicDailylimitVerification(ftRq);
		panPublisher.publishToTopicPANVerification(ftRq);
		ResponseEntity<String> response = null;
		try {
			Thread.sleep(5000);
			List<String> count = fTinConsumer.list;
			LOG.info("count :::" + count);
			
				if (count.get(0).equalsIgnoreCase("true") && count.get(0).equalsIgnoreCase("true")
						&& count.get(0).equalsIgnoreCase("true") && count.get(0).equalsIgnoreCase("true")
						&& count.get(0).equalsIgnoreCase("true")) {
					
					//STEP-1 : API CALL TO DEBIT INSTRUCTION
					// STEP-2 : API CALL TO CREDIT INSTRUCTION
					// STEP-3 : API CALL TO NOTIFY INSTRUCTION
					 response = new ResponseEntity(response, HttpStatus.OK);
				} else {
					ResponseEntity<?> rs = new ResponseEntity("", HttpStatus.BAD_REQUEST);
				}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;

	}

}
