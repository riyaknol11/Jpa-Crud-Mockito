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
    public Optional<Employee> deleteEmployeeByName(String name) {
//        Optional<Employee> deleteByName = Optional.ofNullable(employeeRepository.findByEmpName(name));
        Optional<Employee> deleteByNameOptional = employeeRepository.findByEmpName(name);
        if(deleteByNameOptional.isPresent()){
         Employee employee = deleteByNameOptional.get();
         employeeRepository.delete(employee);
            return Optional.ofNullable(employee);
        }
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
        System.out.println("Record updated!" + updateEmployee);
        return updateEmployee;
    }

//@Override
//public Employee updateById(Employee employeeupdated, Long id) {
//    Optional<Employee> employeeOptional = employeeRepository.findById(id);
//    if (employeeOptional.isPresent()) {
//        Employee employee = employeeOptional.get();
//        employee.setEmpName(employeeupdated.getEmpName());
//        employee.setEmp_email(employeeupdated.getEmp_email());
//        employee.setAddress(employeeupdated.getAddress());
//        employeeRepository.save(employee);
//    }
//
//    return employeeupdated;
//}

    @Override
    public Optional<Employee> getEmployeeRecordByName(String emp_name) {
        Optional<Employee> employeeRecordByName = employeeRepository.findByEmpName(emp_name);
        return employeeRecordByName;
    }



}
