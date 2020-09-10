package com.userinfo.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.userinfo.bean.User;

@Repository
public interface UserDAOService extends JpaRepository<User, Long>{

	public Optional<User> findByName(String name);

}
