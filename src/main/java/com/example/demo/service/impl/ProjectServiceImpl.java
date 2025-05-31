package com.example.demo.service.impl;

import com.example.demo.exception.ValidationException;
import com.example.demo.model.Project;
import com.example.demo.repository.ProjectRepository;
import com.example.demo.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

    private static final Logger logger = LoggerFactory.getLogger(ProjectServiceImpl.class);

    private final ProjectRepository projectRepository;

    @Autowired
    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public List<Project> getAllProjects() {
        logger.info("Fetching all projects");
        return projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long id) {
        logger.info("Fetching project with ID: {}", id);
        return projectRepository.findById(id)
                .orElseThrow(() -> {
                    logger.warn("Project not found with ID: {}", id);
                    return new NoSuchElementException("Project not found with ID: " + id);
                });
    }

    @Override
    public Project saveProject(Project project) {
        logger.info("Saving new project: {}", project.getProjectName());
        validateProject(project);
        return projectRepository.save(project);
    }

    @Override
    public Project updateProject(Long id, Project project) {
        logger.info("Updating project with ID: {}", id);
        
        if (!projectRepository.existsById(id)) {
            logger.warn("Project not found with ID: {}", id);
            throw new NoSuchElementException("Project not found with ID: " + id);
        }
        
        validateProject(project);
        project.setId(id);
        return projectRepository.save(project);
    }

    @Override
    public void deleteProject(Long id) {
        logger.info("Deleting project with ID: {}", id);
        
        if (!projectRepository.existsById(id)) {
            logger.warn("Project not found with ID: {}", id);
            throw new NoSuchElementException("Project not found with ID: " + id);
        }
        
        projectRepository.deleteById(id);
    }

    private void validateProject(Project project) {
        List<String> errors = new ArrayList<>();
        
        if (project.getProjectName() == null || project.getProjectName().trim().isEmpty()) {
            errors.add("Project name cannot be empty");
        }
        
        if (!errors.isEmpty()) {
            logger.warn("Project validation failed: {}", errors);
            throw new ValidationException(errors);
        }
    }
}