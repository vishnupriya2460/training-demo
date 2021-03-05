package com.demo.user.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.user.model.LoginRequest;
import com.demo.user.model.UserDto;
import com.demo.user.model.UserRequest;
import com.demo.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping(value = "/registration")
	public ResponseEntity<String> createUser(@Valid @RequestBody UserRequest userRequest) {
		log.info("Request to create new user");
		String response = userService.createUser(userRequest);
		log.info("New user created successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/login")
	public ResponseEntity<Boolean> login(@Valid @RequestBody LoginRequest loginRequest) {
		log.info("User login validation request");
		Boolean response = userService.login(loginRequest);
		log.info("User logged in successfully");
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@PostMapping(value = "/get-user")
	public ResponseEntity<UserDto> getUser(@Valid @RequestBody LoginRequest loginRequest) {
		UserDto response = userService.getUser(loginRequest.getEmail());
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
}