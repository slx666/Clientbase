package de.slx.clientbase.util;

import de.slx.clientbase.Client;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;

/**
 * Created by joshua
 * in Client
 * at 06.05.2020
 */
public class ChatUtil {

    public static void printChatMessage(String message, boolean prefix) {
        Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(prefix ? Client.INSTANCE.getCommandHandler().getCommandPrefix() + message : message));
    }
}
