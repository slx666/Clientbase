package de.slx.clientbase.command;

/**
 * Created by joshua
 * in Client
 * at 06.05.2020
 */
public interface Command {

    void execute(String[] args, String commandName);
}
