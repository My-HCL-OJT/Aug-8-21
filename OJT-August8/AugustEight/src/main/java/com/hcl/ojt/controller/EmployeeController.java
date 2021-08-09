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

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class EmployeeController {
	@Autowired
	EmployeeService es;

	@GetMapping(value = "/")
	public String showEmployees() {
		log.trace("showEmployees start page of the app");
		return "Welcome /createEmployees to create employees, /getEmployees/id to get employee, /deleteEmployees/id to delete employee";
	}

	@PostMapping(value = "/createEmployees")
	public Employee createEmployee(@RequestBody EmployeeDao dao) {
		log.info("employee created " + dao.getName());
		return es.createEmployee(dao);
	}

	@GetMapping(value = "/getEmployees")
	public List<Employee> getEmployee() {
		log.info("showing all employees");
		return es.getAllEmployees();
	}

	@GetMapping(value = "/getEmployees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		log.info("showing employee with id : " + id);
		return es.getEmployee(id);
	}

	@DeleteMapping(value = "/deleteEmployees/{id}")
	public Employee deleteEmployee(@PathVariable Integer id) {
		log.warn("deleting employee with id : " + id);
		return es.getEmployee(id);
	}

	@PutMapping(value = "/updateEmployees/{id}")
	public Employee updateEmployee(@PathVariable Integer id, @RequestBody EmployeeDao dao) {
		log.warn("updating employee with id : " + id + " and name :" + dao.getName());
		return es.updateEmployee(dao, id);
	}

}
