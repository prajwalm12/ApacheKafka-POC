package orderservices.app.business;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import orderservices.app.model.Order;
import orderservices.app.port.IOrderMessaging;
import orderservices.app.repository.OrderRepository;

@Service
public class OrderServiceCallBack implements IOrderMessaging {

	@Autowired
	private ObjectMapper objectMapper;

	@Autowired
	private OrderRepository orderRepository;
	
	@KafkaListener(topics="OrderCallbackService",groupId = "group_id")
	public void callback(String message) {
		// TODO Auto-generated method stub
		try {
			Order order = objectMapper.readValue(message, Order.class);
			Optional<Order> orderOptional = orderRepository.findById(order.getId());
			if (orderOptional.isPresent()) {
				Order orderDb = orderOptional.get();
				orderDb.setStatus(order.getOrderStatus());
				orderRepository.save(orderDb);

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
