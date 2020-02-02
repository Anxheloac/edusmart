package com.edusmart.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.servlet.ServletContext;

@Service
public class StorageService {

	@Autowired
	ServletContext context;
	
	public String store(MultipartFile file) {
		// Get the file and save it somewhere
        byte[] bytes;
        Path path = null;
		try {
			bytes = file.getBytes();
			path = Paths.get(context.getRealPath("uploads") + file.getOriginalFilename());
	        Files.write(path, bytes);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
		
		return context.getRealPath("uploads") + file.getOriginalFilename();
        
        
	}


}