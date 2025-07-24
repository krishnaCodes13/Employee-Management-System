package com.demo.application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.application.DTO.EmployeeDTO;
import com.demo.application.Entity.Employee;
import com.demo.application.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping("/addEmployee")
	public void setEmployee(@RequestBody Employee employee) { 
		employeeService.setEmployee(employee);
	}
	
	@GetMapping("/getEmployee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
	}
	
	@GetMapping("/getEmployeeeName")
	public List<EmployeeDTO> getEmployeeName(){
		return employeeService.getEmployeeNames();
	}
	
	@GetMapping("/employeeById")
	public Optional<Employee> getEmployeeById(@RequestParam int id) {
		return employeeService.getEmployeeById(id);
	}
	
	@GetMapping("/findByFirstName/{firstName}")
	public List<Employee> getEmployeeByFirstName(@PathVariable String firstName){
		return employeeService.getEmployeeByFirstName(firstName);
	}

}
