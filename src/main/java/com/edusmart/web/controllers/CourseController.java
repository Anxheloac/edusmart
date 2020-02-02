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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edusmart.web.entities.Course;
import com.edusmart.web.services.CourseService;

@RestController
public class CourseController {
	
	private final String CONTEXT = "/api/v1/course";
	
	@Autowired
	CourseService courseService;
	
	@GetMapping(value = CONTEXT)
	public List<Course> index(){
		return this.courseService.getAllCourses();
	}
	
	@PostMapping(value = CONTEXT)
	public Course store(@Valid @RequestBody Course course) {
		Course newCourse = null;
		newCourse = this.courseService.create(course);
		
		return newCourse;
	}
	
	@PutMapping(value = "/api/v1/course/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Course update(@Valid @RequestBody Course course, @PathVariable int id) {
		return this.courseService.update(course, id);
	}
	
	@DeleteMapping(value = "/api/v1/course/{id}")
	public void destroy(@PathVariable("id") int id) {
    	if (!this.courseService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
		this.courseService.delete(id);
	}
	
	@GetMapping(value = "/api/v1/course/{id}")
	public Course show(@PathVariable("id") int id) {
    	if (!this.courseService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
    	
    	return this.courseService.findById(id);
	}
}
