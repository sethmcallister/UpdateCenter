package xyz.mcallister.update;

import xyz.mcallister.update.dao.CommandHandler;
import xyz.mcallister.update.dto.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sethy on 14/06/2017.
 */
public class Application
{
    private final CommandHandler commandHandler;

    public Application()
    {
        this.commandHandler = new CommandHandler();

        this.setupConsole();
    }

    private void setupConsole()
    {
        do
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String commandSTR;
            List<String> arguments;
            try
            {
                String[] strings = reader.readLine().split(" ");
                commandSTR = strings[0];
                arguments = Arrays.asList(strings);
                arguments.remove(0);
            }
            catch (IOException e)
            {
                commandSTR = null;
                arguments = null;
                e.printStackTrace();
            }
            final Command command = this.commandHandler.findByName(commandSTR);
            if(command != null)
                command.onExecution(arguments);
        } while (true);
    }
}
