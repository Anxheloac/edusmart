package com.edusmart.web.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="tutorials")
public class Tutorial {
	
	@Id
    @GeneratedValue
	private int id;
	@Column(unique = true, nullable=false)
	@NotEmpty(message = "Please provide a name")
	private String name;
	@Column(nullable=true)
	private String description;
	
	@ManyToOne
	private Course course;
	
	@ManyToOne
	private Teacher teacher;
	private String durationTime;
	private int priority;
	private String link;
	private int totalViews;
	
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
	 * @return the course
	 */
	public Course getCourse() {
		return course;
	}
	/**
	 * @param course the course to set
	 */
	public void setCourse(Course course) {
		this.course = course;
	}
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
	 * @return the durationTime
	 */
	public String getDurationTime() {
		return durationTime;
	}
	/**
	 * @param durationTime the durationTime to set
	 */
	public void setDurationTime(String durationTime) {
		this.durationTime = durationTime;
	}
	/**
	 * @return the priority
	 */
	public int getPriority() {
		return priority;
	}
	/**
	 * @param priority the priority to set
	 */
	public void setPriority(int priority) {
		this.priority = priority;
	}
	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
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

}
