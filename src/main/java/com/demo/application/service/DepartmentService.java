package com.demo.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.demo.application.DTO.DepartmentNameDTO;
import com.demo.application.Entity.Department;
import com.demo.application.repository.DepartmentRepository;

import jakarta.transaction.Transactional;

@Service
public class DepartmentService {
	
	DepartmentRepository departmentRepo;
	
	public DepartmentService(DepartmentRepository departmentRepo) {
		this.departmentRepo=departmentRepo;
	}
	
	public List<Department>getDepartment(){
		return departmentRepo.findAll();
	}
	
	public List<DepartmentNameDTO> getIdAndName() {
		return departmentRepo.departmentDto();
	}
	
	public Optional<Department> getById(int departmentId) {
		return departmentRepo.findById(departmentId);
	}
	
	public int count() {
		return (int) departmentRepo.count();
	}
	
	public void update(Department department) {
		departmentRepo.save(department);
	}
	
	public void addDepartment(Department department) {
		departmentRepo.save(department);
	}
	
	@Transactional
	public void deleteDepartment(String departmentName) {
		departmentRepo.deleteByDepartmentName(departmentName);
	}
	
	public void deleteDepartment(int departmentId) {
		departmentRepo.deleteById(departmentId);
	}
}
