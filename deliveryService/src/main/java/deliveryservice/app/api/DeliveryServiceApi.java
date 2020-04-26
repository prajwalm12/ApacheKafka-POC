package deliveryservice.app.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import deliveryservice.app.model.Delivery;
import deliveryservice.app.service.DeliveryService;

@RestController
public class DeliveryServiceApi {

	@Autowired
	private DeliveryService deliveryService;
	@PostMapping(path = "/deliveryService" , consumes = MediaType.APPLICATION_JSON_VALUE , produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Delivery>> findAllDeliveries() {
		List<Delivery> deliveryList = deliveryService.findAllDeliveries();
		return new ResponseEntity<List<Delivery>>(deliveryList,HttpStatus.OK);
	}
}
