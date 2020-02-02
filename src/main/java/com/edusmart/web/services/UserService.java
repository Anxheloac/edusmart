package com.edusmart.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Role;
import com.edusmart.web.entities.User;
import com.edusmart.web.forms.StudentUser;
import com.edusmart.web.forms.TeacherUser;
import com.edusmart.web.repositories.UserCrudRepository;

@Service
public class UserService {

	@Autowired
	UserCrudRepository userRepository;
	
	@Autowired
	RoleService roleService;
	
	/**	
	 * 
	 * @param newUser
	 * @return
	 */
	public User save(User newUser) {
		newUser = this.userRepository.save(newUser);
		return newUser;
	}
	
	/**	
	 * 
	 * @param newTeacher
	 * @return
	 */
	public User saveForTeacher(TeacherUser newTeacher) {
		User newUser = new User();
		newUser.setEmail(newTeacher.getEmail());
		newUser.setFirstName(newTeacher.getFirstName());
		newUser.setLastName(newTeacher.getLastName());
		newUser.setPassword(newTeacher.getPassword());
		Role teacherRole = this.roleService.findRoleBySlug("teacher");
		newUser.setRole(teacherRole);
		return this.save(newUser);
	}
	
	/**	
	 * 
	 * @param newTeacher
	 * @return
	 */
	public User saveForStudent(StudentUser newStudent) {
		User newUser = new User();
		newUser.setEmail(newStudent.getEmail());
		newUser.setFirstName(newStudent.getFirstName());
		newUser.setLastName(newStudent.getLastName());
		newUser.setPassword(newStudent.getPassword());
		Role studentRole = this.roleService.findRoleBySlug("student");
		newUser.setRole(studentRole);
		return this.save(newUser);
	}
}
