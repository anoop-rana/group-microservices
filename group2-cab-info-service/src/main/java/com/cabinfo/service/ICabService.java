package com.cabinfo.service;

import java.util.List;
import java.util.Optional;

import com.cabinfo.bean.Vehicle;
import com.cabinfo.exception.VehicleNotFound;

public interface ICabService {
	
	public List<Vehicle> findAll();
	public Optional<List<Vehicle>> findByType(String type);
	public Optional<List<Vehicle>> findByRoutes(String from, String to);
	public Vehicle createORupdate(Vehicle vehicle);
	public void remove(Long id) throws VehicleNotFound;

}
