package deliveryservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import deliveryservice.app.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery,Long> {

}
