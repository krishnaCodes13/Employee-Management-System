package com.demo.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.demo.application.DTO.DepartmentNameDTO;
import com.demo.application.Entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
	
	@Query("SELECT new com.demo.application.DTO.DepartmentNameDTO(d.departmentId, d.departmentName) FROM Department d")
	public List<DepartmentNameDTO> departmentDto();

	public void deleteByDepartmentName(String departmentName);

}
