package com.hcl.ojt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.ojt.entity.Employee;
import com.hcl.ojt.entity.EmployeeDao;
import com.hcl.ojt.exception.BusinessLogicException;
import com.hcl.ojt.response.ResponseWrapper;
import com.hcl.ojt.service.EmployeeService;

import lombok.extern.slf4j.Slf4j;

/* *Create a get mapping to fetch employees whose salary is greater than 20k- (Custom @Query) 
 * Create a get mapping to fetch employees whose name starts with A - (Custom @Query-like) 
 * Create a get mapping to fetch all employees whose designation is manager (findByDesignation) 
 * Create a get mapping to fetch all employees with ids (1,2,3,4) 
 * Check if employee salary is greater than 5k, if not throw a custom BusinessLogicException and handle it with RestControllerAdvice */
@RestController
@Slf4j
@RequestMapping("/employees")
public class EmployeeController {
	@Autowired
	EmployeeService es;

	@GetMapping
	public ResponseEntity<ResponseWrapper<String>> showEmployees() {
		log.trace("showEmployees start page of the app");
		return ResponseEntity.ok(new ResponseWrapper<>(false, HttpStatus.OK,
				"Welcome /createEmployees to create employees, /getEmployees/id to get employee, /deleteEmployees/id to delete employee"));
	}

	/*
	 * Check if employee salary is greater than 5k, if not throw a custom
	 * BusinessLogicException and handle it with RestControllerAdvice
	 */
	@PostMapping
	public ResponseEntity<ResponseWrapper<Employee>> createEmployee(@RequestBody EmployeeDao dao)
			throws BusinessLogicException {
		log.info("employee created " + dao.getName());
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.CREATED, es.createEmployee(dao)),
				HttpStatus.CREATED);
	}

	@PostMapping(value = "/all")
	public ResponseEntity<ResponseWrapper<List<Employee>>> createAllEmployee(@RequestBody List<EmployeeDao> dao)
			throws BusinessLogicException {
		log.info("list of employees created ");
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.CREATED, es.createAllEmployee(dao)),
				HttpStatus.CREATED);
	}

	@GetMapping(value = "/empAll")
	public ResponseEntity<ResponseWrapper<List<Employee>>> getEmployee() {
		log.info("showing all employees");
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.OK, es.getAllEmployees()), HttpStatus.OK);
	}

	@GetMapping(value = "/employee/{id}")
	public ResponseEntity<ResponseWrapper<Employee>> getEmployee(@PathVariable Integer id) {
		log.info("showing employee with id : " + id);
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.OK, es.getEmployee(id)), HttpStatus.OK);
	}

	@DeleteMapping(value = "/employee/{id}")
	public ResponseEntity<ResponseWrapper<Employee>> deleteEmployee(@PathVariable Integer id) {
		log.warn("deleting employee with id : " + id);
		es.deleteEmployee(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@PutMapping(value = "/employee/{id}")
	public ResponseEntity<ResponseWrapper<Employee>> updateEmployee(@PathVariable Integer id,
			@RequestBody EmployeeDao dao) {
		log.warn("updating employee with id : " + id + " and name :" + dao.getName());
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.OK, es.updateEmployee(dao, id)),
				HttpStatus.OK);
	}

	// Create a get mapping to fetch employees whose salary is greater than 20k-
	// (Custom @Query)
	@GetMapping(value = "/employee/salary/{salary}")
	public ResponseEntity<ResponseWrapper<List<Employee>>> findSalaryGT(@PathVariable Double salary) {
		log.warn("getting salary higher than " + salary);
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.OK, es.findBySalaryGT(salary)),
				HttpStatus.OK);
	}

	// Create a get mapping to fetch all employees whose designation is manager (findByDesignation)
	@GetMapping(value = "/employee/designation/{designation}")
	public ResponseEntity<ResponseWrapper<List<Employee>>> findByDesignation(@PathVariable String designation) {
		log.warn("getting employee whose designation is " + designation);
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.OK, es.findByDesignation(designation)),
				HttpStatus.OK);
	}

	// Create a get mapping to fetch all employees with ids (1,2,3,4)
	@GetMapping(value = "/employee/id")
	public ResponseEntity<ResponseWrapper<List<Employee>>> findById(@RequestParam(name="ids") List<Integer> ids) {
		System.out.println(ids);
		log.warn("getting employee whose id is " + ids);
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.OK, es.findByIds(ids)), HttpStatus.OK);
	}
	// Create a get mapping to fetch employees whose name starts with A - (Custom @Query-like)
	@GetMapping(value="/employee/name/{start}")
	public ResponseEntity<ResponseWrapper<List<Employee>>> findByName(@PathVariable String start) {
		log.warn("getting employee whose name starts with " + start);
		return new ResponseEntity<>(new ResponseWrapper<>(false, HttpStatus.OK, es.findByName(start)), HttpStatus.OK);
	} 
}
