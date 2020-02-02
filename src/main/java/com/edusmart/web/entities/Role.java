package com.edusmart.web.entities;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	public Role() {
		
	}
	
	public Role(String name, String slug) {
		this.name = name;
		this.slug = slug;
	}
	
	@javax.persistence.Id
	@GeneratedValue
    private int Id;
	@Column(unique = true, nullable=false)
	private String name;
	@Column(unique = true, nullable=false)
	private String slug;
	
	@OneToMany(mappedBy="role")
    Collection<User> users;
	
	/**
	 * @return the users
	 */
	public Collection<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the slug
	 */
	public String getSlug() {
		return slug;
	}
	/**
	 * @param slug the slug to set
	 */
	public void setSlug(String slug) {
		this.slug = slug;
	}
	
}
