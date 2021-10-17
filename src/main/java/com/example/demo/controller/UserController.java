package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repository.UserRepository;
import com.example.demo.model.User;


//@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUser(){
		try{
			List<User> users = new ArrayList<User>();
			userRepository.findAll().forEach(users::add);
			return new ResponseEntity<>(users, HttpStatus.OK);
		} catch(Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") long id) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> creatUser(@RequestBody User user){
		try {
			User _user = userRepository
					.save(new User(user.getUsername(),user.getPhone(),user.getEmail()));
			return new ResponseEntity<User>(_user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
