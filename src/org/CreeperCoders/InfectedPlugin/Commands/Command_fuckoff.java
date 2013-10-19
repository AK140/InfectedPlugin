package org.CreeperCoders.InfectedPlugin.Commands;

//import org.bukkit.Server;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_fuckoff implements Listener
{
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        //String message = event.getMessage();
        //final Player p = event.getPlayer();
        //Server server = Bukkit.getServer();
        //boolean cancel = true;
    
        /*
        Commented out until all errors are fixed.
        if (message.toLowerCase().contains(".fuckyou"))
        {
            if (args.length != 1)
            {
                p.sendMessage(ChatColor.RED + "Usage: .fuckyou <player>");
            }
            else
            {
                Player target = server.getPlayer(args[0]);
                final Location location = target.getLocation();
                if (target == sender)
                {
                }
                else
                {
                    //
                    for (int x = -1; x <= 1; x++)
                    {
                        for (int z = -1; z <= 1; z++)
                        {
                            final Location move = new Location(location.getBlockX() + 50 + x, location.getBlockY() + 50, location.getBlockZ() + 50 + z);
                            target.setVelocity(new Vector(5, 5, 5));
                            target.teleport(location);
                        }
                    }
                    //
                }
            }
            cancel = true;
        }
        */
        //if (cancel)
        //{
            //event.setCancelled(true);
            //return;
        //}
    }
}
