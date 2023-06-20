package com.ibm.poc.publisher;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ibm.poc.model.FtRq;
import com.ibm.poc.uil.AppConstants;
@Service
public class DailyLimitPublisher {
	Logger logger = LoggerFactory.getLogger(DailyLimitPublisher.class);
	@Autowired
	private KafkaTemplate<String, String> kafkaTemp;
	public void publishToTopicDailylimitVerification(FtRq fundtransferRequest) {
		ProducerRecord<String, String> pR = new ProducerRecord<String, String>(AppConstants.topicFTOUT, fundtransferRequest.toString());
		byte[] h0 = AppConstants.topicFTOUTDailyLimitHeader.getBytes();
		pR.headers().add(AppConstants.topicFTOUTDailyLimitHeader, h0);
		logger.info("Publishing to topic " + AppConstants.topicFTOUT+ " :: header-name is " + AppConstants.topicFTOUTDailyLimitHeader);
		logger.info("Published message " + fundtransferRequest);
		this.kafkaTemp.send(pR);
	}
}
