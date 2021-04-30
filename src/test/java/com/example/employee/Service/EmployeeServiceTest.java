package com.example.employee.Service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import com.example.employee.dto.CoursesDto;
import com.example.employee.dto.EmployeeDto;
import com.example.employee.dto.NewEmployeeDto;
import com.example.employee.dto.Response;
import com.example.employee.entity.Courses;
import com.example.employee.entity.Employee;
import com.example.employee.repository.EmployeeRepository;
import com.example.employee.service.EmployeeService;



@RunWith(MockitoJUnitRunner.class)
public class EmployeeServiceTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;
	
	@Before public void setup()
	{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetEmployee()
	{
		Employee emp=getEmployee();
		when(employeeRepository.getOne(Mockito.anyInt())).thenReturn(emp);
		EmployeeDto empDto=employeeService.getEmployee(1);
		assertEquals(emp.getFirstName(), empDto.getFirstName());		
	}
	
	@Test
	public void testGetEmployees()
	{
		List<Employee> empList=new ArrayList<Employee>();
		Employee emp1=getEmployee();
		Employee emp2=getEmployee();
		empList.add(emp1);
		empList.add(emp2);
		when(employeeRepository.findAll()).thenReturn(empList);
		List<EmployeeDto> empDtoList=employeeService.getEmployees();
		assertEquals(2,empDtoList.size());
	}
	
	@Test
	public void testAddEmployee()
	{
		Employee emp=getEmployee();
		EmployeeDto empDtoIn=getEmployeeDto();
		when(employeeRepository.save(Mockito.any(Employee.class))).thenReturn(emp);
		NewEmployeeDto empDtoOut=employeeService.addEmployee(empDtoIn);
		assertEquals(empDtoIn.getFirstName(), empDtoOut.getFirstName());		
	}
	
	@Test
	public void testUpdateEmployee()
	{
		Employee emp=getEmployee();
		when(employeeRepository.getOne(1)).thenReturn(emp);
		EmployeeDto empDto=new EmployeeDto();
		empDto.setId(emp.getEmployeeId());
		empDto.setLastName("Raj");
		Response response=employeeService.updateEmployee(empDto);
		assertEquals(empDto.getId(), response.getId());
	}
	
	
	private Employee getEmployee()
	{
		List<Courses> course=new ArrayList<Courses>();
		course.add(new Courses(1,"Java", "java", LocalDate.now(), LocalDate.of(2022, Month.MARCH, 22)));
		course.get(0).setEmployee(new Employee());
		Employee emp=new Employee(1,"Jagrathi","Rai","1234567890","Panaji,Goa",course);
		return emp;
	}
	
	private EmployeeDto getEmployeeDto()
	{
		List<CoursesDto> courseDto=new ArrayList<CoursesDto>();
		courseDto.add(new CoursesDto("Java", "java", LocalDate.now(), LocalDate.of(2022, Month.MARCH, 22)));
		EmployeeDto empDto=new EmployeeDto("Jagrathi","Rai","1234567890","Panaji,Goa",courseDto);
		empDto.setId(1);
		return empDto;
	}

}
