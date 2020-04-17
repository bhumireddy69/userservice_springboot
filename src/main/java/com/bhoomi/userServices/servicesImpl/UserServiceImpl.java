package com.bhoomi.userServices.servicesImpl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhoomi.userServices.entity.UserInfo;
import com.bhoomi.userServices.repository.UserInfoRepository;
import com.bhoomi.userServices.services.UserService;
import com.google.gson.Gson;
/**
 * UserService implementation 
 * 
 * @filename UserServiceImpl.java
 *
 * @author Chaitanya Bhoomireddy
 * 
 */
@Service
public class UserServiceImpl implements UserService{
	private final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	UserInfoRepository userInfoRepository;
	
	@Autowired
	Gson gson;
	
	@Override
	public List<UserInfo> getAllUsers() {
		List<UserInfo> userInfo = userInfoRepository.findAll();
		logger.debug("All Users List {}", gson.toJson(userInfo));
		return userInfo;
	}
	
}
