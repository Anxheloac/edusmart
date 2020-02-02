package com.edusmart.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edusmart.web.entities.Role;
import com.edusmart.web.repositories.RoleCrudRepository;

@Service
public class RoleService {
	
	@Autowired
	private RoleCrudRepository roleCrudRepository;
	
	public Role findRoleBySlug(String slug) {
		return this.roleCrudRepository.findBySlug(slug);
	}
}
