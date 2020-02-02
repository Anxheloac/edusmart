package com.edusmart.web.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Teacher;
import com.edusmart.web.entities.User;
import com.edusmart.web.forms.TeacherUser;
import com.edusmart.web.repositories.TeacherCrudRepository;

@Service
public class TeacherService {
	
	@Autowired
	private TeacherCrudRepository teacherRepository;
	
	@Autowired
	private UserService userService;
	
	public List<Teacher> getTeachers(){
        List<Teacher> users = new ArrayList<>();
        teacherRepository.findAll().forEach(users::add);
        return users;
    }
	
	/**	
	 * 
	 * @param teacher
	 * @param id
	 * @return
	 */
	public Teacher update(Teacher teacher, int id) {
		this.teacherRepository.findById(id).map(newTeacher -> {
			newTeacher.setUsername(teacher.getUsername());
			newTeacher.setType(teacher.getType());
			newTeacher.setAddress(teacher.getAddress());
	        return teacherRepository.save(newTeacher);
	     });
		
		return teacher;
	}
	
	/**
	 * 
	 * @param id
	 * @return
	 */
	public boolean checkIfExists(int id) {
		return this.teacherRepository.findById(id).isPresent();
	}
	
	/**	
	 * 
	 * @param id
	 */
	public void delete(int id) {
		this.teacherRepository.deleteById(id);
	}
	
	/**
	 * add teacher
	 */
	@Transactional
	public Teacher addTeacher(TeacherUser newTeacher) {
		
		User user = this.userService.saveForTeacher(newTeacher);
		
		Teacher createdTeacher = new Teacher();
		createdTeacher.setAddress(newTeacher.getAddress());
		createdTeacher.setPhoneNumber(newTeacher.getPhoneNumber());
		createdTeacher.setType(newTeacher.getType());
		createdTeacher.setUser(user);
		createdTeacher.setUsername(newTeacher.getFirstName());
		this.teacherRepository.save(createdTeacher);
		return createdTeacher;
	}
}
