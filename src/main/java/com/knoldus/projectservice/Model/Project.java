package com.knoldus.projectservice.Model;

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
public class Project {

@Id
    private int project_id;
    @Column(name = "project_name")
    private String projectName;
    private String project_email;

    //This one to one column will create the foreign key column in the Employee class and the default name of it will be
    //reference entity class_primary-key column name
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name= "fk_house_no")
    @Embedded
    public TeamMembers teamMembers;

}
