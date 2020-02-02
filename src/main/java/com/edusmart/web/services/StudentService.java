package com.edusmart.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Student;
import com.edusmart.web.entities.User;
import com.edusmart.web.forms.StudentUser;
import com.edusmart.web.repositories.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private UserService userService;
	
	public List<Student> getStudents(){
        List<Student> users = new ArrayList<>();
        studentRepository.findAll().forEach(users::add);
        return users;
    }
	
	/**	
	 * 
	 * @param teacher
	 * @param id
	 * @return
	 */
	public Student update(Student student, int id) {
		this.studentRepository.findById(id).map(newStudent -> {
			newStudent.setCardExpiration(student.getCardExpiration());
			newStudent.setCardNumber(student.getCardExpiration());
			newStudent.setUser(student.getUser());
	        return studentRepository.save(newStudent);
	     });
		
		return student;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkIfExists(int id) {
		return this.studentRepository.findById(id).isPresent();
	}
	
	/**	
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.studentRepository.deleteById(id);
	}
	
	/**
	 * add teacher
	 */
	@Transactional
	public Student addStudent(StudentUser newStudent) {
		
		User user = this.userService.saveForStudent(newStudent);
		
		Student createdStudent = new Student();
		createdStudent.setCardExpiration(newStudent.getCardExpiration());
		createdStudent.setCardNumber(newStudent.getCardNumber());
		createdStudent.setUser(user);
		createdStudent.setUsername(newStudent.getFirstName());
		this.studentRepository.save(createdStudent);
		return createdStudent;
	}
}
