package com.becode.cogip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class CogipApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext run = SpringApplication.run(CogipApplication.class, args);
	}

}
