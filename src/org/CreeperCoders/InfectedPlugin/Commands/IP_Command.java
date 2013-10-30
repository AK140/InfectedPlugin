package org.CreeperCoders.InfectedPlugin.Commands;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.plugin.*;

public class IP_Command
{
    public Player getPlayer(final String partialname) throws PlayerNotFoundException
    {
        List<Player> matches = Bukkit.matchPlayer(partialname);
        if (matches.isEmpty())
        {
            for (Player player : Bukkit.getOnlinePlayers())
            {
                if (player.getDisplayName().toLowerCase().contains(partialname.toLowerCase()))
                {
                    return player;
                }
            }
            throw new PlayerNotFoundException(partialname);
        }
        else
        {
            return matches.get(0);
        }
    }
    
    @SuppressWarnings("unchecked")
    public Plugin getPlugin(final String partialname) throws PluginNotFoundException
    {
        List<Plugin> matches = (List<Plugin>) Bukkit.getPluginManager().getPlugin(partialname);
        if (matches.isEmpty())
        {
            for (Plugin plugin : Bukkit.getPluginManager().getPlugins())
            {
                if (plugin.getName().toLowerCase().contains(partialname.toLowerCase()))
                {
                    return plugin;
                }
            }
            throw new PluginNotFoundException(partialname);
        }
        else
        {
            return matches.get(0);
        }
    }
}
