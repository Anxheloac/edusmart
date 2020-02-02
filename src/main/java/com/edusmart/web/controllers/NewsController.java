package com.edusmart.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edusmart.web.entities.News;
import com.edusmart.web.services.NewsService;;

@RestController
public class NewsController {
private final String CONTEXT = "/api/v1/news";
	
	@Autowired
	NewsService newsService;
	
	@GetMapping(value = CONTEXT)
	public List<News> index(){
		return this.newsService.getAllNews();
	}
	
	@PostMapping(value = CONTEXT)
	public News store(@Valid @RequestBody News news) {
		News newNews = null;
		
		newNews = this.newsService.create(news);
		
		return newNews;
	}
	
	@PutMapping(value = "/api/v1/news/{id}")
    @ResponseStatus(HttpStatus.OK)
	public News update(@Valid @RequestBody News news, @PathVariable int id) {
		return this.newsService.update(news, id);
	}
	
	@DeleteMapping(value = "/api/v1/news/{id}")
	public void destroy(@PathVariable("id") int id) {
    	if (!this.newsService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
		this.newsService.delete(id);
	}
	
	@GetMapping(value = "/api/v1/news/{id}")
	public News show(@PathVariable("id") int id) {
    	if (!this.newsService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
    	
    	return this.newsService.findById(id);
	}
}
