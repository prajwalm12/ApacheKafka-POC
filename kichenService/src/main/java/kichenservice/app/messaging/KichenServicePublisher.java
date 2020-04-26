package kichenservice.app.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kichenservice.app.model.Order;

@Service
public class KichenServicePublisher {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public void sendToOrderServiceCallBack(Order order) {
		
		try {
			kafkaTemplate.send("OrderCallbackService",objectMapper.writeValueAsString(order));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendToDelivaryService(Order order) {
		
		try {
			kafkaTemplate.send("DeliveryService",objectMapper.writeValueAsString(order));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
