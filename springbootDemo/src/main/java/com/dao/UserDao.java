package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.entity.User;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @SuppressWarnings({ "unchecked", "rawtypes" })
	@Transactional(readOnly = true)
    public List<User> findAll() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper(User.class));
    }

}