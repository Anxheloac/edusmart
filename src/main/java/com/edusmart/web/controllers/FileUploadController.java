package com.edusmart.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.edusmart.web.services.StorageService;

@RestController
public class FileUploadController {
	
	@Autowired
	private StorageService storageService;
	
	@PostMapping("/api/v1/upload-file")
	public String handleFileUpload(@RequestParam("file") MultipartFile file) {

		storageService.store(file);
		
		return file.getOriginalFilename();
	}
}
