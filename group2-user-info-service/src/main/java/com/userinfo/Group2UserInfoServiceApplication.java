package com.userinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.userinfo")
@EnableDiscoveryClient
public class Group2UserInfoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(Group2UserInfoServiceApplication.class, args);
	}

}
