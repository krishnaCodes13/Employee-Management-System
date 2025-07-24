package com.demo.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.application.DTO.EmployeeDTO;
import com.demo.application.Entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	 @Query("SELECT new com.demo.application.DTO.EmployeeDTO(e.firstName, e.lastName, e.age) FROM Employee e")
	public List<EmployeeDTO> findName();

	public List<Employee> findByFirstName(String firstName);
	 

}
