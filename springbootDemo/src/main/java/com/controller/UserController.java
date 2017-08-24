package com.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.User;
import com.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public HashMap<String, Object> findAll() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<User> list=userService.findAll();
		map.put("data", list);
		return map;
	}
	
	/**
	 * test transactional,when create user failed,rollback service layer.
	 */
	@RequestMapping(value = "/testTx", method=RequestMethod.GET)
	public void test() {
		User user=new User();
		user.setUsername("test");
		user.setPassword("test");
		user=userService.createUser(user);
	}
}
