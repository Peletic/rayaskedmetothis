package me.unjoinable.command;

import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
public class CommandManager
{
    private static CommandManager instance;
    private List<CMDBase> commandRegistry;

    public CommandManager() {
        this.commandRegistry = new ArrayList<CMDBase>();
        CommandManager.instance = this;
    }

    public static CommandManager getInstance() {
        return CommandManager.instance;
    }

    public void register(final CMDBase cmd) {
        this.commandRegistry.add(cmd);
    }

    public List<CMDBase> getCommandRegistry() {
        return this.commandRegistry;
    }

    public void reg() {
        for (final CMDBase cmd : this.commandRegistry) {
            CommandHandler.register(cmd);
        }
    }
}
