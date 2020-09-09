package com.monolithic.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.monolithic.bean.User;
import com.monolithic.exception.UserNotFoundException;
import com.monolithic.services.UserService;

@RestController
@RequestMapping(path = "/user-api")
public class UserController {
	
	@Autowired
	UserService service;
	
	@Autowired
	MessageSource messageSource;
	
	@GetMapping("/hi")
	public String getInternationalized(@RequestHeader(name = "Accept-Language", required = false) Locale locale) {
		return messageSource.getMessage("good.morning.message", null, locale);
	}

	@GetMapping(path = {"","/all-users"})
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> list = service.findAll();
		return new ResponseEntity<List<User>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<EntityModel<User>> findById(@PathVariable long id) {
		Optional<User> user = service.findUserById(id);
		return validateUser(user);
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<EntityModel<User>> findByName(@PathVariable String name) {
		Optional<User> user = service.findUserByName(name);
		return validateUser(user);
	}

	@PostMapping
	public ResponseEntity<User> createOrUpdate(@Valid @RequestBody User User) {
		User updated = service.createOrUpdate(User);
		URI location =ServletUriComponentsBuilder
						.fromCurrentContextPath()
						.path("/user-api/{id}")
						.buildAndExpand(updated.getUid())
						.toUri();
		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable long id) {
		Optional<User> User = service.findUserById(id);
		if (User.isPresent()) {
			service.deleteUser(id);
			return new ResponseEntity<Object>("Deleted", new HttpHeaders(), HttpStatus.FORBIDDEN);
		} else {
			throw new UserNotFoundException("User with ID: "+ id + " Not Found !");
		}
	}

	private ResponseEntity<EntityModel<User>> validateUser(Optional<User> user) {
		if (user.isPresent()) {
			EntityModel<User> entity = EntityModel.of(user.get());
			WebMvcLinkBuilder linkBuilder=linkTo(methodOn(this.getClass()).getAllUsers());
			entity.add(linkBuilder.withRel("all-users"));
			return new ResponseEntity<EntityModel<User>>(entity, new HttpHeaders(), HttpStatus.OK);
		}else
			throw new UserNotFoundException("User Not Found !");
	}
}
