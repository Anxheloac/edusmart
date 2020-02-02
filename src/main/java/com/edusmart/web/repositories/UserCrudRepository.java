package com.edusmart.web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edusmart.web.entities.User;

@Repository
public interface UserCrudRepository extends CrudRepository<User, Integer>{

}
