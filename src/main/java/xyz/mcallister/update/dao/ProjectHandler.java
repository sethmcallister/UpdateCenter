package xyz.mcallister.update.dao;

import xyz.mcallister.update.dto.Project;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Sethy on 14/06/2017.
 */
public class ProjectHandler
{
    private final Set<Project> projects;

    public ProjectHandler()
    {
        this.projects = new ConcurrentSkipListSet<>();
    }

    public Project findByName(String string)
    {
        return this.projects.stream()
                .filter(project -> project.getProjectName().equalsIgnoreCase(string))
                .findFirst()
                .orElse(null);
    }
}
