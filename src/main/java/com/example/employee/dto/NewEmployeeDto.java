package com.example.employee.dto;

public class NewEmployeeDto {
	
	private Integer employeeId;
	private String firstName;
	private String lastName;
	
	public NewEmployeeDto()
	{
		
	}
		
	public NewEmployeeDto(Integer employeeId, String firstName, String lastName) {
		super();
		this.employeeId = employeeId;
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Integer getEmployeeId() {
		return employeeId;
	}
	
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
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
	
}
