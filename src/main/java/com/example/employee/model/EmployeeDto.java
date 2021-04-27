package com.example.employee.model;

import java.util.List;


import com.example.employee.entity.Courses;

public class EmployeeDto {

	private String firstName;
	
	private String lastName;
	
	private String phoneNumber;
	
	private String address;
	
	private List<CoursesDto> courses;
	
	public EmployeeDto() {
		
	}
	
	public EmployeeDto(String firstName, String lastName, String phoneNumber, String address,
			List<CoursesDto> courses) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		phoneNumber = phoneNumber;
		address = address;
		this.courses = courses;
	}
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		phoneNumber = phoneNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		address = address;
	}
	public List<CoursesDto> getCourses() {
		return courses;
	}
	public void setCourses(List<CoursesDto> courses) {
		this.courses = courses;
	}
	
}
