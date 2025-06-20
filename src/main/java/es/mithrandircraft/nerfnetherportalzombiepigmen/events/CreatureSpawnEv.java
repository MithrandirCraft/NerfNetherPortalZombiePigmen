package es.mithrandircraft.nerfnetherportalzombiepigmen.events;

import es.mithrandircraft.nerfnetherportalzombiepigmen.NerfNetherPortalZombiePigmen;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.entity.EntityType;
import org.bukkit.metadata.FixedMetadataValue;

public class CreatureSpawnEv implements Listener {

    private final NerfNetherPortalZombiePigmen mainClassAccess;

    public CreatureSpawnEv(NerfNetherPortalZombiePigmen main) { this.mainClassAccess = main; }

    @EventHandler
    public void creatureSpawnEvent(CreatureSpawnEvent e) {
        /* NOTE: A "tag to be safe from nerf" approach was taken for Zombified Piglins as opposed to "tag to get nerfed"
         * because spigot is fucking broken, and e.getSpawnReason() will never return
         * CreatureSpawnEvent.SpawnReason.NETHER_PORTAL (SpawnReason which is this plugin's main cause for concern) */
        if(e.getEntityType() == EntityType.ZOMBIFIED_PIGLIN)
        {
            if (mainClassAccess.getConfig().getBoolean("LogZombiePigmanSpawnOperations"))
                System.out.println("ZOMBIFIED_PIGLIN spawn reason: " + e.getSpawnReason() + " location: " + e.getEntity().getLocation());

            if ((e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.NATURAL)
                    || e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER)
                    || e.getSpawnReason().equals(CreatureSpawnEvent.SpawnReason.SPAWNER_EGG)))
            {
                e.getEntity().setMetadata( "safe_from_nerf", new FixedMetadataValue(this.mainClassAccess, true));
            }
        }
    }
}