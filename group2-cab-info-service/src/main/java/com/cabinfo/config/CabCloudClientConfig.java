package com.cabinfo.config;

import javax.annotation.PostConstruct;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Component
@ConfigurationProperties(prefix = "cab.service")
@Getter @Setter
public class CabCloudClientConfig {
	
	private String admin;
	private String password;
	
	@PostConstruct
	  public void postConstruct() {
	      System.out.println("username============= "+admin);
	      System.out.println("password============= "+password);
	  }

}
