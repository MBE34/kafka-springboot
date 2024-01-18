package com.mbe.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mbe.kafka.service.impl.KafkaServiceImpl;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
	
private final KafkaServiceImpl KafkaService;

	@Autowired
	public JsonMessageController(KafkaServiceImpl kafkaService) {
		super();
		KafkaService = kafkaService;
	}
	
	// http:localhost:8080/api/v1/kafka/publish?message=hello world?topicName=mbe
	@PostMapping("/publish")
	public ResponseEntity<String>  senMessage(@RequestParam("topicName") String topicName, @RequestParam("message") String message) {
		KafkaService.sendMessage(topicName, message);
		
		return ResponseEntity.ok("Json message sent to kafka topic");
		
		
	}	

}
