package com.ibm.poc.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.poc.model.Account2accountRs;
import com.ibm.poc.model.FtRq;
import com.ibm.poc.service.FtUpipaymentI;
import com.ibm.poc.uil.AppConstants;

@RestController
@RequestMapping("/api/v1/bian-3/core/payment/debitor/10.0.0/")
public class UpiPayment {
	Logger logger = LoggerFactory.getLogger(FtBankTransferNonupiApi.class);
	@Autowired
	FtUpipaymentI ftUpipaymentI;
	@PostMapping(path = "/ftUpipayment")
	public ResponseEntity<?> ftUpipayment(@RequestBody FtRq ftRq) throws Exception {
		ResponseEntity<?> rs=ftUpipaymentI.ftUpipaymentProcess(ftRq);
		Account2accountRs account2accountRs=new Account2accountRs();
		Thread.sleep(2000);
		logger.info("rs.getStatusCode() :"+rs.getStatusCode());
		//if(rs.getStatusCode().equals("200")) {
			//1. core banking api call to Executr Debit instruction
			//2. core banking api call to Executr Credit instruction
			//3. core banking api call to Notify API
			Account2accountRs response=fundtransferRequest(ftRq);
			account2accountRs.setAccountId(response.getAccountId());
			account2accountRs.setMessage(response.getMessage());
			account2accountRs.setResponseStatuscode(response.getResponseStatuscode());
			account2accountRs.setTransferDetails(response.getTransferDetails());
			
	//	}
		return ResponseEntity.status(200).body(account2accountRs);

	}
	public Account2accountRs fundtransferRequest(FtRq fundtransferRq) {
		Account2accountRs rs = new Account2accountRs();
		rs.setAccountId(fundtransferRq.getAccountId());
		rs.setMessage(AppConstants.message_success);
		rs.setResponseStatuscode(AppConstants.response_status_code);
		rs.setTransferDetails("transfer successful");
		return rs;

	}
}


