package deliveryservice.app.messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import deliveryservice.app.model.Order;

@Service
public class DeliveryPublisher {

	@Autowired
	private ObjectMapper objectMapper;
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public void sendToOrderCallBack(Order order) {
		
		try {
			kafkaTemplate.send("OrderCallbackService",objectMapper.writeValueAsString(order));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
