package com.bhoomi.userServices.controllers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.bhoomi.userServices.entity.UserInfo;
import com.bhoomi.userServices.repository.UserInfoRepository;
import com.bhoomi.userServices.services.UserService;
import com.bhoomi.userServices.servicesImpl.UserServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;

@SpringBootTest
@TestInstance(Lifecycle.PER_CLASS)
public class UserControllerTest {
	@Mock
	UserInfoRepository userInfoRepository;
	
	@InjectMocks
	UserService userService = new UserServiceImpl();
	
	@Mock
	private UserInfo ui = new UserInfo();	
	
	Gson gson = mock(Gson.class);
	
	@BeforeAll
	void setUpUserInfo() {		
		ui = getTestUserInfo();
		List<UserInfo> uiList = new ArrayList<>();
		uiList.add(ui);
		when(userInfoRepository.findAll()).thenReturn(uiList);		
		when(gson.toJson(uiList)).thenReturn("successful");
	}
	
	@DisplayName("Test Mock complete User Controller")
    @Test
    void testGet() throws JsonProcessingException {
		//Assertions.assertEquals("chaitanya", userService.getAllUsers().get(0).getFirstName());
		Assertions.assertEquals(1, userService.getAllUsers().size());
    }

	private UserInfo getTestUserInfo() {
		ui.setFirstName("chaitanya");
		ui.setLastName("bhoomireddy");
		ui.setPhone("xxx-xxx-xxxx");
		ui.setDateCreated(new Date());
		ui.seteMail("chaitanyareddy69@gmail.com");
		ui.setLastUpdated(new Date());
		ui.setUserID(12345);
		return ui;
	}

}
