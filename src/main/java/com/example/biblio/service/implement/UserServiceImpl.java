package com.example.biblio.service.implement;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.biblio.model.User;
import com.example.biblio.repository.UserRepository;
import com.example.biblio.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;

	@Override
	public List<User> getAllUser() {
		List<User> all = repository.findAll();
		return all;
	}

	@Override
	public User getUserById(Long id) {
		Optional<User> one = repository.findById(id);
		if (one.isPresent()) {
			return one.get();
		} else {
			return null;
		}
	}

	@Override
	public User createUser(User user) {
		User create = repository.save(user);
		return create;
	}

	@Override
	public User updateUser(Long id, User user) {
		User update = this.getUserById(id);
		BeanUtils.copyProperties(user, update);
		repository.save(update);
		return update;
	}

	@Override
	public void deleteUser(Long id) {
		repository.deleteById(id);
	}

}
