package com.angular.ms.controller;

import com.angular.ms.codes.ErrorCode;
import com.angular.ms.model.User;
import com.angular.ms.repositories.UserRepository;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class UserController {
  @Autowired
  UserRepository userRepository;

  @GetMapping("/users/{id}")
  public ResponseEntity<?> getUserById(@PathVariable(value = "id") Integer id) {
    Optional<User> user = userRepository.findById(id);
    ErrorCode errorCode = new ErrorCode(1, "User doesnt exists");

    if (!user.isPresent()) {
      return new ResponseEntity<>(errorCode, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(user, HttpStatus.OK);
    }
  }

  @GetMapping("/users")
  public ResponseEntity<?> getUser(
    @RequestParam String username,
    @RequestParam String password
  ) {
	System.out.println("Username: " + username);
	System.out.println("Password: " + password);
	
    Optional<User> user = userRepository.findByUsernameAndPassword(username, password);
    
    System.out.println("User" + user);
    ErrorCode errorCode = new ErrorCode(1, "User doesnt exists");

    if (!user.isPresent()) {
      return new ResponseEntity<>(errorCode, HttpStatus.OK);
    } else {
      return new ResponseEntity<>(user, HttpStatus.OK);
    }
  }
}
