package com.jenkins.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jenkins.demo.model.Employee;

@RestController

public class TestController {
	
	@RequestMapping("/")
	public String firstPage() {
		return "Welcome to Application, Running on server";
	}

	private List<Employee> employees = createList();

	@GetMapping(value = "/allemp",produces = "application/json")
	public List<Employee> empPage() {
		return employees;
	}


	@PostMapping(value = "/addemp",produces = "application/json")
	public Employee create(@RequestBody Employee user) {
		employees.add(user);
		System.out.println(employees);
		return user;
	}

	private static List<Employee> createList() {
		List<Employee> tempEmployees = new ArrayList<Employee>();
		Employee emp1 = new Employee();
		emp1.setName("emp1");
		emp1.setDesignation("manager");
		emp1.setEmpId("1");
		emp1.setSalary(3000);

		Employee emp2 = new Employee();
		emp2.setName("emp2");
		emp2.setDesignation("developer");
		emp2.setEmpId("2");
		emp2.setSalary(3000);
		
		Employee emp3 = new Employee();
		emp3.setName("emp3");
		emp3.setDesignation("Intern");
		emp3.setEmpId("3");
		emp3.setSalary(1500);
		
		Employee emp4 = new Employee();
		emp4.setName("emp4");
		emp4.setDesignation("support");
		emp4.setEmpId("4");
		emp4.setSalary(1200);
		
		tempEmployees.add(emp1);
		tempEmployees.add(emp2);
		tempEmployees.add(emp3);
		tempEmployees.add(emp4);
		
		return tempEmployees;
	}
	

}
