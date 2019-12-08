package com.devenger.bhaipaisadega.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devenger.bhaipaisadega.dto.LendRequest;
import com.devenger.bhaipaisadega.model.Lend;
import com.devenger.bhaipaisadega.service.LendService;

@RestController
@RequestMapping(value = "lend")
public class LendController {

	@Autowired
	private LendService lendService;

	@PostMapping
	public Lend lendMoney(@RequestBody @Valid LendRequest request) {
		return lendService.lendMoney(request);
	}

	@GetMapping(value = "{lendId}")
	public Lend getLendById(@PathVariable(value = "lendId") Long lendId) {
		return lendService.getLendById(lendId);
	}

	@GetMapping(value = "user/{userId}")
	public List<Lend> getLendByUserId(@PathVariable(value = "userId") Long userId) {
		return lendService.getLendByUserId(userId);
	}

}
