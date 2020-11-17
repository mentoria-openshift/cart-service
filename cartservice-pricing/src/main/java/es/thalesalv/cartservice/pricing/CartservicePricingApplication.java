package es.thalesalv.cartservice.pricing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CartservicePricingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartservicePricingApplication.class, args);
	}
}
