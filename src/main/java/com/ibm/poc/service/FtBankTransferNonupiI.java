package com.ibm.poc.service;

import org.springframework.http.ResponseEntity;

import com.ibm.poc.model.FtRq;

public interface FtBankTransferNonupiI {
	public ResponseEntity<?> ftBankTransferNonupiprocess(FtRq ftRq);

}
