package com.mindtreeorchard.professionalConsultancyService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mindtreeorchard.professionalConsultancyService.userService.SkillsService;
import com.mindtreeorchard.professionalConsultancyService.entity.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/welcome")
public class SkillController {

	@Autowired
	private SkillsService skillservice;
	
	@PostMapping(value="/Skills")
	public void saveSkill(@RequestBody Skills skill)
	{
		skillservice.addSkill(skill);
	}
	
	@GetMapping(value="/Skills")
	public ResponseEntity<List<Skills>> getAllSkills()
	{
		return skillservice.getAllSkills();
	}
	
	@PutMapping(value="/Skills/{skillID}")
	public ResponseEntity<Skills> updateSkill(@RequestBody Skills skill,@PathVariable int skillID)
	{
		ResponseEntity<Skills> res=skillservice.UpdateSkill(skillID, skill);
		return res;
	}
	
}
