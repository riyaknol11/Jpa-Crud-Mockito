package com.knoldus.springcrudjunit;

import com.knoldus.springcrudjunit.Dao.EmployeeRepository;
import com.knoldus.springcrudjunit.Model.Address;
import com.knoldus.springcrudjunit.Model.Employee;
import com.knoldus.springcrudjunit.Service.EmployeeServiceImpl;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpringCrudJunitApplicationTests {

@Mock
	EmployeeRepository employeeRepository;

@InjectMocks
	private EmployeeServiceImpl employeeService;

Employee employee;

@BeforeEach
	public void setUp(){
	MockitoAnnotations.initMocks(this);
	employee = new Employee(3,
			"Priya","Priya@test.com", new Address("USA", "Manhattan", 555));
}

@Test
	void testAddEmployee(){
	when(employeeRepository.save(employee))
			.thenReturn(employee);
	Employee saveRecords = employeeService.addEmployee(employee);
	Assert.assertEquals("It is equal", employee, saveRecords);

}

@Test
	void testFetchAllEmployees(){
	List<Employee> employeesList = new ArrayList<>();
	employeesList.add(employee);
	employeesList.add(new Employee(12, "Harvey", "Harvey@Jp",
			new Address("Manhattan","New York",144)));
	employeesList.add(new Employee(20, "Jersey", "Jersey@Jp",
			new Address("UK","UK",441)));

	when(employeeRepository.findAll())
			.thenReturn(employeesList);
	List<Employee> testEmployeeList = employeeService.fetchAllEmployees();
	Assert.assertEquals("Same list returned!", employeesList, testEmployeeList);

}

@Test
	void testUpdateById(){
	//Creating an employee object to update
	Employee toBeUpdated = (new Employee(12, "Harvey", "Harvey@Jp",
			new Address("Manhattan","New York",144)));

	//Creating an updatedEmployeeObject
	Employee updatedEmployee = (new Employee(12, "Donna", "Donna@Jp",
			new Address("Manhattan","New York",244)));


	//The thenReturn method is then called on this mock object to return an optional of the
	// toBeUpdated object when the findById method is called with any long parameter.
	when(employeeRepository.findById(anyLong()))
			.thenReturn(Optional.of(toBeUpdated));

	Employee employeeResponseEntity = employeeService.updateById(updatedEmployee, 12L );

//	verify(employeeRepository).save(updatedEmployee);

	//Finally, the ArgumentCaptor is used to capture the argument that was passed to the save method of the employeeRepository mock
	ArgumentCaptor<Employee> argument = ArgumentCaptor.forClass(Employee.class);
	verify(employeeRepository).save(argument.capture());
	Employee updatedEmployeeCapture = argument.getValue();
	Assert.assertEquals("Same employee updated!", updatedEmployee, updatedEmployeeCapture);
}

//@Test
//	public void testDeleteMethod(){
//	Employee toBeDeleted = (new Employee(12, "Harvey", "Harvey@Jp",
//			new Address("Manhattan","New York",144)));
//
//	when(employeeRepository.findById(anyLong()))
//			.thenReturn(Optional.of(toBeDeleted));
//
//	Optional<Employee> deletedEmployeeService = employeeService.deleteEmployeeById(1L);
//
//	ArgumentCaptor<Employee> argument = ArgumentCaptor.forClass(Employee.class);
//	verify(employeeRepository).save(argument.capture());
//	Employee deletedEmployee = argument.getValue();
//	Assert.assertEquals("Deleted the same employee!", toBeDeleted,deletedEmployee);
//
//}


}
