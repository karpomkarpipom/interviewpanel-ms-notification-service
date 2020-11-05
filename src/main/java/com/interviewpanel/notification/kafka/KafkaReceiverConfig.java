package com.interviewpanel.notification.kafka;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.common.TopicPartition;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ErrorHandler;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.interviewpanel.user.bean.User;


@Configuration
@EnableKafka
public class KafkaReceiverConfig {
	/*
	 * @Value("${spring.kafka.bootstrap-servers}") private String bootstrapServers;
	 * 
	 * @Value("${spring.kafka.consumer.group-id}") private String consumerGroupId;
	 * 
	 * 
	 * @Bean public Map<String, Object> consumerConfigs() { Map<String, Object>
	 * props = new HashMap<>(); props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
	 * bootstrapServers); props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	 * StringDeserializer.class);
	 * props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	 * JsonDeserializer.class); props.put(ConsumerConfig.GROUP_ID_CONFIG,
	 * consumerGroupId);
	 * 
	 * return props; }
	 * 
	 * @Bean public ConsumerFactory<String, User> consumerFactory() {
	 * JsonDeserializer<User> jsonDeserializer=new JsonDeserializer<>(User.class);
	 * jsonDeserializer.addTrustedPackages("*");
	 * 
	 * return new DefaultKafkaConsumerFactory<>(consumerConfigs(), new
	 * StringDeserializer(), jsonDeserializer); }
	 * 
	 * @Bean public ConcurrentKafkaListenerContainerFactory<String, User>
	 * kafkaListenerContainerFactory() {
	 * ConcurrentKafkaListenerContainerFactory<String, User> factory = new
	 * ConcurrentKafkaListenerContainerFactory<>(); factory.setConsumerFactory(
	 * consumerFactory());
	 * 
	 * factory.setErrorHandler(new ErrorHandler() { public void handle(Exception
	 * thrownException, List<ConsumerRecord<?, ?>> records, Consumer<?, ?> consumer,
	 * MessageListenerContainer container) { String s =
	 * thrownException.getMessage().
	 * split("Error deserializing key/value for partition ")[1].
	 * split(". If needed, please seek past the record to continue consumption.")[0]
	 * ; String topics = s.split("-")[0]; int offset =
	 * Integer.valueOf(s.split("offset ")[1]); int partition =
	 * Integer.valueOf(s.split("-")[1].split(" at")[0]);
	 * 
	 * TopicPartition topicPartition = new TopicPartition(topics, partition);
	 * //log.info("Skipping " + topic + "-" + partition + " offset " + offset);
	 * consumer.seek(topicPartition, offset + 1); System.out.println(
	 * "throwException : : : "+thrownException.getMessage()); }
	 * 
	 * @Override public void handle(Exception e, ConsumerRecord<?, ?>
	 * consumerRecord) {
	 * 
	 * }
	 * 
	 * @Override public void handle(Exception e, ConsumerRecord<?, ?>
	 * consumerRecord, Consumer<?,?> consumer) { String s =
	 * e.getMessage().split("Error deserializing key/value for partition ")[1].
	 * split(". If needed, please seek past the record to continue consumption.")[0]
	 * ; String topics = s.split("-")[0]; int offset =
	 * Integer.valueOf(s.split("offset ")[1]); int partition =
	 * Integer.valueOf(s.split("-")[1].split(" at")[0]);
	 * 
	 * TopicPartition topicPartition = new TopicPartition(topics, partition);
	 * //log.info("Skipping " + topic + "-" + partition + " offset " + offset);
	 * consumer.seek(topicPartition, offset + 1); System.out.println(
	 * e.getMessage());
	 * 
	 * 
	 * } });
	 * 
	 * 
	 * return factory; }
	 */

    @Bean
    public KafkaReceiver receiver() {
        return new KafkaReceiver();
    }
}