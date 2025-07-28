package com.demo.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.DTO.DepartmentNameDTO;
import com.demo.application.Entity.Department;
import com.demo.application.service.DepartmentService;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	
	DepartmentService departmentService;
	
	public DepartmentController(DepartmentService  departmentService) {
		this.departmentService=departmentService;
	}
	
	@GetMapping("/getDepartment")
	public List<Department> getDepartment(){
		return departmentService.getDepartment();
	}
	
	@GetMapping("getDepartmentIdAndName")
	public List<DepartmentNameDTO> getNameAndId(){
		return departmentService.getIdAndName();
	}

	@GetMapping("/getDepartmentById")
	public Optional<Department> getDepartmentById(@RequestParam int departmentId) {
		return departmentService.getById(departmentId);
	}
	
	@GetMapping("Count")
	public int getCount() {
		return departmentService.count();
	}
	
	@PutMapping("updateDepartment")
	public void updateDepartment(@RequestBody Department department) {
		departmentService.update(department);
	}
	
	@PostMapping("/addDepartment")
	public void addDepartment(@RequestBody Department department) {
		departmentService.addDepartment(department);
	}
	
	@DeleteMapping("DeleteDepartmentById")
	public void deleteDepartment(@RequestParam int departmentId) {
		departmentService.deleteDepartment(departmentId);
	}
	
	//delete department by name
	@DeleteMapping("DeleteDepartmentByName")
	public void deleteDepartmentByName(@RequestParam String departmentName) {
		departmentService.deleteDepartment(departmentName);
	}

	//update department by id
	@PutMapping("/updateName")
	public void updateName(@RequestParam int id, @RequestParam String name) {
		departmentService.updateName(id, name);
	}
	
	//update location by departmentname
	@PutMapping("/updateLocation")
	public void updateLocationByName(@RequestParam String name, @RequestParam String newLocation) {
		departmentService.updateLocation(name, newLocation);
	}
	
	//get department by hod name
	@GetMapping("/getDepatmentByHOD")
	public List<DepartmentNameDTO> getDepartmentByHOD(@RequestParam String name){
		return departmentService.getDepartmentByHOD(name);
	}
	
	//department by location
	@GetMapping("/DepartmentCountByLocation")
	public int departmentByLocation(@RequestParam String name) {
		return departmentService.departmentCount(name);
	}
	
	//transfer HOD from one to another department
	@PutMapping("/transferHOD")
	public void transferHOD(@RequestParam int fromDepartmentId, @RequestParam int toDepartmentId) {
		departmentService.transfer(fromDepartmentId, toDepartmentId);
	}
	                         
	
}
