package es.mithrandircraft;

import es.mithrandircraft.events.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class NerfNetherPortalZombiePigmen extends JavaPlugin {

    @Override
    public void onEnable() {
        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new CreatureSpawnEv(this), this);
        getServer().getPluginManager().registerEvents(new EntityDeathEv(this), this);
    }

    @Override
    public void onDisable() {}
}
