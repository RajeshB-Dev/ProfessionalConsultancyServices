package com.mindtreeorchard.professionalConsultancyService.userService.impl;

import java.util.*;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.mindtreeorchard.professionalConsultancyService.entity.Skills;
import com.mindtreeorchard.professionalConsultancyService.repository.SkillRepository;
import com.mindtreeorchard.professionalConsultancyService.userService.SkillsService;

import net.bytebuddy.dynamic.DynamicType.Builder.FieldDefinition.Optional;

@Component
public class SkillServiceImpl implements SkillsService {

	@Autowired
	private SkillRepository skillrepository;

	@Override
	public ResponseEntity<List<Skills>> getAllSkills() {
		List<Skills> skillset= skillrepository.findAll();
		System.out.println("Getting data from :"+skillset);
		return ResponseEntity.ok(skillset);
	}

	@Override
	public void addSkill(Skills skill) {
		skillrepository.save(skill);
		
		
	}

	@Override
	public ResponseEntity<Skills> UpdateSkill(int id, Skills skill) {
		java.util.Optional<Skills> skills=skillrepository.findById(id);
		Skills skillres=skills.get();
		skillres.setTechnicalSkill(skill.getTechnicalSkill());
		skillres.setDescription(skill.getDescription());
		skillres.setDescription(skill.getDescription());
		Skills updatedSkill=skillrepository.save(skillres);
		return ResponseEntity.ok(updatedSkill);
	}

}
