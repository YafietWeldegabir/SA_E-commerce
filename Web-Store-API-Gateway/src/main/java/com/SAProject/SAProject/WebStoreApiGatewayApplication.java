package com.SAProject.SAProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableDiscoveryClient
@SpringBootApplication
public class WebStoreApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebStoreApiGatewayApplication.class, args);
	}

}
