package com.example.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.employee.entity.Courses;

public interface CourseRepository extends JpaRepository<Courses,Integer>{

}
