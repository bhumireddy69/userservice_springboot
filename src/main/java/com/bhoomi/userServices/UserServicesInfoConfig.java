package com.bhoomi.userServices;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;


@Component
public class UserServicesInfoConfig implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("Project_Name", "UserService");
		builder.withDetail("Owner", "Chaitanya Bhoomireddy");
		builder.withDetail("Developer", "chaitanyareddy69@gmail.com");
		builder.build();
	}

}
