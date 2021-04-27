package com.example.employee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value="SELECT e FROM Employee e WHERE e.id=?1")
	public Employee getEmployee(Integer id);
	
	@Query(value="SELECT e FROM Employee e ")
	public List<Employee> getEmployees();
}
