package deliveryservice.app.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import deliveryservice.app.messaging.DeliveryPublisher;
import deliveryservice.app.model.Delivery;
import deliveryservice.app.model.Order;
import deliveryservice.app.repository.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class DeliveryConsumer {
	
	  private static final Logger logger = LoggerFactory.getLogger(DeliveryConsumer.class);
	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private DeliveryRepository deliveryRepository;
	
	@Autowired
	private DeliveryPublisher deliveryPublisher;
	@KafkaListener(topics="DeliveryService",groupId = "group_id")
	public void consumeMessage(String message) {
		try {
			Order order = objectMapper.readValue(message, Order.class);
		Delivery product = new Delivery();
		product.setAddress(order.getAddress());
		product.setOrderId(order.getId());
		product.setProductId(order.getProductId());
		deliveryRepository.save(product);		
		logger.info("Processing delivery id "+product.getId()+" for order id "+order.getId());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		order.setStatus("Delivered");
		deliveryPublisher.sendToOrderCallBack(order);
		logger.info("Delivered order id "+order.getId());
		
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
