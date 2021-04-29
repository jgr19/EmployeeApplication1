package com.example.employee.dto;

public class Response {
	
	private Integer id;
	private String statusMessage;
	
	 public Response(Integer id) {
	        this.id = id;
	        this.statusMessage = "Employee Data Updated Successfully!!!";
	    }
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return statusMessage;
	}
	public void setMessage(String message) {
		this.statusMessage = message;
	}
	
	

}
