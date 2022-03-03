package com.mindtreeorchard.professionalConsultancyService.userService;

import java.util.*;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.mindtreeorchard.professionalConsultancyService.entity.Skills;

@Service
public interface SkillsService {
	public ResponseEntity<List<Skills>> getAllSkills();
	public void addSkill(Skills skill);
	public ResponseEntity<Skills> UpdateSkill(int id,Skills skill);
}
