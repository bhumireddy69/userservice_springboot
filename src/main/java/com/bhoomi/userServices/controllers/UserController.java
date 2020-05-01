package com.bhoomi.userServices.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@GetMapping("/getInfo")
	public List<UserInfo> getRequiredUsers(@RequestParam(defaultValue = "0") int userID,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(defaultValue = "0") int minAge,
			@RequestParam(defaultValue = "0") int maxAge//,
			//@RequestParam Map<String,Object> allParams
			)  
	{	
		logger.info("Getting required Users");
		Map<String, Object> allParams = new HashMap<String, Object>();
		if (firstName != null ) {allParams.put("firstName",firstName);}
		if (lastName != null ) {allParams.put("lastName",lastName);}
		if (userID != 0 ) {allParams.put("userID",userID);}
		if (minAge != 0 ) {allParams.put("minAge",minAge);}
		if (maxAge != 0 ) {allParams.put("maxAge",maxAge);}
		List<UserInfo> list = userService.getRequiredData(allParams);
		return list;
	}

}