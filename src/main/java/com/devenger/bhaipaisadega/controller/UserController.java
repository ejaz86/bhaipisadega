package com.devenger.bhaipaisadega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devenger.bhaipaisadega.dto.DashboardResponse;
import com.devenger.bhaipaisadega.dto.UserRequest;
import com.devenger.bhaipaisadega.exception.BPDException;
import com.devenger.bhaipaisadega.model.User;
import com.devenger.bhaipaisadega.service.UserService;

@RestController
@RequestMapping(value = "user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping(value = "login")
	public ResponseEntity<User> loginUser(@RequestBody UserRequest request) {
		User user = userService.login(request);
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		throw new BPDException("user not found for given userName and password");
	}

	@PostMapping(value = "register")
	public ResponseEntity<User> createUser(@RequestBody @Valid UserRequest request) {
		User user = userService.register(request);
		if (user != null) {
			return ResponseEntity.ok(user);
		}
		return ResponseEntity.status(401).build();
	}
	
	@GetMapping
	public List<User> getUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping(value="/{userId}/dashboard")
	public DashboardResponse getDashboardReport(@PathVariable(value="userId") Long userId) {
		return userService.getDashboardReport(userId);
	}
	
}
