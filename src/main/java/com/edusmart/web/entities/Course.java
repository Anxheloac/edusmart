package com.edusmart.web.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="courses")
public class Course {
	
	@Id
    @GeneratedValue
	private int id;
	@Column(unique = true, nullable=false)
	@NotEmpty(message = "Please provide a name")
	private String name;
	@Column(nullable=true)
	private String description;
	private float price;
	private boolean isPremium;
	private String skillLevel;
	private int totalViews;
	private int totalSubscribers;
	private String path;
	@Column(nullable=true)
	private String directory;
	
	@OneToMany
	private Set<Tutorial> tutorials = new HashSet();
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the directory
	 */
	public String getDirectory() {
		return directory;
	}
	/**
	 * @param directory the directory to set
	 */
	public void setDirectory(String directory) {
		this.directory = directory;
	}
	
	@ManyToMany
	@JoinTable(
			  name = "course_categories", 
			  joinColumns = @JoinColumn(name = "course_id"), 
			  inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> categories;
	
	@ManyToOne
	Teacher teacher;
	
	/**
	 * @return the teacher
	 */
	public Teacher getTeacher() {
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	/**
	 * @return the categories
	 */
	public Set<Category> getCategories() {
		return categories;
	}
	/**
	 * @param categories the categories to set
	 */
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the price
	 */
	public float getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(float price) {
		this.price = price;
	}
	/**
	 * @return the isPremium
	 */
	public boolean isPremium() {
		return isPremium;
	}
	/**
	 * @param isPremium the isPremium to set
	 */
	public void setPremium(boolean isPremium) {
		this.isPremium = isPremium;
	}
	/**
	 * @return the skillLevel
	 */
	public String getSkillLevel() {
		return skillLevel;
	}
	/**
	 * @param skillLevel the skillLevel to set
	 */
	public void setSkillLevel(String skillLevel) {
		this.skillLevel = skillLevel;
	}
	/**
	 * @return the totalViews
	 */
	public int getTotalViews() {
		return totalViews;
	}
	/**
	 * @param totalViews the totalViews to set
	 */
	public void setTotalViews(int totalViews) {
		this.totalViews = totalViews;
	}
	/**
	 * @return the totalSubscribers
	 */
	public int getTotalSubscribers() {
		return totalSubscribers;
	}
	/**
	 * @param totalSubscribers the totalSubscribers to set
	 */
	public void setTotalSubscribers(int totalSubscribers) {
		this.totalSubscribers = totalSubscribers;
	}
	

}
