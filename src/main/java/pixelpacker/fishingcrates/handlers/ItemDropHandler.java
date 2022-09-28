package pixelpacker.fishingcrates.handlers;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.crates.LootCrateTables;
import pixelpacker.fishingcrates.items.CrateItems;

public class ItemDropHandler implements Listener {

    public ItemDropHandler(FishingCrates plugin) {Bukkit.getPluginManager().registerEvents(this, plugin);}
    private static final LootCrateTables lootCrateTables = new LootCrateTables();
    private static final CrateItems crateItems = new CrateItems();

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        if(event.getItemDrop().getItemStack().getItemMeta().getLore() == null){
            return;
        }

        ItemStack eventItemStack = event.getItemDrop().getItemStack();
        ItemMeta eventItemMeta = eventItemStack.getItemMeta();
        World pWorld = event.getPlayer().getWorld();
        if(eventItemMeta.getLore().equals(crateItems.Basic_Crate_Lore)){
            Location dropLocation = event.getItemDrop().getLocation();
            int stackSize = eventItemStack.getAmount(), i = 0;
            while(i < stackSize){
                i++;
                pWorld.dropItem(dropLocation, new ItemStack(lootCrateTables.chooseMaterial(lootCrateTables.Basic_Crate_Table)));
                pWorld.spawnParticle(Particle.FIREWORKS_SPARK, dropLocation, 10);
                pWorld.spawnParticle(Particle.EXPLOSION_NORMAL, dropLocation, 10);
                pWorld.playSound(dropLocation, Sound.ENTITY_FIREWORK_ROCKET_BLAST, .5f, 1f);
                pWorld.playSound(dropLocation, Sound.ENTITY_FIREWORK_ROCKET_BLAST, .6f, .9f);
                pWorld.playSound(dropLocation, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, .5f, 1.1f);
            }
            eventItemStack.setAmount(-stackSize);
        }
    }
}
