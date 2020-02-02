package com.edusmart.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Category;
import com.edusmart.web.entities.Course;
import com.edusmart.web.repositories.CategoryCrudRepository;
import com.edusmart.web.repositories.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository crudRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<Course> getAllCourses(){
        List<Course> courses = new ArrayList<>();
        crudRepository.findAll().forEach(courses::add);
        return courses;
    }
	
	/**
	 * 
	 * @param category
	 */
	public Course create(Course course) {
		return this.crudRepository.save(course);
	}
	
	/**
	 * 
	 * @param category
	 */
	public Course update(Course course, int id) {
		
		this.crudRepository.findById(id).map(newCourse -> {
			newCourse.setName(course.getName());
			newCourse.setDescription(course.getDescription());
			newCourse.setPremium(course.isPremium());
			newCourse.setSkillLevel(course.getSkillLevel());
			if(!course.getCategories().isEmpty()) {
				newCourse.setCategories(course.getCategories());
			}
	        return this.crudRepository.save(newCourse);
	     });
		
		return course;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Course findById(int id) {
		return this.crudRepository.findById(id).orElse(new Course());
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkIfExists(int id) {
		return this.crudRepository.existsById(id);
	}
	
	/**	
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.crudRepository.deleteById(id);
	}
}
