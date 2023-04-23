package com.knoldus.springcrudjunit.Dao;

import com.knoldus.springcrudjunit.Model.Employee;
import jakarta.persistence.Column;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findByEmpName(String empName);
}
