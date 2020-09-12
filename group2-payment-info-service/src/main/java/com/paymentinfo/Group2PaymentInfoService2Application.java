package com.paymentinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class Group2PaymentInfoService2Application {

	public static void main(String[] args) {
		SpringApplication.run(Group2PaymentInfoService2Application.class, args);
	}

}
