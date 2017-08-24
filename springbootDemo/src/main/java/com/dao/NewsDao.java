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

import com.entity.News;

@Repository
public class NewsDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

	public News add(final News news) {
		final String sql = "insert into sys_news(title, author, release_time, news_type, content,img,available) "
				+ " values(?,?,?,?,?,?,?)";

		GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement psst = connection.prepareStatement(sql, new String[] { "id" });
				int count = 1;
				psst.setString(count++, news.getTitle());
				psst.setString(count++, news.getAuthor());
				psst.setTimestamp(count++, new java.sql.Timestamp(news.getReleaseTime().getTime()));
				psst.setInt(count++, news.getNewsType());
				psst.setString(count++, news.getContent());
				psst.setString(count++, news.getImg());
				psst.setBoolean(count++, news.getAvailable());
				return psst;
			}
		}, keyHolder);

		news.setId(keyHolder.getKey().longValue());
		return news;
	}
    
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<News> findAll() {
        return jdbcTemplate.query("select * from sys_news", new BeanPropertyRowMapper(News.class));
    }

}