package com.demo.train.ticket.booking.service.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.train.ticket.booking.fiegnclient.UserServiceFeignClient;
import com.demo.train.ticket.booking.model.LoginDto;
import com.demo.train.ticket.booking.model.UserDto;

@Service(value = "userService")
public class UserService implements UserDetailsService {

	@Autowired
	UserServiceFeignClient userServiceFeignClient;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDto user = getuser(new LoginDto(username, "demodemo"));
		if (user == null) {
			throw new UsernameNotFoundException("Invalid username or password.");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),
				getAuthority());
	}

	public UserDto getuser(LoginDto loginUser) {
		return userServiceFeignClient.login(loginUser);
	}

	private List<SimpleGrantedAuthority> getAuthority() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}
}
