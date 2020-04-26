package deliveryservice.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderId")
	private long id;
	@Column(name = "orderStatus")
	private String orderStatus;
	@Column(name = "customerId")
	private long customerId;
	@Column(name = "productId")
	private long productId;
	@Column(name = "address")
	private String address;
	
	public Order() {
		
	}

	public Order(String orderStatus, String customerId, String productId,String address) {
		// TODO Auto-generated constructor stub
		this.orderStatus = orderStatus;
		this.customerId = Long.parseLong(customerId);
		this.productId = Long.parseLong(productId);
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public long getCustomerId() {
		return customerId;
	}

	public long getProductId() {
		return productId;
	}
	
	public void setStatus(String status) {
		orderStatus = status;
	}

	public String getAddress() {
			// TODO Auto-generated method stub
		return address;
	}
}
