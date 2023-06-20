package com.ibm.poc.service;

import org.springframework.http.ResponseEntity;

import com.ibm.poc.model.FtRq;

public interface FtBillpaymentI {
	public ResponseEntity<?> ftBillpaymentIprocess(FtRq ftRq);
}
