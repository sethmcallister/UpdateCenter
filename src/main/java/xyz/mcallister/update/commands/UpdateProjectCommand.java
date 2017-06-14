package xyz.mcallister.update.commands;

import xyz.mcallister.update.dto.Command;

import java.util.List;

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
    public void onExecution(List<String> args)
    {

    }
}
