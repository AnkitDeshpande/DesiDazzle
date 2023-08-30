package com.desidazzle.controller.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.desidazzle.controller.model.LoginBody;
import com.desidazzle.controller.model.LoginResponse;
import com.desidazzle.controller.model.RegistrationBody;
import com.desidazzle.exception.UserAlreadyExistsException;
import com.desidazzle.model.Customer;
import com.desidazzle.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

	@Autowired
	private UserService userService;

	@PostMapping("/register")
	public ResponseEntity<Customer> registerUser(@Valid @RequestBody RegistrationBody registrationBody)
			throws UserAlreadyExistsException {
		return new ResponseEntity<Customer>(userService.registerUser(registrationBody), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<LoginResponse> loginUser(@Valid @RequestBody LoginBody loginBody) {
		String jwt = userService.loginUser(loginBody);
		if (jwt == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		} else {
			return new ResponseEntity<LoginResponse>(new LoginResponse(jwt), HttpStatus.OK);
		}
	}
}
