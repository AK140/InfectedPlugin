package org.CreeperCoders.InfectedPlugin.SlashCommands;

public class CantFindPlayerException extends Exception
{
    private static final long serialVersionUID = 1L;

    public CantFindPlayerException()
    {
        super("Can't find player.");
    }

    public CantFindPlayerException(String msg)
    {
        super("Can't find player: " + msg);
    }
}
