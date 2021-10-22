package com.SAProject.SAProject;

import com.SAProject.SAProject.Domain.Product;
import com.SAProject.SAProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableKafka
@EnableScheduling
//@EnableDiscoveryClient
public class WebStoreProductApplication {
	public static void main(String[] args) {
		SpringApplication.run(WebStoreProductApplication.class, args);
	}


}
