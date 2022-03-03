package com.mindtreeorchard.professionalConsultancyService.entity;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Certificates")
public class Certificates {
	@Id
	private int certificateId;
	private String certificateName;
	private String certificateDescription;
	public Certificates(int certificateId, String certificateName,String certificateDescription) {
		super();
		this.certificateId = certificateId;
		this.certificateName = certificateName;
		this.certificateDescription=certificateDescription;
	}
	@ManyToMany(mappedBy="certificates")
	private Set<Employee> employees;
	public Certificates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getCertificateDescription() {
		return certificateDescription;
	}



	public void setCertificateDescription(String certificateDescription) {
		this.certificateDescription = certificateDescription;
	}


	public int getCertificateId() {
		return certificateId;
	}
	@Override
	public String toString() {
		return "Certificates [certificateId=" + certificateId + ", certificateName=" + certificateName
				+ ", certificateDescription=" + certificateDescription +  "]";
	}

	public String getCertificateName() {
		return certificateName;
	}
	public void setCertificateId(int certificateId) {
		this.certificateId = certificateId;
	}
	public void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}
	
	
}
