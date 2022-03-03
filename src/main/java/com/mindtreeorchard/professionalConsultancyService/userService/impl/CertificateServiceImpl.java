package com.mindtreeorchard.professionalConsultancyService.userService.impl;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mindtreeorchard.professionalConsultancyService.entity.Certificates;
import com.mindtreeorchard.professionalConsultancyService.repository.CertificateRepository;
import com.mindtreeorchard.professionalConsultancyService.userService.CertificateService;

@Component
public class CertificateServiceImpl implements CertificateService {

	@Autowired
	private CertificateRepository certificaterepository;
	@Override
	public ResponseEntity<List<Certificates>> getAllCertificates() {
		List<Certificates> certificates=certificaterepository.findAll();
		return ResponseEntity.ok(certificates);

	}

	@Override
	public void addCertificates(Certificates certificate) {
		certificaterepository.save(certificate);
		
	}

	@Override
	public ResponseEntity<Certificates> updateCertificate(int id, Certificates certificate) {
		Optional<Certificates> certify=certificaterepository.findById(id);
		Certificates cert=certify.get();
		cert.setCertificateName(certificate.getCertificateName());
		cert.setCertificateDescription(certificate.getCertificateDescription());
		Certificates updatedCertificate=certificaterepository.save(cert);
		return ResponseEntity.ok(updatedCertificate);
	}

}
