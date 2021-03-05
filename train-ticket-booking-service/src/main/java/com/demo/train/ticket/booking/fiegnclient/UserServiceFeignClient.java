package com.demo.train.ticket.booking.fiegnclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.demo.train.ticket.booking.model.LoginDto;
import com.demo.train.ticket.booking.model.UserDto;

@FeignClient(name = "http://USER-SERVICE/api/user")
public interface UserServiceFeignClient {

	@PostMapping("/get-user")
	public UserDto login(LoginDto loginDto);

}
