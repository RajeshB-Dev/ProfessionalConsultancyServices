package com.mindtreeorchard.professionalConsultancyService.userService.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mindtreeorchard.professionalConsultancyService.entity.Employee;
import com.mindtreeorchard.professionalConsultancyService.exception.BusinessException;
import com.mindtreeorchard.professionalConsultancyService.repository.EmployeeRepository;
import com.mindtreeorchard.professionalConsultancyService.userService.EmployeeService;
@Component
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository employeerepository;

	@Override
	public Employee addEmployee(Employee emp) {
		try
		{
		if(emp.getEmpName().isEmpty() || emp.getEmailId().isEmpty() )
		{
			throw new BusinessException("601","Details must not be blank,Please enter valid name and mailId");
			
		}
		employeerepository.save(emp);
		return emp;
		}
		catch(IllegalArgumentException e)
		{
			throw new BusinessException("602","given employee is null"+e.getMessage());
		}
		catch(Exception e)
		{
			throw new BusinessException("603","some thing went wrong in service layer"+e.getMessage());
		}
	}	
	@Override
	public ResponseEntity<List<Employee>> getAllEmployee() {
		try
		{
		List<Employee> emp=new ArrayList<Employee>();
		emp=employeerepository.findAll();
		if(emp.isEmpty())
		{
			throw new BusinessException("601","Sorry the list is completely Empty,No tables in database");
		}
		return ResponseEntity.ok(emp);
		}
		catch(Exception e)
		{
			throw new BusinessException("606","Something went wrong in the service layer update it"+e.getMessage());
		}
	}



	@Override
	public ResponseEntity<Employee> updateEmployee(Employee employee, int id) {
		Optional<Employee> emp = employeerepository.findById(id);
		Employee emp1 = emp.get();
		emp1.setEmpName(employee.getEmpName());
		emp1.setEmailId(employee.getEmailId());
		emp1.setPassword(employee.getPassword());
		emp1.setDate(employee.getDate());
		emp1.setEmpBio(employee.getEmpBio());
		emp1.setCertificates(employee.getCertificates());
		emp1.setSkills(employee.getSkills());
		Employee updatedEmployee=employeerepository.save(emp1);
		return ResponseEntity.ok(updatedEmployee);
		
	}

	@Override
	public ResponseEntity<Map<String, Boolean>> deleteEmployee(int empId) {
		Optional<Employee> emp = employeerepository.findById(empId);
		Employee employee = emp.get();
		employeerepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}

	@Override
	public ResponseEntity<Employee> authenticateEmailPassword(String email, String password) {
		List<Employee> emp=new ArrayList<Employee>();
		emp=employeerepository.findAll();
		int id=0;
		for(int i=0;i<emp.size();i++)
		{
			if(emp.get(i).getEmailId().equalsIgnoreCase(email) && emp.get(i).getPassword().equals(password))
			{
				id=emp.get(i).getEmpId();
			}
		}
		Optional<Employee> search = employeerepository.findById(id);
		Employee employee = search.get();
		return ResponseEntity.ok(employee);
	}




}
