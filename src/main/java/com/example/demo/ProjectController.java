package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController<projectRepository> {

    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/getAllProjects")
    public ResponseEntity<List<project>> getAllProjects() {
        try {
            List<project> projectList = projectRepository.findAll();

            if (projectList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(projectList, HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProjectById/{id}")
    public ResponseEntity<project> getProjectById(@PathVariable Long id) {
        Optional<project> projectData = projectRepository.findById(id);

        return projectData.map(project -> new ResponseEntity<>(project, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/addProject")
    public ResponseEntity<project> addProject(@RequestBody project project) {
        try {
            project projectObj = projectRepository.save(project);
            return new ResponseEntity<>(projectObj, HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateProject/{id}")
    public ResponseEntity<project> updateProject(@PathVariable Long id, @RequestBody project newProjectData) {
        Optional<project> oldProjectData = projectRepository.findById(id);

        if (oldProjectData.isPresent()) {
            project updatedProjectData = oldProjectData.get();
            updatedProjectData.setName(newProjectData.getName());
            // Add other fields to update as needed

            project1`1 updatedProject = projectRepository.save(updatedProjectData);
            return new ResponseEntity<>(updatedProject, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/deleteProjectById/{id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable Long id) {
        try {
            projectRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
