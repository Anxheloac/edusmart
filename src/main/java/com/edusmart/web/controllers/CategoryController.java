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

import com.edusmart.web.entities.Category;
import com.edusmart.web.entities.Teacher;
import com.edusmart.web.services.CategoryService;

@RestController
public class CategoryController {
	
	private final String CONTEXT = "/api/v1/category";
	
	@Autowired
	CategoryService categoryService;
	
	@GetMapping(value = CONTEXT)
	public List<Category> index(){
		return this.categoryService.getAllCategories();
	}
	
	@PostMapping(value = CONTEXT)
	public ResponseEntity<String> store(@Valid @RequestBody Category category) {
		try {
			this.categoryService.create(category);
		} catch(Exception e) {
			return ResponseEntity.ok(e.getMessage());
		}
		return ResponseEntity.ok("Category is addedd");
	}
	
	@PutMapping(value = "/api/v1/category/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Category update(@Valid @RequestBody Category category, @PathVariable int id) {
		return this.categoryService.update(category, id);
	}
	
	@DeleteMapping(value = "/api/v1/category/{id}")
	public void destroy(@PathVariable("id") int id) {
    	if (!this.categoryService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
		this.categoryService.delete(id);
	}

}
