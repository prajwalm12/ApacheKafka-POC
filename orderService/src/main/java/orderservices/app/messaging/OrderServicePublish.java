package orderservices.app.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import orderservices.app.model.Order;
import orderservices.app.port.IOrderPublish;

@Service
public class OrderServicePublish implements IOrderPublish{

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	@Autowired
	private ObjectMapper objectMapper;
	public void sendOrder(Order order ) {
		// TODO Auto-generated method stub
		try {
			kafkaTemplate.send("OrderService",objectMapper.writeValueAsString(order));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
