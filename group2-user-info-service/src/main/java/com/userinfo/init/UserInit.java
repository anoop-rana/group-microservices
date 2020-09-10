package com.userinfo.init;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.userinfo.bean.User;
import com.userinfo.dao.UserDAOService;

@Component
public class UserInit implements CommandLineRunner {

	@Autowired
	private UserDAOService repo;

	@Override
	public void run(String... args) throws Exception {
		List<User> users = List.of(
				new User("Arun", 25, 1234567890l, "arun@gmail.com"),
				new User("Rahul", 18, 1212343423l, "rahul@gmail.com"),
				new User("Rohit", 23, 9097782343l, "rohit@gmail.com"),
				new User("Ajay", 29, 9978564567L, "ajay@gmail.com"),
				new User("Amar", 26, 9996757678L, "amar@gmail.com")
				);
		
		repo.saveAll(users);
	}

}
