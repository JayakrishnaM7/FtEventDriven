package com.ibm.poc.process;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ibm.poc.uil.AppConstants;

@Service
public class BalanceProcess {
	Logger logger = LoggerFactory.getLogger(BalanceProcess.class);
	
	@Autowired
	private KafkaTemplate<String, String> kafkaTemp;

	public String balanceProcess(String payload) {
		//STEP-3 CORE BANKING API CALL
		ProducerRecord<String, String> pR = new ProducerRecord<String, String>
		(AppConstants.topicFTIN, "true");
		logger.info("Published message " + payload);
		this.kafkaTemp.send(pR);
		return "true";
	}
}
