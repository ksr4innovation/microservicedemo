package com.snkit.eurekaclientgreetservice;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/greet")
public class GreetController {

	List<Employee> employee = new ArrayList();

	private Integer count = new Integer(0);

	@PostConstruct
	public void data() {
		employee.add(new Employee(String.valueOf(1), "ABC", "Hyd", "India"));
		employee.add(new Employee(String.valueOf(2), "BBB", "Bang", "India"));
		employee.add(new Employee(String.valueOf(3), "CCC", "Bang", "India"));
		employee.add(new Employee(String.valueOf(4), "DDD", "Hyd", "India"));
		employee.add(new Employee(String.valueOf(5), "XYZ", "Hyd", "India"));
	}

	@RequestMapping(value = "/getEmployeeGet",  method = RequestMethod.GET)
	public ResponseEntity<EmployeeResponse> getEmployeeGet() {
		EmployeeResponse resp = new EmployeeResponse();
		resp.setCount(count++);
		employee.forEach(emp -> resp.addEmploye(emp));
		return new ResponseEntity(resp, HttpStatus.OK);
	}

	@RequestMapping(value = "/getEmployeeGet2",  method = RequestMethod.GET)
	public ResponseEntity<EmployeeResponse> getEmployeeGet2(@RequestHeader("token") String token) {
		EmployeeResponse resp = new EmployeeResponse();
		resp.setCount(count++);
		employee.forEach(emp -> {
			emp.setCity(emp.getCity()+"  "+token);
			resp.addEmploye(emp);
			});
		return new ResponseEntity(resp, HttpStatus.OK);
	}
}
