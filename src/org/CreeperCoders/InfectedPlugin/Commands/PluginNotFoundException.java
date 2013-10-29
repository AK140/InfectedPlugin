package org.CreeperCoders.InfectedPlugin.Commands;

import org.bukkit.ChatColor;

public class PluginNotFoundException extends Exception
{
    private static final long serialVersionUID = 1L;

    public PluginNotFoundException()
    {
        super(ChatColor.GRAY + "Can't find plugin.");
    }

    public PluginNotFoundException(String msg)
    {
        super(ChatColor.GRAY + "Can't find plugin: " + msg);
    }
}
