package com.seval.billcollector.service;

import java.util.List;

import com.seval.billcollector.model.User;

public interface UserService {

	public List<User> findAllUsersByOrganization(Long organizationid);
	public List<User> findAllUsers();
	public User findUser(Long userId);
	public User findUserByName(String username);
	public void deleteUser(User user);
	public User saveUser(User user);
	public User updateUser(User user);
}
