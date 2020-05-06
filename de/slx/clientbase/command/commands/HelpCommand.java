package de.slx.clientbase.command.commands;

import de.slx.clientbase.Client;
import de.slx.clientbase.command.Command;
import de.slx.clientbase.command.CommandManifest;
import de.slx.clientbase.util.ChatUtil;

/**
 * Created by joshua
 * in Client
 * at 06.05.2020
 */
@CommandManifest(name = "help", description = "A quick guide for all commands")
public class HelpCommand implements Command {

    @Override
    public void execute(String[] args, String commandName) {
        switch (args.length) {
            default:
                Client.INSTANCE.getCommandHandler().getCommandList()
                        .forEach(command -> ChatUtil.printChatMessage(Client.INSTANCE.getCommandHandler().getManifest(command).name() + " || " + Client.INSTANCE.getCommandHandler().getManifest(command).description(), true));
        }
    }
}
