package com.snkit.eurekaclientgreetservice;

import java.util.ArrayList;
import java.util.List;

public class EmployeeResponse  {

	public List<Employee> employee;
	
	private Integer count;

	public EmployeeResponse() {

	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public EmployeeResponse addEmploye(Employee emp) {
		if (employee == null) {
			employee = new ArrayList<>();
		}
		employee.add(emp);
		return this;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

}
