package com.bhoomi.userServices.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bhoomi.userServices.entity.UserInfo;
import com.bhoomi.userServices.services.UserService;
/**
 * All the controllers related to User Service 
 * 
 * @filename UserController.java
 *
 * @author Chaitanya Bhoomireddy
 * 
 */
@RestController
@RequestMapping("/users")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public List<UserInfo> getAllUsers()  
	{	
		logger.info("Getting All Users");
		List<UserInfo> list = userService.getAllUsers();
		return list;
	}

}