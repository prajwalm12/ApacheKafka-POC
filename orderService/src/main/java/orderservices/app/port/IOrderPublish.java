package orderservices.app.port;

import orderservices.app.model.Order;

public interface IOrderPublish {
	
	void sendOrder(Order order);
}
