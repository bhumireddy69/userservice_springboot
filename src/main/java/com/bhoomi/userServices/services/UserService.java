package com.bhoomi.userServices.services;

import java.util.List;

import com.bhoomi.userServices.entity.UserInfo;
/**
 * UserService mapped for UserController 
 * 
 * @filename UserService.java
 *
 * @author Chaitanya Bhoomireddy
 * 
 */
public interface UserService {
	public abstract List<UserInfo> getAllUsers();
}
