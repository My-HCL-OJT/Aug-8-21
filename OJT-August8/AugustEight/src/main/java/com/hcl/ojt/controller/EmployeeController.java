package com.hcl.ojt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ojt.entity.Employee;
import com.hcl.ojt.entity.EmployeeDao;
import com.hcl.ojt.service.EmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	EmployeeService es;
	@GetMapping(value = "/")
	public String showEmployees() {
		return "Welcome /createEmployees to create employees, /getEmployees/id to get employee, /deleteEmployees/id to delete employee";
	}
	@PostMapping(value="/createEmployees")
	public Employee createEmployee(@RequestBody EmployeeDao dao) {
		return es.createEmployee(dao);
	}
	@GetMapping(value="/getEmployees")
	public List<Employee> getEmployee() {
		return es.getAllEmployees();
	}
	@GetMapping(value="/getEmployees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return es.getEmployee(id);
	}
	@DeleteMapping(value="/deleteEmployees/{id}")
	public Employee deleteEmployee(@PathVariable Integer id) {
		return es.getEmployee(id);
	}
	@PutMapping(value="/updateEmployees/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDao dao) {
		System.out.println("Controller updating");
		return es.updateEmployee(dao,id);
	}

}
