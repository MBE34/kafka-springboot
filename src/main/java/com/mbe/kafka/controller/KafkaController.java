package com.mbe.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbe.kafka.service.impl.KafkaServiceImpl;

@RestController
@RequestMapping("/api/v1/kafka")
public class KafkaController {
	
	
	private final KafkaServiceImpl KafkaService;  
	
	@Autowired
	public KafkaController(KafkaServiceImpl kafkaService) {
		super();
		KafkaService = kafkaService;
	}
	// http:localhost:8080/api/v1/kafka/publish?message=hello world?topicName=mbe
    @GetMapping("/publish")
	public ResponseEntity<String> senMessage(@RequestParam("topicName") String topicName, @RequestParam("message") String message) {
		KafkaService.sendMessage(topicName, message);
		return ResponseEntity.ok("Message sent!");
		
		
	}
	
}
