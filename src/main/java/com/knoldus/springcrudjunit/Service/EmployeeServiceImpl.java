package com.knoldus.springcrudjunit.Service;

import com.knoldus.springcrudjunit.Dao.EmployeeRepository;
import com.knoldus.springcrudjunit.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }


@Override
    public Optional<Employee> deleteEmployeeById(Long empId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(empId);
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employeeRepository.delete(employee);
            // Additional code to handle the successful deletion, for example:
            System.out.println("Employee with ID " + empId + " has been deleted.");
            return Optional.of(employee);
        }
        // If the employee was not found, return an empty Optional
        return Optional.empty();
    }



    @Override
    public Employee updateById(Employee employee1, Long id) {
        Optional<Employee> employeeOptional = employeeRepository.findById(id);
        Employee updateEmployee = null;
        if (employeeOptional.isPresent()) {
            Employee employee = employeeOptional.get();
            employee.setEmpName(employee1.getEmpName());
            employee.setEmp_email(employee1.getEmp_email());
            employee.setAddress(employee1.getAddress());
            updateEmployee = employeeRepository.save(employee);
        }

        return updateEmployee;
    }

    @Override
    public Employee getEmployeeRecordByName(String emp_name) {
        return employeeRepository.findByEmpName(emp_name);
    }

}
