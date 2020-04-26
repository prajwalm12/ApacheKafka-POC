package kichenservice.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import kichenservice.app.model.Product;

public interface kichenRepository extends JpaRepository<Product,Long>{
	
	@Query("select p.quantity from Product p where p.productId = productId")
	public abstract int findQuantityofProduct(@Param("productId") long productId);
	@Transactional
	@Modifying
	@Query("update Product p set p.quantity = p.quantity -1 where p.productId = productId")
	public abstract void decQuantityofProduct(@Param("productId") long productId);
}
