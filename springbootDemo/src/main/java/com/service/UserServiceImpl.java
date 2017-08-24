package com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.UserDao;
import com.entity.News;
import com.entity.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private NewsService newsService;
	@Autowired
	private UserDao userDao;
	
	@Override
	public User createUser(User user) {
		News news=new News();
		news.setTitle("今日头条");
		news.setAuthor("xy");
		news.setReleaseTime(new Date());
		news.setNewsType(0);
		news.setContent("testtesttesttest");
		news=newsService.add(news);
		return userDao.createUser(user);
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Long userId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(Long userId, String newPassword) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changePassword(User user, String newPassword, String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User findOne(Long userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		List<User> list=userDao.findAll();
		return list;
	}

}
