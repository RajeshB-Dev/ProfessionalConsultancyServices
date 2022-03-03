package com.mindtreeorchard.professionalConsultancyService.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtreeorchard.professionalConsultancyService.entity.*;
import com.mindtreeorchard.professionalConsultancyService.exception.BusinessException;
import com.mindtreeorchard.professionalConsultancyService.exception.ControllerException;
import com.mindtreeorchard.professionalConsultancyService.userService.EmployeeService;

@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/welcome")
public class EmployeeController {

	@Autowired
	private EmployeeService  employeeService ;
	
	

	@RequestMapping(value="/employee", method = RequestMethod.POST)
	public ResponseEntity<?> saveEmployee(@RequestBody Employee emp)
	{
		try 
		{
		Employee employee= employeeService.addEmployee(emp);
		return new ResponseEntity<Employee>(employee,HttpStatus.CREATED);
		}
		catch(BusinessException e)
		{
			ControllerException ce=new ControllerException(e.getErrorCode(),e.getErrorMessage());
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		catch(Exception e)
		{
			ControllerException ce=new ControllerException("611","something went wrong in controller");
			return new ResponseEntity<ControllerException>(ce,HttpStatus.BAD_REQUEST);
		}
		
	}
	
	@PutMapping("/employees/{empId}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable int empId, @RequestBody Employee employeeDetails) {
		ResponseEntity<Employee> employee=employeeService.updateEmployee(employeeDetails, empId);
		return employee;
	}
	
	
	
	@DeleteMapping("/employees/{empId}")
	public ResponseEntity<Boolean> deleteEmployee(@PathVariable int empId) 
	{
		employeeService.deleteEmployee(empId);
		return ResponseEntity.ok(true);
	}
	
	@GetMapping(value="/employee")
	public ResponseEntity<List<Employee>> getAllEmployees()
	{
		return employeeService.getAllEmployee();
	}

	@RequestMapping(value="/employee/{email}/{password}",method = RequestMethod.GET)
	public ResponseEntity<List<String>> authenticateEmployee(@PathVariable String email,@PathVariable String password )
	{
		
		ResponseEntity<Employee> empobj=null;
		empobj=employeeService.authenticateEmailPassword(email,password);
		String pass=empobj.getBody().getPassword();
		String mail=empobj.getBody().getEmailId();
		List<String> response = new ArrayList<>();
		response.add(mail);
		response.add(pass);
		return ResponseEntity.ok(response);
	}
	
}