package com.devenger.bhaipaisadega.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devenger.bhaipaisadega.dto.DashboardResponse;
import com.devenger.bhaipaisadega.dto.UserRequest;
import com.devenger.bhaipaisadega.exception.BPDException;
import com.devenger.bhaipaisadega.mapper.UserMapper;
import com.devenger.bhaipaisadega.model.User;
import com.devenger.bhaipaisadega.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private LoanService loanService;
	
	@Autowired
	private LendService lendService;

	public User login(UserRequest request) {
		return userRepository.findByUserNameAndPassword(request.getUserName(), request.getPassword());
	}

	public User register(UserRequest request) {
		User user = userRepository.findByUserName(request.getUserName());
		if (user != null) {
			throw new BPDException("user with given name already exists : " + request.getUserName());
		}
		return userRepository.save(UserMapper.mapRequest(request));
	}

	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	public DashboardResponse getDashboardReport(Long userId) {
		DashboardResponse response = loanService.getLoanReportByUserId(userId);
		return lendService.getLendReportByUserId(userId,response);
	}
}
