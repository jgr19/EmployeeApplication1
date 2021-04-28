package com.example.employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.dto.CoursesDto;
import com.example.employee.entity.Courses;
import com.example.employee.service.CourseService;

@RestController
@RequestMapping("/courses")
public class CoursesController {

	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping
	public List<CoursesDto> getCourses()
	{
		return courseService.getCourses();
	}
	
	@RequestMapping("/employee/{empId}")
	public List<CoursesDto> getCoursesForEmployee(@PathVariable Integer empId)
	{
		return courseService.getCoursesForEmployee(empId);
	}
	
}
