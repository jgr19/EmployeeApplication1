package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Courses;

@Repository
public interface CourseRepository extends JpaRepository<Courses,Integer>{

	
	@Query(value="SELECT c FROM Courses c where c.employee.id=?1")
	List<Courses> FindByEmployeeId(Integer empId);


	
	
	
}
