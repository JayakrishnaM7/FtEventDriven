package com.ibm.poc.consumer;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.ibm.poc.uil.AppConstants;
@Service
public class FTinConsumer {
	public static List<String> list=new ArrayList<>();
	Logger logger = LoggerFactory.getLogger(FTinConsumer.class);
	@KafkaListener(topics = AppConstants.topicFTIN, groupId =AppConstants.topicFTINgroup)
	public void consumer(ConsumerRecord<String, String> events) {
		logger.info("entering into FTIN consumer");
		String paylaod = events.value();
		list.add(paylaod);
		logger.info("consumer message  :" + paylaod);
	}
}
