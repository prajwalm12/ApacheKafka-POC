package deliveryservice.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "delivery")
@Entity
public class Delivery {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "deliveryId")
	private long id;
	@Column(name = "orderId")
	private long orderId;
	@Column(name = "Address")
	private String address;
	@Column(name = "productId")
	private long productId;
	
	public Delivery() {
		
	}
	public long getId() {
		return id;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public long getProductId() {
		return productId;
	}
	
	public long getOrderId() {
		return orderId;
	}

	public void setOrderId(long id) {
		// TODO Auto-generated method stub
		this.orderId = id;
	}

	public void setProductId(long productId) {
		// TODO Auto-generated method stub
		this.productId = productId;
	}
}
