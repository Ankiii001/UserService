package com.nagarro.msa.users.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.nagarro.msa.users.exceptions.UserNotFoundException;
import com.nagarro.msa.users.userbean.User;
import com.nagarro.msa.users.userrepository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/{id}")
	public Optional<User> retrieveProduct(@PathVariable Integer id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("User not found at id- " + id);
		}
		return user;
	}

	@GetMapping("")
	public List<User> userList() {
		return userRepository.findAll();
	}

	@PostMapping("")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User savedUser = userRepository.save(user);
		System.out.println("yes  " + savedUser);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(savedUser.getUserId()).toUri();

		return ResponseEntity.created(location).build();
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable Integer id) {
		userRepository.deleteById(id);
	}
}
