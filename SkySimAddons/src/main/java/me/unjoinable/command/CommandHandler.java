package me.unjoinable.command;

import net.minecraft.command.ICommand;
import net.minecraftforge.client.ClientCommandHandler;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.command.CommandBase;
public class CommandHandler {
    public static void register(final CMDBase cmd) {
        final CommandBase command = new CommandBase() {
            public String getCommandName() {
                return cmd.getName();
            }

            public String getCommandUsage(final ICommandSender sender) {
                return cmd.getDescription();
            }

            public void processCommand(final ICommandSender sender, final String[] args) throws CommandException {
                cmd.execute(args);
            }

            public int getRequiredPermissionLevel() {
                return 0;
            }

            public List<String> getCommandAliases() {
                return new ArrayList<String>(Arrays.asList(cmd.getAliases()));
            }
        };
        ClientCommandHandler.instance.registerCommand((ICommand) command);
    }
}
