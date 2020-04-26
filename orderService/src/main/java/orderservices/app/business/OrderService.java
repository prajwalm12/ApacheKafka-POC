package orderservices.app.business;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import orderservices.app.messaging.OrderServicePublish;
import orderservices.app.model.Order;
import orderservices.app.repository.OrderRepository;

@Service
public class OrderService {
	
	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(OrderService.class);
	@Autowired
	private OrderRepository orderRepository;
	@Autowired
	private OrderServicePublish orderPublish;
	public Order createOrder(Order order) {
		order.setStatus("Waiting");
		order = orderRepository.save(order);
		orderPublish.sendOrder(order);
		logger.info("Order with order id "+ order.getId() + "sent to kichen service");
		return order;
		
	}
}
