package com.cabinfo.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
	
	@Size(min = 6)
	private String cabNo;
	private String type;
	
	@NotNull
	private String routeFrom;
	
	@NotNull
	private String routeTo;
	
	@Min(value = 100)
	private Double fare;
	private Boolean isBooked;
	private String port;
	
	public Vehicle(String driverName, String name, String type, String cabNo, String routeFrom, String routeTo, Double fare, Boolean isBooked) {
		super();
		this.driverName = driverName;
		this.name = name;
		this.cabNo = cabNo;
		this.type = type;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.fare = fare;
		this.isBooked = isBooked;
	}
	
}
