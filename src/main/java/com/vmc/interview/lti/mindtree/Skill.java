package com.interview.lti.mindtree;

public class Skill {

	private final int skillId;
	private final String name;

	public Skill(int skillId, String name) {
		super();
		this.skillId = skillId;
		this.name = name;
	}

	public int getSkillId() {
		return skillId;
	}

	public String getName() {
		return name;
	}

}
