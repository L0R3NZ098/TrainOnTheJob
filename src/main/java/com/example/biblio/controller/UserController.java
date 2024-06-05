package com.example.biblio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.biblio.model.User;
import com.example.biblio.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("/getall")
	public ResponseEntity<List<User>> getAll() {
		List<User> all = service.getAllUser();
		return ResponseEntity.ok().body(all);
	}
	
	@GetMapping("/getbyid/{id}")
	public ResponseEntity<User> getById(@PathVariable(value = "id") Long id) {
		User one = service.getUserById(id);
		return ResponseEntity.ok().body(one);
	}
	
	@PostMapping("/create")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User create = service.createUser(user);
		return ResponseEntity.ok().body(create);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long id, @RequestBody User user) {
		User update = service.updateUser(id, user);
		return ResponseEntity.ok().body(update);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteUser(@PathVariable(value = "id") Long id) {
		service.deleteUser(id);
		return ResponseEntity.ok().build();
	}
  	
}
