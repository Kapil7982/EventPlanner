package com.event.controller;



import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.event.entity.User;
import com.event.excepitons.Userserexception;
import com.event.service.UserService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v3/app/events")
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public ResponseEntity<User> saveCustomer(@Valid @RequestBody User user) throws Userserexception {

		User savedUser = userService.createUser(user);

		return new ResponseEntity<User>(savedUser, HttpStatus.CREATED);
	}
	
}
