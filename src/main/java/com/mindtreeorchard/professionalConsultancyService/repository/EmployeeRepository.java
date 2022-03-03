package com.mindtreeorchard.professionalConsultancyService.repository;
import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.mindtreeorchard.professionalConsultancyService.entity.*;
@Repository
@Transactional
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {


}