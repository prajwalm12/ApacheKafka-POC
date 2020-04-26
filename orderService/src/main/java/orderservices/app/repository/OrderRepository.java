package orderservices.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import orderservices.app.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
