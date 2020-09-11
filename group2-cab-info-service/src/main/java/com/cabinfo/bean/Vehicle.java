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
	private String driverName;
	private String name;
	private String type;
	private String routeFrom;
	private String routeTo;
	private Double fare;
	private Boolean isBooked;
	
	public Vehicle(String driverName, String name, String type, String routeFrom, String routeTo, Double fare, Boolean isBooked) {
		super();
		this.driverName = driverName;
		this.name = name;
		this.type = type;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.fare = fare;
		this.isBooked = isBooked;
	}
	
}
