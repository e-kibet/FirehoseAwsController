package controller.app.firehose;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({ "controllers", "models" })
@EntityScan(basePackages = "models")
public class FireHoseControllerApplication {

	public static void main(String[] args) {
		SpringApplication.run(FireHoseControllerApplication.class, args);
	}

}
