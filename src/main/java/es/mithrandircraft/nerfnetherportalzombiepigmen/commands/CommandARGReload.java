package es.mithrandircraft.nerfnetherportalzombiepigmen.commands;

import es.mithrandircraft.nerfnetherportalzombiepigmen.NerfNetherPortalZombiePigmen;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

class CommandARGReload {
    public static void R(CommandSender sender, NerfNetherPortalZombiePigmen mainClass) {
        if (sender instanceof Player) //Is player
        {
            Player player = (Player) sender;
            if (player.hasPermission("NerfNetherPortalZombiePigmen.Commands.Reload")) {
                //Do reload
                mainClass.reloadConfig(); //Reload main config
                player.sendMessage("NerfNetherPortalZombiePigmen reloaded.");
            } else player.sendMessage("No permission for command.");
        } else { //Is console
            //Do reload
            mainClass.reloadConfig();
            System.out.println("NerfNetherPortalZombiePigmen reloaded.");
        }
    }
}