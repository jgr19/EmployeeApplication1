package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.employee.dto.CoursesDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.NewEmployeeDto;
import com.example.employee.dto.Response;
import com.example.employee.entity.Courses;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository; 
	
	//get employee by id
	public EmployeeDto getEmployee(Integer id)
	{
		Employee employee= employeeRepository.getOne(id);
		EmployeeDto employeeDto=new EmployeeDto();
		employeeDto.setId(employee.getEmployeeId());
		employeeDto.setFirstName(employee.getFirstName());
		employeeDto.setLastName(employee.getLastName());	
		employeeDto.setAddress(employee.getAddress());
		employeeDto.setPhoneNumber(employee.getPhoneNumber());
		List<CoursesDto> courseDto=new ArrayList<CoursesDto>();
		for(Courses c:employee.getCourses())
		{
			CoursesDto cDto=new CoursesDto();
			cDto.setCourseName(c.getCourseName());
			cDto.setEndDate(c.getEndDate());
			cDto.setId(c.getEmployee().getEmployeeId());
			cDto.setStartDate(c.getStartDate());
			cDto.setSubject(c.getSubject());		
			courseDto.add(cDto);
		}
		employeeDto.setCourses(courseDto);
		return employeeDto;		
	}
	
	//get all the employees
	public List<EmployeeDto> getEmployees()
	{
		List<Employee> employees= employeeRepository.findAll();
		List<EmployeeDto> employeeDtoList=new ArrayList<EmployeeDto>();
		for(Employee employee: employees)
		{
			EmployeeDto employeeDto=new EmployeeDto();
			employeeDto.setId(employee.getEmployeeId());
			employeeDto.setFirstName(employee.getFirstName());
			employeeDto.setLastName(employee.getLastName());	
			employeeDto.setAddress(employee.getAddress());
			employeeDto.setPhoneNumber(employee.getPhoneNumber());
			List<CoursesDto> cDto=new ArrayList<CoursesDto>();
			for(Courses c:employee.getCourses())
			{
				CoursesDto coursesDto=new CoursesDto();
				coursesDto.setCourseName(c.getCourseName());
				coursesDto.setId(c.getCouseId());
				coursesDto.setEndDate(c.getEndDate());
				coursesDto.setStartDate(c.getStartDate());
				coursesDto.setSubject(c.getSubject());
				cDto.add(coursesDto);				
			}
			employeeDto.setCourses(cDto);
			employeeDtoList.add(employeeDto);
		}
		return employeeDtoList;
	}
	
	//add new employee record(even corresponding course record gets added)
	public NewEmployeeDto addEmployee(EmployeeDto emp)
	{
		Employee employee=new Employee();
		List<Courses> courses=new ArrayList<Courses>();
		Employee savedEmployee;
		NewEmployeeDto newEDto=new NewEmployeeDto();
		employee.setFirstName(emp.getFirstName());
		employee.setLastName(emp.getLastName());
		employee.setAddress(emp.getAddress());
		employee.setPhoneNumber(emp.getPhoneNumber());
		for(CoursesDto cDto: emp.getCourses())
		{
			Courses course=new Courses();
			course.setCourseName(cDto.getCourseName());
			course.setEndDate(cDto.getEndDate());
			course.setStartDate(cDto.getStartDate());
			course.setSubject(cDto.getSubject());
			course.setEmployee(employee);
			courses.add(course);
		}
		employee.setCourses(courses);
		savedEmployee=employeeRepository.save(employee);
		newEDto.setEmployeeId(savedEmployee.getEmployeeId());
		newEDto.setFirstName(savedEmployee.getFirstName());
		newEDto.setLastName(savedEmployee.getLastName());
		return newEDto;
	}
	
	//update existing employee record-->can update first name , last name ,phone number and address
	public Response updateEmployee(EmployeeDto emp)
	{
		
		Employee employee=employeeRepository.getOne(emp.getEmployeeId());
		if(emp.getFirstName()!="" && emp.getFirstName()!=null)
			employee.setFirstName(emp.getFirstName());
		if(emp.getLastName()!="" && emp.getLastName()!=null)
			employee.setLastName(emp.getLastName());
		if(emp.getAddress()!="" && emp.getAddress()!=null)
			employee.setAddress(emp.getAddress());
		if(emp.getPhoneNumber()!="" && emp.getPhoneNumber()!=null)
			employee.setPhoneNumber(emp.getPhoneNumber());	
		employeeRepository.save(employee);
		return  new Response(emp.getEmployeeId());
	}
}
