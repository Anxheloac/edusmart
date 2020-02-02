package com.edusmart.web.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.edusmart.web.entities.Student;
import com.edusmart.web.forms.StudentUser;
import com.edusmart.web.services.StudentService;

import java.io.IOException;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
public class StudentController {
	
	private final String CONTEXT = "/api/v1/student";
	
    private final Logger LOGGER = Logger.getLogger(StudentController.class.getName());
    private FileHandler filehandler;
	
	@Autowired
	private StudentService studentService;
	
	public StudentController() {
		try {
            filehandler = new FileHandler("Serverlog.log", 1024 * 8, 1, true);
            LOGGER.addHandler(filehandler);
            SimpleFormatter formatter = new SimpleFormatter();
            filehandler.setFormatter(formatter);
            LOGGER.setLevel(Level.FINE);
            filehandler.setLevel(Level.INFO);
        }catch(IOException io){
            System.out.println("ERROR: Could not set logging handler to file");
        }
	}
	
	@GetMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<Student> index(){
        return studentService.getStudents();
    }
	
	@PutMapping(value = "/api/v1/student/{id}")
    @ResponseStatus(HttpStatus.OK)
	public Student update(@Valid @RequestBody Student student, @PathVariable int id) {
		return this.studentService.update(student, id);
	}
	
	@PostMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.CREATED)
	public void store(@Valid @RequestBody StudentUser student) {
		try {
			 LOGGER.info("Store student:" + student.toString());
			 studentService.addStudent(student);
		} catch(Exception e) {
			 LOGGER.info(e.getMessage());
			System.out.print(e.getMessage());
		}
	}
	
	@DeleteMapping(value = "/api/v1/student/{id}")
	public void destroy(@PathVariable("id") int id) {
    	if (!this.studentService.checkIfExists(id)) {
            ResponseEntity.badRequest().build();
        }
		this.studentService.delete(id);
	}
}
