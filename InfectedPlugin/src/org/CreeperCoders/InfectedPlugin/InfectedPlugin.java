package org.CreeperCoders.InfectedPlugin;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.CreeperCoders.InfectedPlugin.Commands.pluginpack;
import org.CreeperCoders.InfectedPlugin.Commands.anticheat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfectedPlugin extends JavaPlugin
{

    public final Logger log = Logger.getLogger("Minecraft-Server");

    public static String MSG_NO_PERMS = ChatColor.YELLOW + "You do not have permission to preform this command.";

    public InfectedPlugin plugin;

    public anticheat anticheat = new anticheat(this);

    public pluginpack pluginpack = new pluginpack(this);

    @Override
    public void onEnable()
    {
        getCommand("pluginpack").setExecutor(pluginpack);
        getCommand("anticheat").setExecutor(anticheat);
        this.getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        log.info(String.format("[%s] version %s by %s has been enabled!", getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
    }

    @Override
    public void onDisable()
    {
        log.info(String.format("[%s] has been disabled!", getDescription().getName()));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        Player player = (Player) sender;

        if (commandLabel.equalsIgnoreCase("anticheat"))
        {

            sender.sendMessage(ChatColor.GREEN + "Anticheat 1.0 is working 100%");
            return true;

        }

        if (commandLabel.equalsIgnoreCase("pluginpack"))
        {
            sender.sendMessage(ChatColor.GREEN + "PluginPack 1.0, working 100%! Use /anticheat to see anticheat details");
            return true;
        }
        return false;
    }

}