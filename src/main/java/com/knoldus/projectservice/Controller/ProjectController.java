package com.knoldus.projectservice.Controller;

import com.knoldus.projectservice.Model.Project;
import com.knoldus.projectservice.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @PostMapping("/addProject")
    public Project addProjectInData(@RequestBody Project project){
       return projectService.addProject(project);
    }


    @GetMapping("/getProject")
    public List<Project> getAllProject(){
        return projectService.fetchAllProjects();
    }

    @PutMapping("updateProject/{id}")
    public Project updateProjectById(@RequestBody Project project, @PathVariable Long id) {
        return projectService.updateById(project, id);
    }

    @DeleteMapping("deleteProject/{id}")
    public void deleteProject(@PathVariable Long id){
        projectService.deleteProjectById(id);
    }

    @GetMapping("findByName")
    //http://localhost:8080/findByName?name=Mike Doe ---> Mapping in postman
    public Optional<Project> getProjectByName(@RequestParam("name") String emp_name){
        return projectService.getProjectRecordByName(emp_name);
    }

    @DeleteMapping("deleteByName")
    public Optional<Project> deleteProjectByName(@RequestParam("name") String emp_name){
        return projectService.deleteProjectByName(emp_name);
    }


}
