package com.example.biblio.service;

import java.util.List;

import com.example.biblio.model.User;

public interface UserService {
	
	List<User> getAllUser();
	User getUserById(Long id);
	User createUser(User user);
	User updateUser(Long id, User user);
	void deleteUser(Long id);
	
}
