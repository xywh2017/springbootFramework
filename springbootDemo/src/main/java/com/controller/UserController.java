package com.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entity.User;
import com.service.UserService;

@Controller
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

}
