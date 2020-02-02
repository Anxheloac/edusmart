package com.edusmart.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edusmart.web.entities.Category;

@Repository
public interface CategoryCrudRepository extends CrudRepository<Category, Integer> {

}
