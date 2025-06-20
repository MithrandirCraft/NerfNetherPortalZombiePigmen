package es.mithrandircraft.nerfnetherportalzombiepigmen.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandNerfZombiePigmen implements CommandExecutor {
    private final es.mithrandircraft.nerfnetherportalzombiepigmen.NerfNetherPortalZombiePigmen mainClassAccess;

    public CommandNerfZombiePigmen(es.mithrandircraft.nerfnetherportalzombiepigmen.NerfNetherPortalZombiePigmen main) {
        this.mainClassAccess = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) { //Check for what command it is in following list:
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("reload") || args[0].equalsIgnoreCase("r"))
            {
                CommandARGReload.R(sender, mainClassAccess);
            }
        }
        return false;
    }
}