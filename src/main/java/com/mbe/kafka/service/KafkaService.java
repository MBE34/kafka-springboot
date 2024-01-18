package com.mbe.kafka.service;

public interface KafkaService {
	
	public void sendMessage(String topicName, String message);

}
