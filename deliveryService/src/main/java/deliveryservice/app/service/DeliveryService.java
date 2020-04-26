package deliveryservice.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import deliveryservice.app.model.Delivery;
import deliveryservice.app.repository.DeliveryRepository;

@Service
public class DeliveryService {

	@Autowired
	private DeliveryRepository deliveryRepository;
	
	public List<Delivery> findAllDeliveries() {
		return deliveryRepository.findAll();
	}
}
