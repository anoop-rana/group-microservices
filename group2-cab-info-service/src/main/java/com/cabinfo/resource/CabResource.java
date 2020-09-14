package com.cabinfo.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cabinfo.bean.Vehicle;
import com.cabinfo.config.CabCloudClientConfig;
import com.cabinfo.exception.VehicleNotFound;
import com.cabinfo.service.CabService;

@RestController
@RequestMapping("/cab")
public class CabResource {

	@Autowired
	private CabService service;
	
	@Autowired
	CabCloudClientConfig config;
	
	@Value("${server.port}")
	private String port;
	
	//creating Logger object  
	private Logger logger=LoggerFactory.getLogger(this.getClass()); 

	@GetMapping("/config")
	public ResponseEntity<Map<String, String>> getCabConfig() {
		Map<String, String> configData = Map.of("Login ", config.getAdmin(), 
				"Password", config.getPassword(),
				"PORT", port);
		return new ResponseEntity<Map<String, String>>(configData, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping(path = { "", "/all" })
	public ResponseEntity<List<Vehicle>> getAllCabs() {
		List<Vehicle> allVehicle =service.findAll()
				.stream()
				.map(v->{v.setPort(port);return v;})
				.collect(Collectors.toList());
		return new ResponseEntity<List<Vehicle>>(allVehicle, new HttpHeaders(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<Vehicle>> findById(@PathVariable long id) {
		Optional<Vehicle> vehicle = service.findByID(id);
		return validateCab(vehicle);
	}

//	@GetMapping("/find")
//	public void findByType(@RequestParam(value = "type", required = false) Optional<String> type, 
//			@RequestParam(value = "routeFrom", required = false) Optional<String> from,
//			@RequestParam(value = "routeTo", required = false) Optional<String> to){
//		System.out.println("=============" + type);
//		System.out.println("=============" + from);
//		System.out.println("=============" + to);
//	}

	@GetMapping("/search")
	public ResponseEntity<List<Vehicle>> findByType(@RequestParam Map<String, String> map) {
		logger.info("{}", map);
		if (map.size() == 1 && map.containsKey("type")) {
			Optional<List<Vehicle>> vehicleListByType = service.findByType(map.get("type"));
			if (vehicleListByType.isPresent()) {
				List<Vehicle> vList = vehicleListByType.get()
						.stream()
						.map(v->{v.setPort(port);return v;})
						.collect(Collectors.toList());
				return new ResponseEntity<List<Vehicle>>(vList, HttpStatus.FOUND);
			} else {
				throw new VehicleNotFound("Vehicle Type of " + map.get("type") + "Not Found !");
			}
		} else if (map.size() == 2 && map.containsKey("routeFrom") && map.containsKey("routeTo")) {
			Optional<List<Vehicle>> vehicleListByFromTo = service.findByRoutes(map.get("routeFrom"),
					map.get("routeTo"));
			if (vehicleListByFromTo.isPresent()) {
				List<Vehicle> vList = vehicleListByFromTo.get()
						.stream()
						.map(v->{v.setPort(port);return v;})
						.collect(Collectors.toList());
				return new ResponseEntity<List<Vehicle>>(vList, HttpStatus.FOUND);
			} else {
				throw new VehicleNotFound(
						"Vehicle from " + map.get("routeFrom") + " To " + map.get("routeTo") + " Not Available !");
			}
		} else {
			throw new VehicleNotFound("NO Service Availabe !");
		}

	}

	@PostMapping
	public ResponseEntity<Vehicle> createOrUpdate(@Valid @RequestBody Vehicle vehicle) {
		Vehicle updated = service.createORupdate(vehicle);
		URI location = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/cab/{id}")
				.buildAndExpand(updated.getVid())
				.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		Optional<Vehicle> vehicle = service.findByID(id);
		if (vehicle.isPresent()) {
			service.remove(id);
			URI location = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/cab")
					.build()
					.toUri();
			return ResponseEntity.created(location).build();
		} else {
			throw new VehicleNotFound("Cab with ID: " + id + " Not Found !");
		}
	}

	private ResponseEntity<EntityModel<Vehicle>> validateCab(Optional<Vehicle> vehicle) {
		if (vehicle.isPresent()) {
			Vehicle v = vehicle.get();
			v.setPort(port);
			EntityModel<Vehicle> entity = EntityModel.of(v);
			WebMvcLinkBuilder linkBuilder = linkTo(methodOn(this.getClass()).getAllCabs());
			entity.add(linkBuilder.withRel("all-cab-search"));
			return new ResponseEntity<EntityModel<Vehicle>>(entity, new HttpHeaders(), HttpStatus.OK);
		} else
			throw new VehicleNotFound("Vehicle Not Found !");
	}

}
