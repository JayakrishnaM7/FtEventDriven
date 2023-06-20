package com.ibm.poc.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.ibm.poc.externalapi.Transaction;
import com.ibm.poc.impl.FtBankTransferNonupiImpl;
import com.ibm.poc.impl.FtBillpaymentImpl;
import com.ibm.poc.impl.FtRepeatPaymentImpl;
import com.ibm.poc.impl.FtSelfTransferImpl;
import com.ibm.poc.impl.FtUpipaymentImpl;
import com.ibm.poc.service.FtBankTransferNonupiI;
import com.ibm.poc.service.FtBillpaymentI;
import com.ibm.poc.service.FtRepeatPaymentI;
import com.ibm.poc.service.FtSelfTransferI;
import com.ibm.poc.service.FtUpipaymentI;

@Configuration
public class ModelConfig {

	@Bean
	public FtBankTransferNonupiI ftBankTransferNonupiI() {
		return new FtBankTransferNonupiImpl();
	}

	@Bean
	public FtRepeatPaymentI ftRepeatPaymentI() {
		return new FtRepeatPaymentImpl();
	}

	@Bean
	public FtBillpaymentI ftBillpaymentI() {
		return new FtBillpaymentImpl();
	}

	@Bean
	public FtSelfTransferI ftSelfTransferI() {
		return new FtSelfTransferImpl();
	}

	@Bean
	public FtUpipaymentI ftUpipaymentI() {
		return new FtUpipaymentImpl();
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	@Bean
	public Transaction transaction() {
		return new Transaction();
	}
}
