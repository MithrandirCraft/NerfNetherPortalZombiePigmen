package es.mithrandircraft.nerfnetherportalzombiepigmen;

import es.mithrandircraft.nerfnetherportalzombiepigmen.commands.CommandNerfZombiePigmen;
import es.mithrandircraft.nerfnetherportalzombiepigmen.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class NerfNetherPortalZombiePigmen extends JavaPlugin {

    @Override
    public void onEnable() {
        //Config load:
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        //Event registering:
        getServer().getPluginManager().registerEvents(new CreatureSpawnEv(this), this);
        getServer().getPluginManager().registerEvents(new EntityDeathEv(this), this);

        //Commands:
        getCommand("nerfnetherportalzombiepigmen").setExecutor(new CommandNerfZombiePigmen(this));
    }

    @Override
    public void onDisable() {}
}
