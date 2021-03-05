package com.demo.user.service.impl;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.demo.user.entity.User;
import com.demo.user.exception.UserException;
import com.demo.user.model.UserRequest;
import com.demo.user.repository.UserRepository;

@SpringBootTest
public class UserServiceImplTest {

	@Mock
	UserRepository userRepository;
	
	@Mock
	BCryptPasswordEncoder passwordEncoder;

	@InjectMocks
	UserServiceImpl userServiceImplMock;

	@Test
	public void createUserTest() {
		when(userRepository.findByEmail("demo@demo.com")).thenReturn(null);
		when(userRepository.save(new User(1L, "demo", "demo@demo.com", "demodemo")))
				.thenReturn(new User(1L, "demo", "demo@demo.com", "demodemo"));
		String msg = userServiceImplMock.createUser(new UserRequest("demo", "demo@demo.com", "demodemo"));
		Assertions.assertEquals("User Created With demo@demo.com", msg);
	}

	@Test
	public void createUserTestException() {
		when(userRepository.findByEmail("demo@demo.com")).thenReturn(new User(1L, "demo", "demo@demo.com", "demodemo"));
		Assertions.assertThrows(UserException.class, () -> {
			userServiceImplMock.createUser(new UserRequest("demo", "demo@demo.com", "demodemo"));
		});
	}
}
