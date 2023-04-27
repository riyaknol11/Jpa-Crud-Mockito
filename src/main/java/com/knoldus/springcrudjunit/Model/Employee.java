package com.knoldus.springcrudjunit.Model;

import jakarta.persistence.*;
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

    //This one to one column will create the foreign key column in the Employee class and the default name of it will be
    //reference entity class_primary-key column name
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name= "fk_house_no")
    @Embedded
    public Address address;

}
