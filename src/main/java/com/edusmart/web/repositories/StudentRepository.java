package com.edusmart.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edusmart.web.entities.Student;
import com.edusmart.web.entities.Teacher;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer> {

}
