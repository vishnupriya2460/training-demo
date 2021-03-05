package com.demo.user.service;

import com.demo.user.model.LoginRequest;
import com.demo.user.model.UserDto;
import com.demo.user.model.UserRequest;

public interface UserService {

	String createUser(UserRequest request);

	Boolean login(LoginRequest request);

	UserDto getUser(String email);
}
