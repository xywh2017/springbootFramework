package com.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.entity.News;
import com.service.NewsService;

@RestController
@RequestMapping(value = "/news")
public class NewsController {
	@Autowired
	private NewsService newsService;

	@RequestMapping(value = "/list", method=RequestMethod.GET)
	public HashMap<String, Object> findAll() {
		HashMap<String, Object> map = new HashMap<String, Object>();
		List<News> list=newsService.findAll();
		map.put("data", list);
		return map;
	}

	@RequestMapping(value = "/add", method=RequestMethod.GET)
	public String addNews() {
		News news=new News();
		news.setTitle("今日头条");
		news.setAuthor("xy");
		news.setReleaseTime(new Date());
		news.setNewsType(0);
		news.setContent("testtesttesttest");
		news=newsService.add(news);
		return "success";
	}
}
