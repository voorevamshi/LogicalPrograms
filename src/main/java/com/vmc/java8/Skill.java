package com.vmc.java8;

public class Skill {

	private Integer skillId;
	private String skillName;

	public Skill(String skillName) {
		super();
		this.skillName = skillName;
	}

	public Skill(Integer skillId, String skillName) {
		super();
		this.skillId = skillId;
		this.skillName = skillName;
	}

	public Integer getSkillId() {
		return skillId;
	}

	public void setSkillId(Integer skillId) {
		this.skillId = skillId;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	@Override
	public String toString() {
		return " [skillName=" + skillName + "]";
	}

}
