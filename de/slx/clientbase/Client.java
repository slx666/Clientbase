package de.slx.clientbase;

import de.slx.clientbase.command.CommandHandler;
import de.slx.clientbase.module.ModuleHandler;
import de.slx.clientbase.util.event.EventTarget;
import de.slx.clientbase.util.event.events.EventStartClient;
import net.minecraft.client.Minecraft;

/**
 * Created by joshua
 * in Client
 * at 04.05.2020
 */
public enum Client {

    INSTANCE;

    private final String clientName = "Test", clientDeveloper = "Joshua";
    private final int clientBuild = 1;

    private ModuleHandler moduleHandler;
    private CommandHandler commandHandler;

    @EventTarget
    public void startClient(EventStartClient eventStartClient) {
        this.moduleHandler = new ModuleHandler();
        this.commandHandler = new CommandHandler();

        Minecraft.getLogger().info("Client started!");
    }

    public String getClientName() {
        return clientName;
    }

    public String getClientDeveloper() {
        return clientDeveloper;
    }

    public int getClientBuild() {
        return clientBuild;
    }

    public ModuleHandler getModuleHandler() {
        return moduleHandler;
    }

    public CommandHandler getCommandHandler() {
        return commandHandler;
    }
}
