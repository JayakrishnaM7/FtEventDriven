package com.ibm.poc.service;

import org.springframework.http.ResponseEntity;

import com.ibm.poc.model.FtRq;

public interface FtSelfTransferI {
	public ResponseEntity<?> ftSelfTransferprocess(FtRq ftRq);
}
