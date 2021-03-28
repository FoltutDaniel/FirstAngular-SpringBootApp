package com.zeke.FirstAngularProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeke.FirstAngularProject.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Optional<Employee> findEmployeeById(Long id);

}
