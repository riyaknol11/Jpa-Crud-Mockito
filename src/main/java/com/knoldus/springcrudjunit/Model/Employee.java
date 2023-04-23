package com.knoldus.springcrudjunit.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.transaction.Transactional;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Transactional
@Builder
@Entity
public class Employee {

@Id
    private int emp_id;
    @Column(name = "emp_name")
    private String empName;
    private String emp_email;

    @Embedded
    private Address address;

}
