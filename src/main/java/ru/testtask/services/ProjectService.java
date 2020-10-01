package ru.testtask.services;

import ru.testtask.DAO.ProjectDAO;
import ru.testtask.models.Project;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectService {

    private ProjectDAO projectDao = new ProjectDAO();

    public ProjectService() {
    }

    public Project findProject(int id) {
        return projectDao.findById(id);
    }

    public void saveProject(Project project) {
        projectDao.save(project);
    }

    public void deleteProject(Project project) {
        projectDao.delete(project);
    }

    public void updateProject(Project project) {
        projectDao.update(project);
    }

    public List<Project> findAllUsers() {
        return projectDao.findAll();
    }

}
