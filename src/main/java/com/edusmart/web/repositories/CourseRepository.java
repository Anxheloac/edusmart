package com.edusmart.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edusmart.web.entities.Course;
import com.edusmart.web.entities.Role;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer>{

}
