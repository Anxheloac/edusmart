package com.edusmart.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edusmart.web.entities.Tutorial;

@Repository
public interface TutorialRepository extends CrudRepository<Tutorial, Integer>{
}
