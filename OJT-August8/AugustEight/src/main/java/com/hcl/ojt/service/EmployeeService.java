package com.hcl.ojt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.ojt.entity.Employee;
import com.hcl.ojt.entity.EmployeeDao;
import com.hcl.ojt.exception.BusinessLogicException;
import com.hcl.ojt.repository.EmployeeRepository;

/*Create createEmployee 
 * Read getEmployee
 * Update updateEmployee
 * Delete deleteEmployee*/
@Service
public class EmployeeService {
	@Autowired
	EmployeeRepository er;

	/*
	 * Check if employee salary is greater than 5k, if not throw a custom
	 * BusinessLogicException and handle it with RestControllerAdvice
	 */
	public Employee createEmployee(EmployeeDao dao) throws BusinessLogicException {
		if (dao.getSalary() < 5_000) {
			throw new BusinessLogicException("Salary is below 5K");
		} else {
			Employee em = new Employee();
			em.setName(dao.getName());
			em.setSalary(dao.getSalary());
			em.setDesignation(dao.getDesignation());
			return er.save(em);
		}

	}

	public List<Employee> createAllEmployee(List<EmployeeDao> dao) throws BusinessLogicException {
		dao.stream().forEach(i -> {
			try {
				if (i.getSalary() < 5_000) {
					throw new BusinessLogicException("Salary is below 5k");
				}
				Employee em = new Employee();
				em.setName(i.getName());
				em.setSalary(i.getSalary());
				em.setDesignation(i.getDesignation());
				er.save(em);
			}
			catch (BusinessLogicException ex){
				System.out.println(ex);
			}
		});
		List<Employee> temp = er.findAll();
		return temp;

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
		emp.setName(dao.getName());
		emp.setSalary(dao.getSalary());
		er.save(emp);
		return emp;
	}

	public List<Employee> findBySalaryGT(double salary) {
		return er.findBySalaryGT(salary);
	}

	public List<Employee> findByDesignation(String designation) {
		return er.findByDesignation(designation);
	}

	public List<Employee> findByIds(List<Integer> temp) {
		return er.findByIds(temp);
	}
	public List<Employee> findByName(String start){
		System.out.println(start);
		return er.findByNames(start);
	}
}
