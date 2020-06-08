package com.app.user.service;

import java.util.List;
import java.util.Optional;

import com.app.user.model.User;

public interface IUserService {
	
	public User save(User user);
	
	public List<User> findAll();
	
	public Optional<User> findById(Long id);
	
	public User update(User user);
}
