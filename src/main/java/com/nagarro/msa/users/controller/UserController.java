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
import com.nagarro.msa.users.userdto.UserDto;
import com.nagarro.msa.users.userrepository.UserRepository;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping("/{id}")
	public UserDto retrieveUser(@PathVariable Integer id) {
		User user = userRepository.findById(id).orElseThrow(
			    () -> new UserNotFoundException("User not found at id- " + id)
			    );
		UserDto requiredUser = new UserDto(user.getUserName(), user.getUserAge(), user.getUserEmail());
		return requiredUser;
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
