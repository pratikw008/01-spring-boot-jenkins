package com.app.user.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.app.user.model.User;
import com.app.user.repository.UserRepository;
import com.app.user.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	
	private UserRepository repo;
	
	public UserServiceImpl(UserRepository repo) {
		this.repo = repo;
	}

	@Override
	public User save(User user) {
		return repo.save(user);
	}

	@Override
	public List<User> findAll() {
		return repo.findAll();
	}
	
	@Override
	public Optional<User> findById(Long id) {
		return repo.findById(id);
	}
	
	@Override
	public User update(User user) {
		if(user != null) {
			User savedInDb = repo.save(user);
			return savedInDb;
		}
		else {
			throw new RuntimeException("User Not Found");
		}
	}
}
