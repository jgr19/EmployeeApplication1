package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.CoursesDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository; 
	
	@Autowired
	private CourseService courseService;
	
	public EmployeeDto getEmployee(Integer id)
	{
		Employee employee= employeeRepository.getEmployee(id);
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());	
		employeeDto.setAddress(employee.getAddress());
		employeeDto.setPhoneNumber(employee.getPhoneNumber());
		employeeDto.setCourses(courseService.getCoursesForEmployee(employee.getEmployeeId()));
		return employeeDto;		
	}
	
	public List<EmployeeDto> getEmployees()
	{
		List<Employee> employees= employeeRepository.getEmployees();
		List<EmployeeDto> employeeDtoList=new ArrayList<EmployeeDto>();
		for(Employee employee: employees)
		{
			EmployeeDto employeeDto=new EmployeeDto();
			employeeDto.setId(employee.getEmployeeId());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());	
			employeeDto.setAddress(employee.getAddress());
			employeeDto.setPhoneNumber(employee.getPhoneNumber());
			employeeDto.setCourses(courseService.getCoursesForEmployee(employee.getEmployeeId()));
			employeeDtoList.add(employeeDto);
			
		}
		return employeeDtoList;
	}
	
	public EmployeeDto addEmployee(EmployeeDto emp)
	{
		Employee employee=new Employee();
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setAddress(emp.getAddress());
		employee.setPhoneNumber(emp.getPhoneNumber());
		employeeRepository.save(employee);
		courseService.addCourses(emp.getCourses(),employee);
		return emp;
	}
	
	public EmployeeDto updateEmployee(EmployeeDto emp)
	{
		
		Employee employee=new Employee();
		employee.setEmployeeId(emp.getId());
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setAddress(emp.getAddress());
		employee.setPhoneNumber(emp.getPhoneNumber());
		
		//courseService.updateCourses(emp.getCourses());
		employeeRepository.updateEmployee(employee.getEmployeeId(),employee.getFirstName(),employee.getLastName(),employee.getAddress(),employee.getPhoneNumber());
		return emp;
	}
}
