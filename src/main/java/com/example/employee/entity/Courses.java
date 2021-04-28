package com.example.employee.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	private LocalDate startDate;
	
	@Column(name="EndDate")
	private LocalDate endDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employeeId")
    private Employee employee;
	
    public Courses() {
		
	}

	public Courses(Integer couseId, String courseName, String subject, LocalDate startDate, LocalDate endDate) {
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
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	
	

}
