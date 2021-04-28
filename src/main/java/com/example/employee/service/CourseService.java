package com.example.employee.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.dto.CoursesDto;
import com.example.employee.entity.Courses;
import com.example.employee.entity.Employee;
import com.example.employee.repository.CourseRepository;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	public void addCourses(List<CoursesDto> coursesDto,Employee employee) {
		List<Courses> courses=new ArrayList<Courses>();
		for(CoursesDto c:coursesDto)
		{
			Courses course=new Courses();
			course.setCourseName(c.getCourseName());
			course.setSubject(c.getSubject());
			course.setEndDate(c.getEndDate());
			course.setStartDate(c.getStartDate());
			course.setEmployee(employee);
			courses.add(course);
			courseRepository.save(course);	
		}
		 
	}

	public List<CoursesDto> getCourses()
	{
		List<Courses> courses= courseRepository.findAll();
		List<CoursesDto> coursesDto=new ArrayList<CoursesDto>();
		for(Courses c :courses)
		{
			CoursesDto cDto=new CoursesDto();
			cDto.setId(c.getCouseId());
			cDto.setCourseName(c.getCourseName());
			cDto.setEndDate(c.getEndDate());
			cDto.setStartDate(c.getStartDate());
			cDto.setSubject(c.getSubject());
			
			coursesDto.add(cDto);
		}
		return coursesDto;		
	}

	public List<CoursesDto> getCoursesForEmployee(Integer empId) {
		List<Courses> courses=courseRepository.FindByEmployeeId(empId);
		List<CoursesDto> coursesDto=new ArrayList<CoursesDto>();
		for(Courses c :courses)
		{
			CoursesDto cDto=new CoursesDto();
			cDto.setId(c.getCouseId());
			cDto.setCourseName(c.getCourseName());
			cDto.setEndDate(c.getEndDate());
			cDto.setStartDate(c.getStartDate());
			cDto.setSubject(c.getSubject());
			
			coursesDto.add(cDto);
		}
		return coursesDto;	
	}
}
