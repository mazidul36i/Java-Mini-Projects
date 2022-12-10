package com.masai.app.bean;

public class Student {

	private Integer roll;
	private String name;
	private String address;
	
	public Student() {}

	public Student(Integer roll, String name, String address) {
		super();
		this.roll = roll;
		this.name = name;
		this.address = address;
	}

	public Integer getRoll() {
		return roll;
	}

	public void setRoll(Integer roll) {
		this.roll = roll;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
}
