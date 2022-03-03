package com.mindtreeorchard.professionalConsultancyService.entity;

import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	private int empId;
	private String empName;
	private String emailId;
	private String password;
	private String date;
	private String empBio;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="employee_certificate",joinColumns=@JoinColumn(name="employee_id",
	referencedColumnName ="empId"),inverseJoinColumns = @JoinColumn(name="certificate_id",referencedColumnName ="certificateId" ))
	private Set<Certificates> certificates;
    
   
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="employee_skill",joinColumns=@JoinColumn(name="employee_id",
	referencedColumnName ="empId"),inverseJoinColumns = @JoinColumn(name="skill_id",referencedColumnName ="skillId" ))
    private Set<Skills> skills;


	public Employee(int empId, String empName, String emailId, String password, String date, String empBio) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.emailId = emailId;
		this.password = password;
		this.date = date;
		this.empBio = empBio;
		
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getEmpId() {
		return empId;
	}


	public String getEmpName() {
		return empName;
	}


	public String getEmailId() {
		return emailId;
	}


	public String getPassword() {
		return password;
	}


	public String getDate() {
		return date;
	}


	public String getEmpBio() {
		return empBio;
	}


	public Set<Certificates> getCertificates() {
		return certificates;
	}


	public Set<Skills> getSkills() {
		return skills;
	}


	public void setEmpId(int empId) {
		this.empId = empId;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setEmpBio(String empBio) {
		this.empBio = empBio;
	}


	public void setCertificates(Set<Certificates> certificates) {
		this.certificates = certificates;
	}


	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", emailId=" + emailId + ", password=" + password
				+ ", date=" + date + ", empBio=" + empBio + ", certificates=" + certificates + ", skills=" + skills
				+ "]";
	}
    
	 
}
