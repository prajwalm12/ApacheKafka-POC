package orderservices.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import orderservices.app.business.OrderService;

@SpringBootApplication
@ComponentScan(basePackages={"orderservices.app.*"})
@EnableJpaRepositories(basePackages= {"orderservices.app.repository","orderservices.app.model"})
@EntityScan(basePackages = "orderservices.app.model")
@EnableAutoConfiguration
public class OrderServiceApplication {
	
	public static void main(String args[]) {
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	@Bean
	public OrderService OrderService(){
		return new OrderService();
	}
}
