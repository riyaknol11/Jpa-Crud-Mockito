package com.knoldus.projectservice.Service;

import com.knoldus.projectservice.Model.Project;

import java.util.List;
import java.util.Optional;

public interface ProjectService {

     List<Project> fetchAllProjects();

     Project addProject(Project project);

     Optional<Project> deleteProjectById(Long empId);

     Project updateById(Project project, Long id);

     Optional<Project> deleteProjectByName(String name);

     Optional<Project> getProjectRecordByName(String emp_name);
}
