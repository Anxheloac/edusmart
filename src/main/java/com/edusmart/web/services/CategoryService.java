package com.edusmart.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Category;
import com.edusmart.web.repositories.CategoryCrudRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryCrudRepository crudRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<Category> getAllCategories(){
        List<Category> categories = new ArrayList<>();
        crudRepository.findAll().forEach(categories::add);
        return categories;
    }
	
	/**
	 * 
	 * @param category
	 */
	public void create(Category category) {
		category.setSlug(category.getName());
		this.crudRepository.save(category);
	}
	
	/**
	 * 
	 * @param category
	 */
	public Category update(Category category, int id) {
		category.setSlug(category.getName());
		
		this.crudRepository.findById(id).map(newCategory -> {
			newCategory.setName(category.getName());
			newCategory.setDescription(category.getDescription());
	        return this.crudRepository.save(newCategory);
	     });
		
		return category;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkIfExists(int id) {
		return this.crudRepository.findById(id).isPresent();
	}
	
	/**	
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.crudRepository.deleteById(id);
	}
}
