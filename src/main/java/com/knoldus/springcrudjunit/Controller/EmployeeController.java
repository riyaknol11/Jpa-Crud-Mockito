package com.knoldus.springcrudjunit.Controller;

import com.knoldus.springcrudjunit.Model.Employee;
import com.knoldus.springcrudjunit.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping("/addEmployee")
    public Employee addEmployeeInData(@RequestBody  Employee employee){
       return employeeService.addEmployee(employee);
    }


    @GetMapping("/getEmployee")
    public List<Employee> getAllEmployee(){
        return employeeService.fetchAllEmployees();
    }

    @PutMapping("updateEmployee/{id}")
    public Employee updateEmployeeById(@RequestBody Employee employee, @PathVariable Long id){
        return employeeService.updateById(employee, id);
    }

    @DeleteMapping("deleteEmployee/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployeeById(id);
    }

    @GetMapping("findByName")
    //http://localhost:8080/findByName?name=Mike Doe ---> Mapping in postman
    public Employee getEmployeeByName(@RequestParam("name") String emp_name){
        return employeeService.getEmployeeRecordByName(emp_name);
    }


}
