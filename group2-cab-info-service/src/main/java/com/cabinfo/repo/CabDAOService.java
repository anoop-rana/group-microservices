package com.cabinfo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cabinfo.bean.Vehicle;

@Repository
public interface CabDAOService extends JpaRepository<Vehicle, Long> {

}
