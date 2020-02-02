package com.edusmart.web;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.edusmart.web.services.StorageService;

@SpringBootApplication

public class EdusmartApplication {

	public static void main(String[] args) {
		SpringApplication.run(EdusmartApplication.class, args);
	}
}
