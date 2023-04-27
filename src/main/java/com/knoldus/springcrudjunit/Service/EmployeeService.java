package com.knoldus.springcrudjunit.Service;

import com.knoldus.springcrudjunit.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService{

     List<Employee> fetchAllEmployees();

     Employee addEmployee(Employee employee);


     Optional<Employee> deleteEmployeeById(Long empId);

     Employee updateById(Employee employee, Long id);

     Optional<Employee> getEmployeeRecordByName(String name);

     Optional<Employee> deleteEmployeeByName(String name);
}
