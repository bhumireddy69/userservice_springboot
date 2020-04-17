package com.bhoomi.userServices;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.bhoomi.userServices.UserServicesApplication;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UserServicesApplicationTests {

	@Test
	void contextLoads() {
		UserServicesApplication.main(new String[] {});
	}

}
