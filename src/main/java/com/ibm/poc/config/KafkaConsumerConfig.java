/*
 * package com.ibm.poc.config;
 * 
 * import java.util.HashMap; import java.util.Map; import java.util.Properties;
 * 
 * import org.apache.kafka.clients.consumer.ConsumerConfig; import
 * org.apache.kafka.clients.consumer.KafkaConsumer; import
 * org.apache.kafka.common.serialization.StringDeserializer; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
 * import org.springframework.kafka.config.KafkaListenerContainerFactory; import
 * org.springframework.kafka.core.ConsumerFactory; import
 * org.springframework.kafka.core.DefaultKafkaConsumerFactory; import
 * org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
 * 
 * @Configuration public class KafkaConsumerConfig {
 * 
 * // @Value("${io.reflectoring.kafka.bootstrap-servers}") private String
 * bootstrapServers="localhost:9092";
 * 
 * @Bean public Map<String, Object> consumerConfigs() { Map<String, Object>
 * props = new HashMap<>(); props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
 * bootstrapServers); props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
 * StringDeserializer.class); return props; }
 * 
 * @Bean public ConsumerFactory<String, String> consumerFactory() { return new
 * DefaultKafkaConsumerFactory<>(consumerConfigs()); }
 * 
 * @Bean public
 * KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<String,
 * String>> kafkaListenerContainerFactory() {
 * ConcurrentKafkaListenerContainerFactory<String, String> factory = new
 * ConcurrentKafkaListenerContainerFactory<>();
 * factory.setConsumerFactory(consumerFactory()); return factory; }
 * 
 * @Bean public KafkaConsumer<String, String> kafkaConsumer() { Properties
 * properties = new Properties();
 * properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
 * properties.put(ConsumerConfig.GROUP_ID_CONFIG, "my-group-id");
 * properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
 * "org.apache.kafka.common.serialization.StringDeserializer");
 * properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
 * "org.apache.kafka.common.serialization.StringDeserializer");
 * 
 * return new KafkaConsumer<>(properties); }
 * 
 * }
 */