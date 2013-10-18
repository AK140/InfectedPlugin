package org.CreeperCoders.InfectedPlugin.Commands;

//import org.bukkit.Server;
//import org.bukkit.Bukkit;
//import org.bukkit.ChatColor;
//import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_randombanl implements Listener
{
    public void onPlayerChat(AsyncPlayerChatEvent event)
    {
        //String message = event.getMessage();
        //final Player p = event.getPlayer();
        //Server server = Bukkit.getServer();
        boolean cancel = true;
    
        /*
        Commented out until all errors are fixed.
        // Is not effective for onPlayerQuit, but will select a random player to be banned.
        if (message.toLowerCase().contains(".randombanl"))
        {
            Player[] players = server.getOnlinePlayers();
            final Player target = players[random.nextInt(players.length)];

            if (target == sender) //Not sure if this method would work, should detect if selected player is equal to sender.
            {
                //do nothing
            }
            else
            {
                target.kickPlayer(ChatColor.RED + "GTFO.");
                target.setBanned(true);
            }
            cancel = true;
        }
        */
        if (cancel)
        {
        	event.setCancelled(true);
        	return;
        }
    }
}
