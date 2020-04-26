package orderservices.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import orderservices.app.business.OrderService;
import orderservices.app.model.Order;

@RestController
public class OrderServiceApi {

	@Autowired
	private OrderService orderService;
	@PostMapping(path = "/createOrder",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> CreateOrder(@RequestBody Order order) {
		
		Order orderResp = orderService.createOrder(order);
		return new ResponseEntity<String>(orderResp.getOrderStatus(),HttpStatus.OK);
		
	}
}
