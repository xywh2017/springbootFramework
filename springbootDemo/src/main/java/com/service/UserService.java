package com.service;

import java.util.List;

import com.entity.User;

public interface UserService {
	public User createUser(User user);

	public User updateUser(User user);

	public void deleteUser(Long userId);
	
	/**
     * 修改密码
     * 
     * @param userId
     * @param newPassword
     */
    public void changePassword(Long userId, String newPassword);
    
    /**
     * 用户名,密码修改
     * 
     * @param userId
     * @param newPassword
     */
    public void changePassword(User user, String newPassword, String username);
    
    /**
     * 
     * @param userId
     * @return
     */
    public User findOne(Long userId);
    
    public List<User> findAll();
}