package com.cabinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient  
public class Group2CabInfoService1Application {

	public static void main(String[] args) {
		SpringApplication.run(Group2CabInfoService1Application.class, args);
	}

}
