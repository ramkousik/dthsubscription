package com.alkimi.dthsubscription;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan(basePackages = "com.alkimi.dthsubscription")
@SpringBootApplication
public class DthsubscriptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(DthsubscriptionApplication.class, args);
	}

}
