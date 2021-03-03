package com.sit.digital.demo.person;

public enum Gender {

	FEMALE("F"),MALE("M"),OTHER("O");
	
	private String gender;
	
	private Gender(String gender) {
		this.gender = gender;
	}
	
	
	public String getGender() {
		return gender;
	}

	public static Gender valuOfLabel(String data) {
		
		for(Gender gender: Gender.values()) {
			if(gender.getGender().equals(data)) {
				return gender;
			}
		}
		
		return OTHER;
	}
}
