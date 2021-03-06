package com.microservices.demo.ui.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.demo.data.UserRest;
import com.microservices.demo.exception.UserServiceException;
import com.microservices.demo.requestdata.UpdateUserDetialRequestData;
import com.microservices.demo.requestdata.UserDetailRequestData;
import com.microservices.demo.userservice.CreateUserService;

@RestController
@RequestMapping("users")
public class UserController {

	Map<String, UserRest> users;

	@Autowired
	CreateUserService createUserService;

	@GetMapping()
	public String getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit") int limit,
			@RequestParam(value = "sort", defaultValue = "asc", required = false) String sort) {
		return "GetUsers was called from page = " + " with limit:" + limit + " by " + sort;
	}

	@GetMapping(path = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		if (users.containsKey(userId)) {
			return new ResponseEntity<>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	@PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestData userDetail) {

		UserRest userRest = createUserService.createUser(userDetail);
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);
	}

	@PutMapping(path = "/{userId}", consumes = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public UserRest updateUser(@PathVariable String userId, @RequestBody UpdateUserDetialRequestData data) {
		UserRest storedUserDetail = users.get(userId);
		storedUserDetail.setFirstname(data.getFirstname());
		storedUserDetail.setLastname(data.getLastname());
		return storedUserDetail;
	}

	@DeleteMapping("/{userId}")
	public ResponseEntity<Void> delete(@PathVariable String userId) {
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}

}
