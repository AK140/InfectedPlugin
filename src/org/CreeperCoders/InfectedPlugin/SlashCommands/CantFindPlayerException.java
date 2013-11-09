package org.CreeperCoders.InfectedPlugin.SlashCommands;

public class CantFindPlayerException extends Exception
{
    public CantFindPlayerException()
    {
        super("Can't find player.");
    }

    public CantFindPlayerException(String msg)
    {
        super("Can't find player: " + msg);
    }
}
