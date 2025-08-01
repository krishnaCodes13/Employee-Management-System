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
	
	@Transactional
	public void updateName(int id, String name) {
		Optional<Department> existing = departmentRepo.findById(id);
		if(existing.isPresent()) {
			Department department = existing.get();
			department.setDepartmentName(name);
			departmentRepo.save(department);
		}
	}
	
	@Transactional
	public void updateLocation(String name, String location) {
		Department existing = departmentRepo.findByDepartmentName(name);
		if(existing!=null) {
			existing.setLocation(location);
			departmentRepo.save(existing);
		}
	}
	
	@Transactional
	public List<DepartmentNameDTO> getDepartmentByHOD(String name) {
		return departmentRepo.getDepartmentNameByheadOfDepartment(name);
	}
	
	@Transactional
	public int departmentCount(String name) {
//		List<Department> existing = departmentRepo.findDepartmentNameByLocation(name);
//		return existing.size();
		
		return departmentRepo.findDepartmentNameByLocation(name).size();
		}
	
	@Transactional
	public void transfer(int fromDepartmentId, int toDepartmentId) {
		Optional<Department> previous = departmentRepo.findById(fromDepartmentId);
		Optional<Department> latest = departmentRepo.findById(toDepartmentId);
		
		if(previous.isPresent()&&latest.isPresent()) {
			Department previousDepartment = previous.get();
			Department latestDepartment = latest.get();
			latestDepartment.setHeadOfDepartment(previousDepartment.getHeadOfDepartment());
			departmentRepo.save(latestDepartment);
		}	
	}
}
