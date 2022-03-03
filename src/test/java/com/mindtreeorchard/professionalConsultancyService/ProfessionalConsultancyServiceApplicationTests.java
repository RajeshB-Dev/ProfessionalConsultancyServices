package com.mindtreeorchard.professionalConsultancyService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.mindtreeorchard.professionalConsultancyService.userService.impl.EmployeeServiceImpl;
import com.mindtreeorchard.professionalConsultancyService.userService.impl.SkillServiceImpl;
import com.mindtreeorchard.professionalConsultancyService.entity.Skills;
import com.mindtreeorchard.professionalConsultancyService.repository.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfessionalConsultancyServiceApplicationTests {

	@Autowired
	private SkillServiceImpl skillservice;
	
	@MockBean
	private SkillRepository  skillrepo ;
		
	@Test
	public void getSkillsTest()
	{
		when(skillrepo.findAll()).thenReturn(Stream
				.of(new Skills()).
				collect(Collectors.toList()));
		ResponseEntity<List<Skills>> skills=skillservice.getAllSkills();
		assertEquals(1,skills.getBody().size());	
	}
	
	
}
	