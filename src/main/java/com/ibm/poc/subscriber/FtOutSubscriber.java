package com.ibm.poc.subscriber;

import java.time.Duration;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.ibm.poc.process.AadhaarProces;
import com.ibm.poc.process.AmlProcess;
import com.ibm.poc.process.BalanceProcess;
import com.ibm.poc.process.DailyLimitProcess;
import com.ibm.poc.process.PanProcess;
import com.ibm.poc.uil.AppConstants;

@Service
public class FtOutSubscriber {
	Logger LOG = LoggerFactory.getLogger(FtOutSubscriber.class);

	@Autowired
	KafkaConsumer<String, String> consumer;

	@Autowired
	AadhaarProces aadhaarProces;

	@Autowired
	AmlProcess amlProcess;

	@Autowired
	BalanceProcess balanceProcess;

	@Autowired
	DailyLimitProcess dailyLimitProcess;
	@Autowired
	PanProcess panProcess;

	@KafkaListener(topics = AppConstants.topicFTOUT)
	public void receive(@Payload String data, @Headers MessageHeaders messageHeaders) {
		messageHeaders.keySet().forEach(key -> {
			Object value = messageHeaders.get(key);
			if (key.equals(AppConstants.topicFTOUTAadhaarHeader)) {
				LOG.info("received message='{}'", data);
				aadhaarProces.aadhaarProcess(data);
				LOG.info(AppConstants.topicFTOUTAadhaarHeader + "{}: {}", key, new String((byte[]) value));
			}
		});

		//
		messageHeaders.keySet().forEach(key -> {
			Object value = messageHeaders.get(key);
			if (key.equals(AppConstants.topicFTOUTbalanceHeader)) {
				balanceProcess.balanceProcess(data);
				LOG.info("received message='{}'", data);
				LOG.info(AppConstants.topicFTOUTbalanceHeader + "{}: {}", key, new String((byte[]) value));
			}
		});
		//
		messageHeaders.keySet().forEach(key -> {
			Object value = messageHeaders.get(key);
			if (key.equals(AppConstants.topicFTOUTPanHeader)) {
				LOG.info("received message='{}'", data);
				panProcess.panProcess(data);
				LOG.info(AppConstants.topicFTOUTPanHeader + "{}: {}", key, new String((byte[]) value));
			}
		});
		messageHeaders.keySet().forEach(key -> {
			Object value = messageHeaders.get(key);
			if (key.equals(AppConstants.topicFTOUTDailyLimitHeader)) {
				dailyLimitProcess.dailyLimitProcess(data);
				LOG.info("received message='{}'", data);
				LOG.info(AppConstants.topicFTOUTDailyLimitHeader + "{}: {}", key, new String((byte[]) value));
			}
		});

		messageHeaders.keySet().forEach(key -> {
			Object value = messageHeaders.get(key);
			if (key.equals(AppConstants.topicFTOUTAMLHeader)) {
				amlProcess.amlProcess(data);
				LOG.info("received message='{}'", data);
				LOG.info(AppConstants.topicFTOUTAMLHeader + "{}: {}", key, new String((byte[]) value));
			}
		});

	}
}
