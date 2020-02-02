package com.edusmart.web.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.edusmart.web.repositories.UserCrudRepository;

@Component
public class DatabaseSeeder {

    @Autowired
    private UserCrudRepository userRepository;

    //method invoked during the startup
    @PostConstruct
    public void loadData() {
    }

    //method invoked during the shutdown
    @PreDestroy
    public void removeData() {
//        userRepository.deleteAll();
    }
}