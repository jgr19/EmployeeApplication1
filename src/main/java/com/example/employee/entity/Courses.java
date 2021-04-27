package com.example.employee.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Courses")
public class Courses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer couseId;
	
	@Column(name="CourseName")
	private String courseName;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="StartDate")
	private Date startDate;
	
	@Column(name="EndDate")
	private Date endDate;
	
	public Courses() {
		
	}
	
	public Courses(Integer couseId, String courseName, String subject, Date startDate, Date endDate) {
		super();
		this.couseId = couseId;
		this.courseName = courseName;
		this.subject = subject;
		this.startDate = startDate;
		this.endDate = endDate;
	}
	
	
	public Integer getCouseId() {
		return couseId;
	}
	public void setCouseId(Integer couseId) {
		this.couseId = couseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	
	
	

}
