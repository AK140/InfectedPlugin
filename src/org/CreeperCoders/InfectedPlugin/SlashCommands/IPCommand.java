package org.CreeperCoders.InfectedPlugin.SlashCommands;

import java.util.List;
import java.util.logging.Logger;
import org.CreeperCoders.InfectedPlugin.InfectedPlugin;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IPCommand
{
    protected InfectedPlugin plugin;
    protected Server server;
    protected static final Logger log = server.getLogger();
    
    public TFM_Command()
    {
    }
    
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        log.severe("Command Error: Command not implemented: " + cmd.getName());
        sender.sendMessage(ChatColor.RED + "Command Error: Command not implemented: " + cmd.getName());
        return false;
    }
    
    public void setPlugin(InfectedPlugin plugin)
    {
        this.plugin = plugin;
        this.server = plugin.getServer();
    }
    
    public Player getPlayer(String partialname) throws CantFindPlayerException
    {
        List<Player> matches = server.matchPlayer(partialname);
        if (matches.isEmpty())
        {
            throw new CantFindPlayerException(partialname);
        }
        else
        {
            return matches.get(0);
        }
    }
}
