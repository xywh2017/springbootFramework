package com.service;

import java.util.List;

import com.entity.News;

public interface NewsService {
	public News add(News news);

	public News update(News news);

	public void delete(Long id);
    
    public News findOne(Long id);
    
    public List<News> findAll();
}