/**
 * 
 */
package com.seval.billcollector.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seval.billcollector.model.User;
import com.seval.billcollector.service.UserService;


/**
 * @author rajviji
 *
 */
	@RestController
	@RequestMapping("/api/user")
	public class UserRestController {

		@Autowired
		UserService userService;
		
		/**
		 * @return the userService
		 */
		public UserService getUserService() {
			return userService;
		}

		/**
		 * @param userService the userService to set
		 */
		public void setUserService(UserService userService) {
			this.userService = userService;
		}

		@RequestMapping(value="/id/{id}",method=RequestMethod.GET)
		public ResponseEntity<User> geUser(@PathVariable Long id) {
			User user = null;
			System.out.println("Calling Rest: Get  User Service");
			user = userService.findUser(id);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		@RequestMapping(value="/name/{username}", method=RequestMethod.GET)
		public ResponseEntity<User> findUser(@PathVariable String username) {
			User user = null;
			System.out.println("Calling Rest: Get User by Name Service");
			user = userService.findUserByName(username);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}

		@RequestMapping(value="/org/{organizationid}",method=RequestMethod.GET)
		public ResponseEntity<List<User>> getUsersByOrganization(@PathVariable Long organizationid) {
			List<User> userList = null;
			System.out.println("Calling Rest: Get  User Service");
			userList = userService.findAllUsersByOrganization(organizationid);
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		}
		
		@RequestMapping(value="/all",method=RequestMethod.GET)
		public ResponseEntity<List<User>> findAllUsers() {
			List<User> userList = null;
			System.out.println("Calling Rest: Get  All User Service");
			userList = userService.findAllUsers();
			return new ResponseEntity<List<User>>(userList, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> saveUser(@RequestBody User user) {
			System.out.println("Calling Rest: Save User");
			userService.saveUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> updateUser(@RequestBody User user) {
			System.out.println("Calling Rest: Update User");
			userService.updateUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
		@RequestMapping(method=RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE,
				produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<User> deleteUser(@RequestBody User user) {
			System.out.println("Calling Rest: Delete User");
			userService.deleteUser(user);
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
		
	}