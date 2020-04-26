package kichenservice.app.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import kichenservice.app.business.KichenService;
import kichenservice.app.model.Product;

@RestController
public class KichenServiceApi {

	@Autowired
	private KichenService kichenService;

	@PostMapping(path = "/saveProduct", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> saveProduct(@RequestBody Product product) {
		kichenService.saveProductService(product);
		return new ResponseEntity<String>("Product inserted successfully", HttpStatus.OK);
	}

	@PostMapping(path = "/productQuantity/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Integer> fetchQuantityofProduct(@PathVariable("id") long productId) {
		int val = kichenService.findQuantityService(productId);
		return new ResponseEntity<Integer>(val, HttpStatus.OK);
	}

	@PostMapping(path = "/productQuantityDec/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> decQuantityofProduct(@PathVariable("id") long productId) {
		kichenService.decQuanofProductService(productId);
		return new ResponseEntity<String>("Product count decremented successfully", HttpStatus.OK);
	}

}
