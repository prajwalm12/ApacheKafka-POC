package kichenservice.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@ComponentScan(basePackages={"kichenservice.app.*"})
@EnableJpaRepositories(basePackages= {"kichenservice.app.repository","kichenservice.app.model"})
@EntityScan(basePackages = "kichenservice.app.model")
@EnableAutoConfiguration
public class KichenServiceApplication 
{
    public static void main( String[] args )
    {
    	SpringApplication.run(KichenServiceApplication.class, args);
    }
}
