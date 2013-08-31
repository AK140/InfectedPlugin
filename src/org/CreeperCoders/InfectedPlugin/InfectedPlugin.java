package org.CreeperCoders.InfectedPlugin;

import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

public class InfectedPlugin extends JavaPlugin
{
    public static void Logger log = Logger.getLogger("Minecraft");

    @Override
    public void onEnable()
    {
        log.info("[%s] version %s by %s has been enabled!");
    }

    @Override
    public void onDisable()
    {
        log.info(String.format("[%s] has been disabled!", getDescription().getName()));
    }

    @Override
    public void PlayerChat(PlayerChatEvent tester_player)
    {
        if (tester_player.equals("tagme"))
        {
            tester_player.startsWith("hi");
        }
    }

}
