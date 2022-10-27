package com.example.jpa.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.entity.Users;
import com.example.jpa.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;
	
	@GetMapping(value = "/users")
	public List<Users> getUsers(@RequestParam(required = false, defaultValue = "") String name){
		return userService.getUsersService(name);
	}
	
	@PostMapping(value = "/user")
	public String createUser(@RequestBody Users user) {
		return userService.createUserService(user);
	}
}
