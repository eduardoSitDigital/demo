package com.sit.digital.demo.person;

public class Person {
	private String name;
	private String firstName;
	private String secondName;
	private int age;
	private Gender gender;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Person [name=");
		builder.append(name);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", secondName=");
		builder.append(secondName);
		builder.append(", age=");
		builder.append(age);
		builder.append("]");
		return builder.toString();
	}
	

}
