package com.knoldus.projectservice.Service;

import com.knoldus.projectservice.Dao.ProjectRepository;
import com.knoldus.projectservice.Model.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudioServiceImpl implements ProjectService {

    @Autowired
    ProjectRepository projectRepository;


    @Override
    public List<Project> fetchAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public Project addProject(Project project) {
        return projectRepository.save(project);
    }


@Override
    public Optional<Project> deleteProjectById(Long projectId) {
        Optional<Project> projectOptional = projectRepository.findById(projectId);
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            projectRepository.delete(project);
            System.out.println("Project with ID " + projectId + " has been deleted.");
            return Optional.of(project);
        }
        // If the project was not found, return an empty Optional
        return Optional.empty();
    }

    @Override
    public Optional<Project> deleteProjectByName(String name) {
        Optional<Project> deleteByNameOptional = projectRepository.findByProjectName(name);
        if(deleteByNameOptional.isPresent()){
         Project project = deleteByNameOptional.get();
         projectRepository.delete(project);
            return Optional.ofNullable(project);
        }
        return Optional.empty();
    }



    @Override
    public Project updateById(Project project1, Long id) {
        Optional<Project> projectOptional = projectRepository.findById(id);
        Project updateProject = null;
        if (projectOptional.isPresent()) {
            Project project = projectOptional.get();
            project.setProjectName(project1.getProjectName());
            project.setProject_email(project1.getProject_email());
            project.setTeamMembers(project1.getTeamMembers());
            updateProject = projectRepository.save(project);
        }
        System.out.println("Record updated!" + updateProject);
        return updateProject;
    }


    @Override
    public Optional<Project> getProjectRecordByName(String emp_name) {
        Optional<Project> projectRecordByName = projectRepository.findByProjectName(emp_name);
        return projectRecordByName;
    }



}
