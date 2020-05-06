package de.slx.tests;

import de.slx.clientbase.command.Command;
import de.slx.clientbase.command.CommandManifest;
import de.slx.clientbase.util.ChatUtil;

/**
 * Created by joshua
 * in Client
 * at 06.05.2020
 * This class should be removed
 */
@CommandManifest(name = "test", description = "A simple command to test the command handler")
public class CommandHandlerTest implements Command {

    @Override
    public void execute(String[] args, String commandName) {
        //Quick note, the command itself (in this case 'test') will be count as an argument
        ChatUtil.printChatMessage("Test command! {l:" + args.length + "}", true);
        switch (args.length) {
            case 1:
                //The command
                String cName = args[0];
                ChatUtil.printChatMessage("This argument is the command itself. Name: '" + cName + "'", true);
                break;
            case 2:
                String argument = args[1];
                ChatUtil.printChatMessage("'" + argument + "' would be the the first argument you should use!", true);
                //Argument after the command
                //And so on...
                //Remember that "args.length" will return a "human readable" length. (Always starting with 1 if the array contains something)
                break;
        }
        //Is this smart? Well I don't know.
    }
}
