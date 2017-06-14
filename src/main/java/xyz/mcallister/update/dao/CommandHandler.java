package xyz.mcallister.update.dao;

import xyz.mcallister.update.commands.UpdateProjectCommand;
import xyz.mcallister.update.dto.Command;

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;

/**
 * Created by Sethy on 14/06/2017.
 */
public class CommandHandler
{
    private final Set<Command> commands;

    public CommandHandler()
    {
        this.commands = new ConcurrentSkipListSet<>();
        this.commands.add(new UpdateProjectCommand());
    }

    public Command findByName(String string)
    {
        return this.commands.stream()
                .filter(command -> command.getCommandName().equals(string))
                .findFirst()
                .orElse(null);
    }
}
