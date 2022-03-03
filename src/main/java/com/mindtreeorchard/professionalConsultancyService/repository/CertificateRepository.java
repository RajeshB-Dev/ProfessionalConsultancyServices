package com.mindtreeorchard.professionalConsultancyService.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtreeorchard.professionalConsultancyService.entity.*;
@Repository
@Transactional
public interface CertificateRepository extends JpaRepository<Certificates,Integer> {

}
