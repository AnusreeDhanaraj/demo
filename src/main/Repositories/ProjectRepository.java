package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository; // This suggests ProjectRepository is an interface

    @GetMapping("/getAllprojects")
    public ResponseEntity<List<Project>> getAllProjects() {
        // Method implementation
    }

    @GetMapping("/getProjectById/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        // Method implementation
    }

    @PostMapping("/addProject")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        // Method implementation
    }

    @PutMapping("/updateProject/{id}")
    public ResponseEntity<Project> updateProject(@PathVariable Long id, @RequestBody Project newProjectData) {
        // Method implementation
    }

    @DeleteMapping("/deleteProjectById/{id}")
    public ResponseEntity<Void> deleteProjectById(@PathVariable Long id) {
        // Method implementation
    }
}
