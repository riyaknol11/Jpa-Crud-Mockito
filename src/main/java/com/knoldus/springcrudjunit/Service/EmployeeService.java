package com.knoldus.springcrudjunit.Service;

import com.knoldus.springcrudjunit.Dao.EmployeeRepository;
import com.knoldus.springcrudjunit.Model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService{

    public List<Employee> fetchAllEmployees();

    public Employee addEmployee(Employee employee);


    public void deleteEmployeeById(Long empId);

    public Employee updateById(Employee employee, Long id);

    public Employee getEmployeeRecordByName(String name);
}
