package com.userinfo.dto;

import lombok.Data;

@Data
public class CabDto {
	private Long vid;
	private String driverName;
	private String name;
	private String cabNo;
	private String type;
	private String routeFrom;
	private String routeTo;
	private Double fare;
	private Boolean isBooked;
}
