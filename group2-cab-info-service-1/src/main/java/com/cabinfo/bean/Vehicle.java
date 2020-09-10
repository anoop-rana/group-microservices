package com.cabinfo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Vehicle")
@Data
@NoArgsConstructor
public class Vehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vid;
	private String name;
	private String type;
	private String routeFrom;
	private String routeTo;
	private Boolean isBooked;
	
	public Vehicle(String name, String type, String routeFrom, String routeTo, Boolean isBooked) {
		super();
		this.name = name;
		this.type = type;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.isBooked = isBooked;
	}
	
}
