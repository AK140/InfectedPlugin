package org.CreeperCoders.InfectedPlugin.SlashCommands;

import org.CreeperCoders.InfectedPlugin.IP_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandfun extends IP_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length == 0)
        {
            sender.sendMessage(ChatColor.GOLD + "Want some fun? type in a secret code for easter egg");
            return false;
        }
        else if (args[0].equalsIgnoreCase("moo"))
        {
            IP_Util.run_moo(sender, commandLabel, args);
        }
        else if (args[0].equalsIgnoreCase("op") || args[0].equalsIgnoreCase("deop"))
        {
            sender.sendMessage("You really think that would work?");
        }
        else
        {
            sender.sendMessage("Code not found!");
        }
        return true;
    }
}
