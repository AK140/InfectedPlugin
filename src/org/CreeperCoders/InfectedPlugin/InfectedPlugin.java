package org.CreeperCoders.InfectedPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public class InfectedPlugin extends JavaPlugin
{
   public final Logger log = Logger.getLogger("Minecraft");
   
   @Override
   public void onEnable()
   {
       log.info("PluginPack has been enabled!");
   }
   
   @Override
   public void onDisable()
   {
       log.info("PluginPack has been disabled.");
   }
}
