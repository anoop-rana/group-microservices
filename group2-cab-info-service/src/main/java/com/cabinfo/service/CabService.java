package com.cabinfo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cabinfo.bean.Vehicle;
import com.cabinfo.exception.VehicleNotFound;
import com.cabinfo.repo.CabDAOService;

@Service
public class CabService implements ICabService {

	@Autowired
	CabDAOService repo;
	
	@Override
	public List<Vehicle> findAll() {
		return repo.findAll();
	}
	
	public Optional<Vehicle> findByID(long id) {
		return repo.findById(id);
	}

	@Override
	public Optional<List<Vehicle>> findByType(String type) {
		return repo.findByType(type);
	}

	@Override
	public Optional<List<Vehicle>> findByRoutes(String from, String to) {
		return repo.findByRouteFromAndRouteTo(from, to);
	}

	@Override
	public Vehicle createORupdate(Vehicle vehicle) {
		Optional<Vehicle> oldVehicle = repo.findByCabNo(vehicle.getCabNo());
		if (oldVehicle.isPresent()) {
			Vehicle updateVehicle = oldVehicle.get();
			updateVehicle.setName(vehicle.getName());
			updateVehicle.setDriverName(vehicle.getDriverName());
			updateVehicle.setType(vehicle.getType());;
			updateVehicle.setRouteFrom(vehicle.getRouteFrom());
			updateVehicle.setRouteTo(vehicle.getRouteTo());
			updateVehicle.setFare(vehicle.getFare());
			updateVehicle.setIsBooked(vehicle.getIsBooked());
			return repo.save(updateVehicle);
		} else {
			return repo.save(vehicle);
		}
	}

	@Override
	public void remove(Long id) throws VehicleNotFound{
		Optional<Vehicle> vehicle = repo.findById(id);
		if(vehicle.isPresent())
			repo.delete(vehicle.get());
		else
			throw new VehicleNotFound("Vehicle Not Found !");
		
	}

}
