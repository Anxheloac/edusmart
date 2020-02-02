package com.edusmart.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edusmart.web.entities.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer>{

}
