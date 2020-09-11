package com.cabinfo.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabinfo.bean.Vehicle;

@Repository
public interface CabDAOService extends JpaRepository<Vehicle, Long> {

	Optional<List<Vehicle>> findByType(String type);

	Optional<List<Vehicle>> findByRouteFromAndRouteTo(String from, String to);

	Optional<Vehicle> findByDriverName(String driverName);

	Optional<Vehicle> findByCabNo(String cabNo);

}
