package com.mindtreeorchard.professionalConsultancyService.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Skills")
public class Skills {

	@Id
	@Column(name = "skillId")
	private int skillId;
	private String technicalSkill;
	private String category;
	private String description;
	
	
	@ManyToMany(mappedBy ="skills")
	private Set<Employee> employees;
	
	public Skills(int skillId, String technicalSkill, String category, String description) {
		super();
		this.skillId = skillId;
		this.technicalSkill = technicalSkill;
		this.category = category;
		this.description = description;
	}
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getSkillId() {
		return skillId;
	}
	public String getTechnicalSkill() {
		return technicalSkill;
	}
	public String getCategory() {
		return category;
	}
	public String getDescription() {
		return description;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public void setTechnicalSkill(String technicalSkill) {
		this.technicalSkill = technicalSkill;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Skills [skillId=" + skillId + ", technicalSkill=" + technicalSkill + ", category=" + category
				+ ", description=" + description + "]";
	}
}
	

