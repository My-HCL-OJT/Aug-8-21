package com.hcl.ojt;
/*
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;

import com.hcl.ojt.entity.Employee;
import com.hcl.ojt.entity.EmployeeDao;
import com.hcl.ojt.repository.EmployeeRepository;
import com.hcl.ojt.service.EmployeeService;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@SpringBootTest
@AutoConfigureMockMvc
class EmployeeServiceTest {

	@MockBean
	EmployeeRepository empRepo;
	@InjectMocks
	EmployeeService empService;
	
	//createEmployee()
	@Test
	@DisplayName("Create Employee Test")
	public void createEmployeeTest() {
		ArrayList<Employee> arr = new ArrayList<>();
		arr.add(new Employee(1, "Sahil Yadav", 100.0));
		when(empRepo.findAll()).thenReturn(arr);
		List<Employee> list = empService.getAllEmployees();
		assertEquals(list.size(), 1);
		assertTrue(list.get(0).getName().equals("Sahil Yadav"));
	}
	
	//getEmployee(id)
	@Test
	@DisplayName("Get Employee By Id")
	public void getEmployeeById() {
		Employee emp = new Employee(1, "Sahil Yadav", 100.0);
		Mockito.when(empRepo.findById(1)).thenReturn(Optional.of(emp));
		Employee temp = empService.getEmployee(1);
		assertEquals(temp, new Employee(1, "Sahil Yadav", 100.0));
		assertTrue(temp.getName().equals("Sahil Yadav"));
	}
	//deleteEmployee(id)
	@Test
	@DisplayName("Delete Employee By Id")
	public void deleteEmployeeById() {
		Employee emp = new Employee(1, "Sahil Yadav", 100.0);
		empRepo.save(emp);
		when(empRepo.findById(1)).thenReturn(Optional.of(emp));
		empService.deleteEmployee(emp.getId());
		verify(empRepo).deleteById(emp.getId());
			
	}
	//getAllEmployees()
	@Test
	@DisplayName("Create Employee Test")
	public void getAllEmployeesTest() {
		ArrayList<Employee> arr = new ArrayList<>();
		arr.add(new Employee(1, "Sahil Yadav", 100.0));
		arr.add(new Employee(2, "John Doe", 200.0));
		when(empRepo.findAll()).thenReturn(arr);
		List<Employee> list = empService.getAllEmployees();
		assertEquals(list.size(), 2);
		assertTrue(list.get(0).getName().equals("Sahil Yadav"));
		assertTrue(list.get(1).getName().equals("John Doe"));
	}

	
	  @Test public void should_throw_exception_when_emp_doesnt_exsist() { Employee
	  emp = new Employee(1, "Sahil Yadav", 100.0); empRepo.save(emp);
	  when(empRepo.findById(1)).thenReturn(Optional.of(emp));
	  empService.deleteEmployee(emp.getId());
	  verify(empRepo).deleteById(emp.getId()); }
	
	//updateEmployee(dao,id)
	@Test
	@DisplayName("Update Employee Test")
	public void updateEmployeeTest() {
		Employee emp = new Employee(1, "Sahil Yadav", 100.0);
		when(empRepo.findById(emp.getId())).thenReturn(Optional.of(emp));
		EmployeeDao dao = new EmployeeDao("Sahil Yadav", 200.0);
		empService.updateEmployee(dao,emp.getId());
		verify(empService).createEmployee(dao);
		verify(empRepo).findById(emp.getId());
		
		
	}

}
*/