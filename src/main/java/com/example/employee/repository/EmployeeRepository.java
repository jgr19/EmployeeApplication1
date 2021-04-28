package com.example.employee.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.employee.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

	@Query(value="SELECT e FROM Employee e WHERE e.id=?1")
	public Employee getEmployee(Integer id);
	
	@Query(value="SELECT e FROM Employee e ")
	public List<Employee> getEmployees();
	
	@Transactional
	@Modifying
	@Query(value="UPDATE Employee e SET e.firstName=?2 , e.lastName=?3 , e.address=?4 , e.phoneNumber=?5 WHERE e.employeeId=?1")
	public void updateEmployee(Integer id,String firstName,String lastName,String address,String phoneNumber);
}
