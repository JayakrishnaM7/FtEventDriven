package com.ibm.poc.service;

import org.springframework.http.ResponseEntity;

import com.ibm.poc.model.FtRq;

public interface FtRepeatPaymentI {
	public ResponseEntity<?> ftRepeatPaymentIprocess(FtRq ftRq);
}
