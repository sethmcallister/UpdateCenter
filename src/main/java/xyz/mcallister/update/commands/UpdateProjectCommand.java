package xyz.mcallister.update.commands;

import xyz.mcallister.update.Application;
import xyz.mcallister.update.Main;
import xyz.mcallister.update.dto.Command;
import xyz.mcallister.update.dto.Project;

import java.util.List;
import java.util.logging.Level;

/**
 * Created by Sethy on 14/06/2017.
 */
public class UpdateProjectCommand extends Command
{
    public UpdateProjectCommand()
    {
        super("updateproject", "<projectName> <version>", "This command is used to update a projects version.");
    }

    @Override
    public void onExecution(List<String> args) {
        if(args.size() != 2) {
            Application.getInstance().getLogger().log(Level.WARNING, String.format("Usage: %s", this.getCommandUsage()));
            return;
        }
        String projectSTR = args.get(0);
        Project project = Application.getInstance().getProjectHandler().findByName(projectSTR);
        if(project == null) {
            Application.getInstance().getLogger().log(Level.WARNING, String.format("No project with the name %s was found", projectSTR));
            return;
        }
        String version = args.get(1);
        project.setProjectVersion(version);
        Application.getInstance().getLogger().log(Level.FINE, String.format("You have updated the project %s to the version %s", project.getProjectName(), version));
    }
}
