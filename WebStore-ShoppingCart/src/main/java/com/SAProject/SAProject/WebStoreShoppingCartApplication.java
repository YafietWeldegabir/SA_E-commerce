package com.SAProject.SAProject;

import com.SAProject.SAProject.Service.ProductDTO;
import com.SAProject.SAProject.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
@EnableFeignClients
@EnableDiscoveryClient
public class WebStoreShoppingCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebStoreShoppingCartApplication.class, args);
	}

}
