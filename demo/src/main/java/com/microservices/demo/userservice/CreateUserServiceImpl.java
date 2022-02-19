package com.microservices.demo.userservice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.demo.data.UserRest;
import com.microservices.demo.requestdata.UserDetailRequestData;
import com.microservices.demo.util.Util;

@Service
public class CreateUserServiceImpl implements CreateUserService {

	final Util util;
	
	@Autowired
	public CreateUserServiceImpl(Util util) {
		this.util = util;
	}
	
	Map<String, UserRest> users;
	@Override
	public UserRest createUser(UserDetailRequestData userDetail) {
		UserRest userRest = new UserRest();
		userRest.setGmail(userDetail.getEmail());
		userRest.setFirstname(userDetail.getFirstname());
		userRest.setLastname(userDetail.getLastname());
		
		if(users == null) users = new HashMap<>();
		
		String userId = util.generateUserId();
		userRest.setUserId(userId);
		users.put(userId, userRest);
		return userRest;
	}

}
