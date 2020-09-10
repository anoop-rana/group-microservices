package com.userinfo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.userinfo.bean.User;
import com.userinfo.dao.UserDAOService;

@Service
public class UserService {

	@Autowired
	UserDAOService repo;

	public List<User> findAll() {
		return repo.findAll();
	}

	public Optional<User> findUserById(long id) {
		return repo.findById(id);
	}

	public Optional<User> findUserByName(String name) {
		return repo.findByName(name);
	}

	public User createOrUpdate(User user) {
		Optional<User> oldUser = repo.findByName(user.getName());
		if (oldUser.isPresent()) {
			User updateUser = oldUser.get();
			updateUser.setName(user.getName());
			updateUser.setAge(user.getAge());
			updateUser.setEmail(user.getEmail());
			updateUser.setPhone(user.getPhone());
			return repo.save(updateUser);
		} else {
			return repo.save(user);
		}
	}

	public void deleteUser(long id) {
		repo.delete(repo.findById(id).get());
	}

	
}
