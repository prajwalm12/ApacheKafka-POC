package kichenservice.app.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kichenservice.app.model.Order;
import kichenservice.app.model.Product;
import kichenservice.app.repository.kichenRepository;

@Service
public class KichenService {

	@Autowired
	private kichenRepository kichenRepository;

	public void saveProductService(Product product) {
		kichenRepository.save(product);
	}

	public int findQuantityService(long productId) {
		return kichenRepository.findQuantityofProduct(productId);
	}

	public void decQuanofProductService(long productId) {
		kichenRepository.decQuantityofProduct(productId);
	}

	public boolean processRecievedOrder(Order order) {
		// TODO Auto-generated method stub

		int val = findQuantityService(order.getProductId());
		if (val <= 0) {			
			return false;
		} else {			
			decQuanofProductService(order.getProductId());
			return true;
		}

	}
}
