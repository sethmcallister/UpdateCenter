package xyz.mcallister.update.dto;

/**
 * Created by Sethy on 14/06/2017.
 */
public class Project
{
    private final String projectName;
    private String projectVersion;

    private Project(String projectName, String projectVersion)
    {
        this.projectName = projectName;
        this.projectVersion = projectVersion;
    }

    public String getProjectName()
    {
        return projectName;
    }

    public String getProjectVersion()
    {
        return projectVersion;
    }

    public void setProjectVersion(final String version) {
        this.projectVersion = version;
    }
}
