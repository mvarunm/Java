package com.employees.demo.model;

public abstract class Employee {

	private int id;
	private String name;
	private String address;
	private float vacationDays = 0;
	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Employee(int id, String name, String address, float vacationDays, String type) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.vacationDays = vacationDays;
		this.type = type;
	}

	public float getVacationDays() {
		return vacationDays;
	}

	public float getWorkDays() {
		return workDays;
	}

	private int workDays = 0;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void Work(int days) {
		if ((this.workDays + days) >= 0 && (this.workDays + days) <= 260) {
			this.workDays = this.workDays + days;
		}
	}

	public void TakeVacation(float days) {
		if (((this.vacationDays - days) >= 0) && days <= this.vacationDays) {
			this.vacationDays = this.vacationDays - days;
		}
	}

}
