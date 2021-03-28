package com.zeke.FirstAngularProject.service;

import java.util.List;

import java.util.UUID;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeke.FirstAngularProject.exception.UserNotFoundException;
import com.zeke.FirstAngularProject.model.Employee;
import com.zeke.FirstAngularProject.repository.EmployeeRepository;
import com.zeke.*;
@Service
public class EmployeeService {
	
	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}
	
	public Employee addEmployee(Employee employee) {
		
		employee.setEmployeeCode(UUID.randomUUID().toString());
		return employeeRepository.save(employee);
	}
	
	public List<Employee> findAllEmployees(){
		return employeeRepository.findAll();
	}
	
	public Employee updateEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public void deleteEmployee(Long id) {
		employeeRepository.deleteById(id);
	}
	
	public Employee findEmployeeById(Long id) throws UserNotFoundException {
		return employeeRepository.findEmployeeById(id)
				.orElseThrow(( () -> new UserNotFoundException("User by id " + id + " was not found.")));
	}
}
