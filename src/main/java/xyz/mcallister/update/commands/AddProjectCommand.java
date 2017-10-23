package xyz.mcallister.update.commands;

import xyz.mcallister.update.Application;
import xyz.mcallister.update.dto.Command;
import xyz.mcallister.update.dto.Project;

import java.util.List;
import java.util.logging.Level;

public class AddProjectCommand extends Command {
    public AddProjectCommand() {
        super("add", "<projectName> <initialVersion>", "Add a new project to the database.");
    }

    @Override
    public void onExecution(List<String> args) {
        if(args.size() != 2) {
            Application.getInstance().getLogger().log(Level.WARNING, String.format("Usage: %s", this.getCommandUsage()));
            return;
        }
        String projectSTR = args.get(0);
        String version = args.get(1);
        Project project = Application.getInstance().getProjectHandler().findByName(projectSTR);
        if(project != null) {
            Application.getInstance().getLogger().log(Level.WARNING, String.format("A project with the name %s already exists", projectSTR));
            return;
        }
        project = new Project(projectSTR, version);
        Application.getInstance().getProjectHandler().add(project);
        Application.getInstance().getLogger().log(Level.FINE, String.format("You have added a project with the name %s", projectSTR));
    }
}
