package com.hcl.ojt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hcl.ojt.entity.Employee;

/* Create a get mapping to fetch employees whose salary is greater than 20k- (Custom @Query) 
 * Create a get mapping to fetch employees whose name starts with A - (Custom @Query-like) 
 * Create a get mapping to fetch all employees whose designation is manager (findByDesignation) 
 * Create a get mapping to fetch all employees with ids (1,2,3,4)*/
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	@Query(value = "Select * from Employee where salary > :salary", nativeQuery = true)
	List<Employee> findBySalaryGT(@Param("salary") double salary);

	//@Query(value = "Select * from Employee where designation = :designation", nativeQuery = true)
	List<Employee> findByDesignation(@Param("designation") String designation);

	@Query(value = "Select * from Employee where id in (:ids)", nativeQuery = true)
	List<Employee> findByIds(@Param("ids") List<Integer> ids);

	@Query(value = "Select * from Employee where name LIKE '" + "?1" +"%'", nativeQuery = true)
	List<Employee> findByNames(String first);
}
