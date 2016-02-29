/**
 * 
 */
package com.seval.billcollector.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.seval.billcollector.model.User;
import com.seval.billcollector.repository.UserRepository;

/**
 * @author rajviji
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public List<User> findAllUsersByOrganization(Long organizationid) {
		return userRepository.findAllUsersByOrganization(organizationid);
	}

	@Override
	public User findUserByName(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<User> findAllUsers() {
		return userRepository.findAll();
	}
	
	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepository.save(user);
	}


	@Override
	public User findUser(Long userId) {
		return userRepository.findOne(userId);
	}

}
