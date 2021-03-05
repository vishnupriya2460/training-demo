package com.demo.train.ticket.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.train.ticket.booking.config.JwtTokenUtil;
import com.demo.train.ticket.booking.model.AccessToken;
import com.demo.train.ticket.booking.model.LoginDto;
import com.demo.train.ticket.booking.model.UserDto;
import com.demo.train.ticket.booking.service.impl.UserService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/token")
public class AuthenticationController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserService userService;

	@PostMapping(value = "/generate-access-token")
	public AccessToken getToken(@RequestBody LoginDto loginUser) throws AuthenticationException {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getEmail(), loginUser.getPassword()));
		final UserDto user = userService.getuser(loginUser);
		final String token = jwtTokenUtil.generateToken(loginUser.getEmail());
		return new AccessToken(token, user.getEmail());
	}

}
