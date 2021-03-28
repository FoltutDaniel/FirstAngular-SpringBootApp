package com.zeke.FirstAngularProject.service;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeke.FirstAngularProject.exception.UserNotFoundException;
import com.zeke.FirstAngularProject.model.Employee;

@RestController
@RequestMapping("/employee")
public class EmployeeResource {
	
	private final EmployeeService employeeService;
	
	@Autowired
	public EmployeeResource(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	@GetMapping("/list")
	public List<Employee> getAllEmployees(){
		return employeeService.findAllEmployees();
	}
	
	@GetMapping("/list/{id}")
	public Employee findEmployee(@PathVariable("id") Long id) throws UserNotFoundException{
		
		Employee employee = employeeService.findEmployeeById(id);
		
		return employee;
	}
	
	@PostMapping("/add")
	public Employee addEmployee(@RequestBody Employee employee) {
		Employee employee2 = employeeService.addEmployee(employee);
		return employee2;
	}
	
	@PutMapping("/update")
	public Employee updateEmployee(@RequestBody Employee employee) {
		Employee employee2 = employeeService.addEmployee(employee);
		return employee2;
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable("id") Long id) {
		employeeService.deleteEmployee(id);
	}
}
