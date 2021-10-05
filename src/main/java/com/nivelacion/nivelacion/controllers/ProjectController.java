package com.nivelacion.nivelacion.controllers;

import com.nivelacion.nivelacion.models.Project;
import com.nivelacion.nivelacion.models.Users;
import com.nivelacion.nivelacion.repositories.ProjectRepository;
import com.nivelacion.nivelacion.repositories.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class ProjectController {


    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;

    public ProjectController(UserRepository userRepository, ProjectRepository projectRepository) {
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
    }

    @PostMapping("/project")
    Project newProject(@RequestBody Project project){
        Users UserId = userRepository.findById(project.getIdUser()).orElse(null);

        UserId.setRol(UserId.getRol());
        UserId.setEstado(UserId.getEstado());
        UserId.setEdad(UserId.getEdad());
        userRepository.save(UserId);

        project.setFechaInicio(new Date());
        return projectRepository.save(project);



    }
}
