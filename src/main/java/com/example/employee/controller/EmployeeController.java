package com.example.employee.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.entity.Courses;
import com.example.employee.entity.Employee;
import com.example.employee.model.EmployeeDto;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping
	public List<Employee> getEmployee()
	{
		return employeeService.getEmployees();
	}
	
	@RequestMapping("/{id}")
	public Employee getEmployeeById(@PathVariable Integer id)
	{
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/new")
	public Employee AddEmployee(@RequestBody EmployeeDto emp)
	{
		return employeeService.addEmployee(emp);
				
	}
	
}

