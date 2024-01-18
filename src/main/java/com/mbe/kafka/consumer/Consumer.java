package com.mbe.kafka.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	
	@KafkaListener(topics = {"myTopic", "mbe"}, groupId = "spring-boot-kafka")
    public void consume(ConsumerRecord<Integer, String> record) {
      System.out.println("received = " + record.value() + " with key " + record.key());
    }	
	
}
