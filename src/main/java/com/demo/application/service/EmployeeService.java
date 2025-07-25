package com.demo.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.application.DTO.EmployeeDTO;
import com.demo.application.Entity.Employee;
import com.demo.application.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepo;
	
	public EmployeeService(EmployeeRepository repo) {
		this.employeeRepo=repo;
	}
	
	public void setEmployee(Employee employee ) {
		employeeRepo.save(employee);
	}
	
	public List<Employee> getEmployee() {
		return employeeRepo.findAll();
	}
	
	public List<EmployeeDTO> getEmployeeNames() {
		return employeeRepo.findName();
	}
	
	public Optional<Employee> getEmployeeById(int id) {
		return employeeRepo.findById(id);
	}
	
	public List<Employee> getEmployeeByFirstName(String FirstName){
		return employeeRepo.findByFirstName(FirstName);
	}
}
