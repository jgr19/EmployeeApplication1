package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.NewEmployeeDto;
import com.example.employee.dto.Response;
import com.example.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@RequestMapping
	public List<EmployeeDto> getEmployee()
	{
		return employeeService.getEmployees();
	}
	
	@RequestMapping("/{id}")
	public EmployeeDto getEmployeeById(@PathVariable Integer id)
	{
		return employeeService.getEmployee(id);
	}
	
	@PostMapping("/new")
	public NewEmployeeDto addEmployee(@RequestBody EmployeeDto emp)
	{
		return employeeService.addEmployee(emp);				
	}
	
	@PutMapping("/update")
	public Response updateEmployee(@RequestBody EmployeeDto emp)
	{
		return employeeService.updateEmployee(emp);		
	}
	
}

