package com.microservices.demo.userservice;

import com.microservices.demo.data.UserRest;
import com.microservices.demo.requestdata.UserDetailRequestData;

public interface CreateUserService {
	
	UserRest createUser(UserDetailRequestData data);
}
