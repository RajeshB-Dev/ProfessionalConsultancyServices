package com.mindtreeorchard.professionalConsultancyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtreeorchard.professionalConsultancyService.userService.CertificateService;

import com.mindtreeorchard.professionalConsultancyService.entity.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/welcome")
public class CertificateController {
	
	@Autowired
	private CertificateService certificateService;
	
	@RequestMapping(value="/certificate",method = RequestMethod.POST)
	public void saveCertificate(@RequestBody Certificates certificate)
	{
		certificateService.addCertificates(certificate);
	}
	@RequestMapping(value="/certificate",method = RequestMethod.GET)
	public ResponseEntity<List<Certificates>> getAllCertificates()
	{
		return certificateService.getAllCertificates();
	}
	@PutMapping(value="/certificate/{certificateId}")
	 public ResponseEntity<Certificates> updateCertificates(@RequestBody Certificates certificates,@PathVariable int certificateId)
	 {
		 return certificateService.updateCertificate(certificateId, certificates);
	 }
}
