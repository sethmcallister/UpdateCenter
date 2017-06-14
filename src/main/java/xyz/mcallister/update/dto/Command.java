package xyz.mcallister.update.dto;

import java.util.List;

/**
 * Created by Sethy on 14/06/2017.
 */
public abstract class Command
{
    private final String commandName;
    private final String commandUsage;
    private final String commandDescription;

    public Command(String commandName, String commandUsage, String commandDescription)
    {
        this.commandName = commandName;
        this.commandUsage = commandUsage;
        this.commandDescription = commandDescription;
    }

    public String getCommandName()
    {
        return commandName;
    }

    public String getCommandUsage()
    {
        return commandUsage;
    }

    public String getCommandDescription()
    {
        return commandDescription;
    }

    public abstract void onExecution(List<String> args);
}
