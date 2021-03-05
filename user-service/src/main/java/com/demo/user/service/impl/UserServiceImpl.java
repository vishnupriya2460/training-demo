package com.demo.user.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.demo.user.entity.User;
import com.demo.user.exception.UserException;
import com.demo.user.model.LoginRequest;
import com.demo.user.model.UserDto;
import com.demo.user.model.UserRequest;
import com.demo.user.repository.UserRepository;
import com.demo.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	UserRepository userRepository;

	@Override
	public String createUser(UserRequest request) {

		User newUser = userRepository.findByEmail(request.getEmail());

		if (newUser != null) {
			log.error("User with {} already exist.", request.getEmail());
			throw new UserException("User already exist");
		} else {
			log.info("Creating new user with email {}", request.getEmail());
			newUser = new User();
			newUser.setName(request.getName());
			newUser.setEmail(request.getEmail());
			newUser.setPassword(passwordEncoder.encode(request.getPassword()));
			userRepository.save(newUser);
		}
		return "User Created With " + newUser.getEmail();
	}

	@Override
	public Boolean login(LoginRequest request) {
		User user = userRepository.findByEmail(request.getEmail());
		if (user == null) {
			log.error("No User with {}", request.getEmail());
			throw new UserException("User Not Found");
		}

		if (passwordEncoder.matches(request.getPassword(), user.getPassword())) {
			return true;
		}
		throw new UserException("Invalid Password, Please Try Again");
	}

	@Override
	public UserDto getUser(String email) {
		User user = userRepository.findByEmail(email);
		if (user == null) {
			log.error("No User with {}", email);
			throw new UserException("User Not Found");
		}
		return new UserDto(user.getEmail(), user.getPassword());
	}
}
