package es.mithrandircraft.nerfnetherportalzombiepigmen.events;

import es.mithrandircraft.nerfnetherportalzombiepigmen.NerfNetherPortalZombiePigmen;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.ListIterator;

public class EntityDeathEv implements Listener {

    private final NerfNetherPortalZombiePigmen mainClassAccess;

    public EntityDeathEv(NerfNetherPortalZombiePigmen main) { this.mainClassAccess = main; }

    @EventHandler
    public void entityDeathEv(EntityDeathEvent e) {
        if(e.getEntityType() == EntityType.ZOMBIFIED_PIGLIN && !e.getEntity().hasMetadata("safe_from_nerf"))
        {
            List<ItemStack> drops = e.getDrops();
            ListIterator<ItemStack> iter = drops.listIterator();
            while(iter.hasNext()){
                Material itemMaterial = iter.next().getType();
                double chance = Math.random();
                if (itemMaterial == Material.GOLD_INGOT) {
                    if (chance > mainClassAccess.getConfig().getDouble("ZombifiedPiglinGoldIngotDropRate"))
                    {
                        iter.remove();
                    }
                }
                else if (itemMaterial == Material.GOLD_NUGGET) {
                    if (chance > mainClassAccess.getConfig().getDouble("ZombifiedPiglinGoldNuggetDropRate"))
                    {
                        iter.remove();
                    }
                }
            }

            e.setDroppedExp(mainClassAccess.getConfig().getInt("ZombifiedPiglinExperienceDrop"));
        }
    }
}
