package com.example.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.entity.Employee;
import com.example.employee.model.CoursesDto;
import com.example.employee.model.EmployeeDto;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository; 
	
	public Employee getEmployee(Integer id)
	{
		return employeeRepository.getEmployee(id);
	}
	
	public List<Employee> getEmployees()
	{
		return employeeRepository.getEmployees();
	}
	
	public Employee addEmployee(EmployeeDto emp)
	{
		Employee employee=new Employee();
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setAddress(emp.getAddress());
		CoursesDto courseDto=new CoursesDto();
		employee.setCourses(courseDto.getCourses(emp.getCourses()));
		employeeRepository.save(employee);
		return employee;
	}
}
