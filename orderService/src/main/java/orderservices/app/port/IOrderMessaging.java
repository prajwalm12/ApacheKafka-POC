package orderservices.app.port;

import org.springframework.kafka.annotation.KafkaListener;

public interface IOrderMessaging {

	@KafkaListener(topics = "orderServiceCallBack")
	void callback(String message);
}
