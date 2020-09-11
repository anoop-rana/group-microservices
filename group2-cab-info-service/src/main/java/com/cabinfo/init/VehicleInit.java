package com.cabinfo.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cabinfo.bean.Vehicle;
import com.cabinfo.repo.CabDAOService;

@Component
public class VehicleInit implements CommandLineRunner{

	@Autowired
	CabDAOService repo;
	
	@Override
	public void run(String... args) throws Exception {
		List<Vehicle> list = List.of(
				new Vehicle("Rajesh", "Tata Sumo", "Tracker", "UK-07-3E78", "Haridwar", "Kedharnath",340.00, false),
				new Vehicle("Kishor", "Toyta", "Lux-Car","DL-06-48F9", "Dehradun", "Delhi",310.00, true),
				new Vehicle("Amir", "i10", "Mini Car","UP-22-3E65", "Delhi", "Moradabad",620.00, false),
				new Vehicle("Birju", "Red Bus", "Volvo","RJ-05-9E08", "Delhi", "Rajisthan",640.00, true));
		
		repo.saveAll(list);
	}

}
