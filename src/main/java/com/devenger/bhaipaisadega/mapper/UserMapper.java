package com.devenger.bhaipaisadega.mapper;

import com.devenger.bhaipaisadega.dto.UserRequest;
import com.devenger.bhaipaisadega.model.User;

public class UserMapper {

	public static User mapRequest(UserRequest request) {
		User user = new User();
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		user.setName(request.getName());
		return user;
	}
}
