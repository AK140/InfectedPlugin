package org.CreeperCoders.InfectedPlugin.Commands;

import java.util.List;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

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
}
