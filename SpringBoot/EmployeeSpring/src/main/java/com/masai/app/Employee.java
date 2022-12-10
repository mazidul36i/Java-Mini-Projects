package com.masai.app;

public class Employee {

	private Integer empId;
	private String name;
	private String address;
	private Integer salary;
	
	public Employee(Integer empId, String name, String address, Integer salary) {
		super();
		this.empId = empId;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public Employee() {
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
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

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	
}
