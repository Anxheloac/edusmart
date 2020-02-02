package com.edusmart.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Course;
import com.edusmart.web.entities.News;
import com.edusmart.web.repositories.NewsRepository;

@Service
public class NewsService {
	@Autowired
	private NewsRepository newsRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<News> getAllNews(){
        List<News> news = new ArrayList<>();
        newsRepository.findAll().forEach(news::add);
        return news;
    }
	
	/**
	 * 
	 * @param category
	 */
	public News create(News news) {
		return this.newsRepository.save(news);
	}
	
	/**
	 * 
	 * @param category
	 */
	public News update(News news, int id) {
		
		News newNw = this.newsRepository.findById(id).map(newNews -> {
			newNews.setTitle(news.getTitle());
			newNews.setCategory(news.getCategory());
			newNews.setDescription(news.getDescription());
			newNews.setLink(news.getLink());
			newNews.setImage(news.getImage());
			newNews.setReadTime(news.getReadTime());
	        return this.newsRepository.save(newNews);
	     }).orElse(news);
		
		return newNw;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public News findById(int id) {
		return this.newsRepository.findById(id).orElse(new News());
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkIfExists(int id) {
		return this.newsRepository.existsById(id);
	}
	
	/**	
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.newsRepository.deleteById(id);
	}
}
