package com.example.employee.dto;

import java.time.LocalDate;
import java.util.Date;

public class CoursesDto {

	private Integer id;
	
	private String courseName;
	
	private String subject;
	
	private LocalDate startDate;
	
	private LocalDate endDate;
	
	public CoursesDto() {
		
	}
	
	public CoursesDto(String courseName, String subject, LocalDate startDate, LocalDate endDate) {

		this.courseName = courseName;
		this.subject = subject;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
