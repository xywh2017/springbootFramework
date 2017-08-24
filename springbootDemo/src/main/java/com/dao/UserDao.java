package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import com.entity.User;

@Repository
public class UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	public User createUser(final User user) {
		final String sql = "insert into sys_user(organization_id, username, password, salt, role_id,realname,phone,email,locked) "
				+ " values(?,?,?,?,?,?,?,?,?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				int count = 1;
				psst.setLong(count++, user.getOrganizationId());
				psst.setString(count++, user.getUsername());
				psst.setString(count++, user.getPassword());
				psst.setString(count++, user.getSalt());
				psst.setLong(count++, user.getRoleId());
				psst.setString(count++, user.getRealname());
				psst.setString(count++, user.getPhone());
				psst.setString(count++, user.getEmail());
				psst.setBoolean(count, user.getLocked());
				return psst;
			}
		}, keyHolder);

		user.setId(keyHolder.getKey().longValue());
		return user;
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<User> findAll() {
        return jdbcTemplate.query("select * from sys_user", new BeanPropertyRowMapper(User.class));
    }

}