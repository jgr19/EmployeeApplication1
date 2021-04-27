package com.example.employee.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;

import com.example.employee.entity.Courses;

public class CoursesDto {

	@Column(name="CourseName")
	private String courseName;
	
	@Column(name="Subject")
	private String subject;
	
	@Column(name="StartDate")
	private Date startDate;
	
	@Column(name="EndDate")
	private Date endDate;
	
	public CoursesDto() {
		
	}
	
	public CoursesDto(String courseName, String subject, Date startDate, Date endDate) {

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

	public List<Courses> getCourses(List<CoursesDto> coursesDto) {
		List<Courses> courses=new ArrayList<Courses>();
		for(CoursesDto c:coursesDto)
		{
			Courses course=new Courses();
			course.setCourseName(c.getCourseName());
			course.setSubject(c.getSubject());
			course.setEndDate(c.getEndDate());
			course.setStartDate(c.getStartDate());
			courses.add(course);
			
			
		}
		return courses;
	}
	
}
