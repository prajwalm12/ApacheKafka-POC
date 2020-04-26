package kichenservice.app.business;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kichenservice.app.messaging.KichenServicePublisher;
import kichenservice.app.model.Order;

@Service
public class KichenConsumerFromOrder {

	private static final Logger logger = LoggerFactory.getLogger(KichenConsumerFromOrder.class);
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private KichenService kichenService;
	@Autowired
	private KichenServicePublisher kichenServicePublisher;
	@KafkaListener(topics="OrderService",groupId = "group_id")
	public void consumeMessage(String content) {
		
		try {
			Order order = objectMapper.readValue(content,Order.class);
			boolean started = kichenService.processRecievedOrder(order);
			if(started) {
				logger.info("Start cooking for order id "+order.getId()+" start");
				order.setStatus("Processed and Sent for deivery");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                logger.info("Packaging start");
				kichenServicePublisher.sendToOrderServiceCallBack(order);
				logger.info("Callback to order service sent");
				kichenServicePublisher.sendToDelivaryService(order);
				logger.info("Order id "+order.getId()+" sent to delivery");
			}else
			{
				order.setStatus("Aborted");
				kichenServicePublisher.sendToOrderServiceCallBack(order);
				logger.info("Order id "+order.getId()+"has been aborted");
				
			}
			
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
