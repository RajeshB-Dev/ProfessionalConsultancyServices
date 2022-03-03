package com.mindtreeorchard.professionalConsultancyService.userService;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.mindtreeorchard.professionalConsultancyService.entity.Employee;

@Service
public interface EmployeeService {
	public ResponseEntity<List<Employee>> getAllEmployee();
	public Employee addEmployee(Employee emp);
	public ResponseEntity<Employee> updateEmployee(Employee employee,int id);
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(int empId);
	public ResponseEntity<Employee> authenticateEmailPassword(String email, String password);
}
