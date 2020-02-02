package com.edusmart.web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Tutorial;
import com.edusmart.web.repositories.TutorialRepository;

@Service
public class TutorialService {
	
	@Autowired
	private TutorialRepository crudRepository;
	
	/**
	 * 
	 * @return
	 */
	public List<Tutorial> getAllTutorials(){
        List<Tutorial> tutorials = new ArrayList<>();
        crudRepository.findAll().forEach(tutorials::add);
        return tutorials;
    }
	
	/**
	 * 
	 * @param tutorial
	 */
	public void create(Tutorial tutorial) {
		
		this.crudRepository.save(tutorial);
	}
	
	/**
	 * 
	 * @param tutorial
	 */
	public Tutorial update(Tutorial tutorial, int id) {
		
		this.crudRepository.findById(id).map(newTutorial -> {
			newTutorial.setName(tutorial.getName());
			newTutorial.setDescription(tutorial.getDescription());
			newTutorial.setCourse(tutorial.getCourse());
	        return this.crudRepository.save(newTutorial);
	     });
		
		return tutorial;
	}
	
	/**	
	 * 
	 * @param id
	 */
	public void incrementView(int id) {
		
		Tutorial current = this.crudRepository.findById(id).get();
		
		current.setTotalViews(current.getTotalViews());
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public Tutorial findById(int id) {
		return this.crudRepository.findById(id).orElse(new Tutorial());
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkIfExists(int id) {
		return this.crudRepository.existsById(id);
	}
	
	/**	
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.crudRepository.deleteById(id);
	}

}
