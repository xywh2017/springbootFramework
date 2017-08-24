package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dao.NewsDao;
import com.entity.News;

@Service
@Transactional
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsDao newsDao;
	@Override
	public News add(News news) {
		return newsDao.add(news);
	}

	@Override
	public News update(News news) {
		return null;
	}

	@Override
	public void delete(Long id) {

	}

	@Override
	public News findOne(Long id) {
		return null;
	}

	@Override
	public List<News> findAll() {
		return null;
	}

}
