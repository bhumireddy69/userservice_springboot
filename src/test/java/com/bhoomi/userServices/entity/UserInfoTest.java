package com.bhoomi.userServices.entity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserInfoTest {
	
	@Test
	void checkUserInfoEntity() throws ParseException {
		DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
		Date date = df.parse("2020/02/20");
		UserInfo ui = new UserInfo();
		ui.setFirstName("chaitanya");
		ui.setLastName("bhoomireddy");
		ui.setPhone("xxx-xxx-xxxx");
		ui.setDateCreated(date);
		ui.seteMail("chaitanyareddy69@gmail.com");
		ui.setLastUpdated(date);
		ui.setUserID(12345);
		
		Assertions.assertEquals("chaitanya", ui.getFirstName());
		Assertions.assertEquals("bhoomireddy", ui.getLastName());
		Assertions.assertEquals("xxx-xxx-xxxx", ui.getPhone());
		Assertions.assertEquals(df.format(date), df.format(ui.getDateCreated()));
		Assertions.assertEquals("chaitanyareddy69@gmail.com", ui.geteMail());
		Assertions.assertEquals(df.format(date), df.format(ui.getLastUpdated().getTime()));
		Assertions.assertEquals(12345, ui.getUserID());
	}

}
