package de.slx.clientbase.command;

import de.slx.clientbase.Client;
import de.slx.clientbase.command.commands.HelpCommand;
import de.slx.clientbase.util.ChatUtil;
import de.slx.clientbase.util.event.EventHandler;
import de.slx.clientbase.util.event.EventTarget;
import de.slx.clientbase.util.event.events.EventChatMessage;
import de.slx.tests.CommandHandlerTest;
import net.minecraft.client.Minecraft;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by joshua
 * in Client
 * at 06.05.2020
 */
public class CommandHandler {

    private String commandExecutor = ".", commandPrefix = "§7[§c" + Client.INSTANCE.getClientName() + "§7] ";

    private List<Command> commandList = new ArrayList<>();

    public CommandHandler() {
        //TODO: add commands
        this.commandList.add(new HelpCommand());
        this.commandList.add(new CommandHandlerTest());

        EventHandler.registerClass(this);
    }

    public CommandManifest getManifest(Command command) {
        if (command.getClass().isAnnotationPresent(CommandManifest.class))
            return command.getClass().getAnnotation(CommandManifest.class);
        else
            Minecraft.getLogger().warn(command.getClass().getSimpleName() + " has no manifest.");
        return null;
    }

    public List<Command> getCommandList() {
        return commandList;
    }

    public String getCommandPrefix() {
        return commandPrefix;
    }

    @EventTarget
    public void onChatMessage(EventChatMessage eventChatMessage) {
        if (!eventChatMessage.getMessage().startsWith(this.commandExecutor))
            return;

        String[] arguments = eventChatMessage.getMessage().split(" ");
        String commandName = arguments[0].substring(this.commandExecutor.length());
        Command command = this.getCommandByName(commandName);

        if (command != null)
            command.execute(arguments, commandName);
        else
            ChatUtil.printChatMessage("Command '" + commandName + "' not found!", true);
        eventChatMessage.setCancelled(true);
    }

    public Command getCommandByName(String commandName) {
        return this.getCommandList().stream()
                .filter(command -> this.getManifest(command).name().equalsIgnoreCase(commandName))
                .findFirst()
                .orElse(null);
    }
}
