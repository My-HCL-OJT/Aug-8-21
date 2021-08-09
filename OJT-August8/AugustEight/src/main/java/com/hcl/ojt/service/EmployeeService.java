package com.hcl.ojt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ojt.entity.Employee;
import com.hcl.ojt.entity.EmployeeDao;
import com.hcl.ojt.repository.EmployeeRepository;
/*Create 
 * Read getEmployee
 * Update 
 * Delete deleteEmployee*/
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository er;
	public Employee createEmployee(EmployeeDao dao) {
		Employee em = new Employee();
		em.setName(dao.getName());
		em.setSalary(dao.getSalary());
		return er.save(em);
	}
	public Employee getEmployee(Integer id) {
		return er.findById(id).orElse(null);
	}
	public void deleteEmployee(Integer id) {
		er.deleteById(id);
	}
	public List<Employee> getAllEmployees() {
		return er.findAll();
	}
	public Employee updateEmployee(EmployeeDao dao, Integer id) {
		Employee emp = er.findById(id).orElse(null);
		System.out.println("Updating");
		emp.setName(dao.getName());
		emp.setSalary(dao.getSalary());
		er.save(emp);
		return emp;
	}
	
}
