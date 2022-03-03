package com.mindtreeorchard.professionalConsultancyService.userService;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.mindtreeorchard.professionalConsultancyService.entity.Certificates;

@Service
public interface CertificateService {
	public ResponseEntity<List<Certificates>> getAllCertificates();
	public void addCertificates(Certificates certificate);
	public ResponseEntity<Certificates> updateCertificate(int id,Certificates certificate);
}
