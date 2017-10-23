package xyz.mcallister.update;

import xyz.mcallister.update.dao.CommandHandler;
import xyz.mcallister.update.dao.ProjectHandler;
import xyz.mcallister.update.dto.Command;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by Sethy on 14/06/2017.
 */
public class Application
{
    private static Application instance;
    private final CommandHandler commandHandler;
    private final ProjectHandler projectHandler;
    private final Logger logger;

    public Application()
    {
        setInstance(this);
        this.commandHandler = new CommandHandler();
        this.projectHandler = new ProjectHandler();
        this.logger = Logger.getLogger("UpdateCenter");

        setupConsole();
    }

    private static synchronized void setInstance(Application newInstance) {
        instance = newInstance;
    }

    public static synchronized Application getInstance() {
        return instance;
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

    public Logger getLogger() {
        return logger;
    }

    public ProjectHandler getProjectHandler() {
        return projectHandler;
    }
}
