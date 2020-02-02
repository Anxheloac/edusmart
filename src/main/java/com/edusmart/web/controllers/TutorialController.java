package com.edusmart.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edusmart.web.entities.Tutorial;
import com.edusmart.web.services.TutorialService;

@RestController
public class TutorialController {
	
private final String CONTEXT = "/api/v1/tutorial";
	
	@Autowired
	TutorialService tutorialService;
	
	@GetMapping(value = CONTEXT)
	public List<Tutorial> index(){
		return this.tutorialService.getAllTutorials();
	}
	
	@PostMapping(value = CONTEXT)
	public ResponseEntity<String> store(@Valid @RequestBody Tutorial tutorial) {
		try {
			this.tutorialService.create(tutorial);
		} catch(Exception e) {
			return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
		}
		
		return ResponseEntity.ok("Tutorial is addedd");
	}
	
	@PutMapping(value = "/api/v1/tutorial/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Tutorial update(@Valid @RequestBody Tutorial tutorial, @PathVariable int id) {
		if (!this.tutorialService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
		return this.tutorialService.update(tutorial, id);
	}
	
	@PostMapping(value = "/api/v1/tutorial/{id}/view")
    @ResponseStatus(HttpStatus.OK)
	public void incrementView(@PathVariable int id) {
		if (!this.tutorialService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
		
		
		
	}
	
	@DeleteMapping(value = "/api/v1/tutorial/{id}")
	public void destroy(@PathVariable("id") int id) {
    	if (!this.tutorialService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
		this.tutorialService.delete(id);
	}
	
	@GetMapping(value = "/api/v1/tutorial/{id}")
	public Tutorial show(@PathVariable("id") int id) {
    	if (!this.tutorialService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
    	
    	return this.tutorialService.findById(id);
	}
}
