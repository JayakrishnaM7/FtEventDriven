
package com.ibm.poc.drollsvalidation;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.poc.model.FtRq;


@RestController

@RequestMapping
public class PanvalidationCtrl {
	Logger logger = LoggerFactory.getLogger(PanvalidationCtrl.class);
	@Autowired
	private final KieContainer kieContainer;

	public PanvalidationCtrl(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}
	@PostMapping("/validate")
	private FtRq validatePan(@RequestBody FtRq ftRequest) {
		logger.info("entering into PanvalidationdroolsController");
		logger.info("entering into /validate");
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.insert(ftRequest);
		kieSession.fireAllRules();
		kieSession.dispose();
		logger.info("isPanRequired --- " + ftRequest.isPanRequired());
		return ftRequest;
	}
}
