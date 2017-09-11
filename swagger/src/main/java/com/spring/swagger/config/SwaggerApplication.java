package com.spring.swagger.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication
@SpringBootApplication(scanBasePackages = { "com.spring.swagger" })
@EntityScan(basePackages = { "com.spring.swagger" })
//@ComponentScan("com.spring.swagger")
public class SwaggerApplication {
	
//	http://localhost:8080/swagger-ui.html
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApplication.class, args);
	}
}
