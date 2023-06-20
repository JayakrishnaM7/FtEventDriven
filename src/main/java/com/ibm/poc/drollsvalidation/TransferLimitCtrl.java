package com.ibm.poc.drollsvalidation;


import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.poc.model.FtRq;


@RestController
@RequestMapping
public class TransferLimitCtrl {
	Logger logger = LoggerFactory.getLogger(TransferLimitCtrl.class);
	private final KieContainer kieContainer;

	public TransferLimitCtrl(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	@PostMapping("/limitvalidate")
	private FtRq validateTransferLimit(@RequestBody FtRq ftRequest) {
		logger.info("entering into TransferLimitValidationController");
		logger.info("entering into /validate");
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(ftRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		logger.info("transfer limit check --- " + ftRequest.isLimitCheck());
		return ftRequest;
	}
}
