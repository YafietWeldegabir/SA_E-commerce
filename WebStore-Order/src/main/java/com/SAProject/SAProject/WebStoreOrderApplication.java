package com.SAProject.SAProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
//@EnableDiscoveryClient
@EnableFeignClients
public class WebStoreOrderApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebStoreOrderApplication.class, args);
	}

}
