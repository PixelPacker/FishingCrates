package pixelpacker.fishingcrates.handlers;

import org.bukkit.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.crates.LootCrateTables;
import pixelpacker.fishingcrates.items.CrateItems;

import java.net.MalformedURLException;
import java.util.List;

public class ItemDropHandler implements Listener {

    public ItemDropHandler(FishingCrates plugin) {Bukkit.getPluginManager().registerEvents(this, plugin);}
    private static Configuration config = JavaPlugin.getPlugin(FishingCrates.class).getConfig();

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent event){
        if(!event.getPlayer().hasPermission("fishingcrates.crates.open")){
            return;
        }

        if(event.getItemDrop().getItemStack().getItemMeta().getLore() == null){
            return;
        }
        ItemStack eventItemStack = event.getItemDrop().getItemStack();
        ItemMeta eventItemMeta = eventItemStack.getItemMeta();
        List<String> eventItemLore = eventItemMeta.getLore();
        World pWorld = event.getPlayer().getWorld();
        Location dropLocation = event.getItemDrop().getLocation();
        //Checks if item lore is the same as said crate and then creates loot from config
        if(eventItemLore.equals(CrateItems.Basic_Crate_Lore)){
            spawnLoot(eventItemStack, pWorld, dropLocation, LootCrateTables.Basic_Crate_Table(), "times_to_loot_basic_crate");
        } else if (eventItemLore.equals(CrateItems.Not_Basic_Crate_Lore)) {
            spawnLoot(eventItemStack, pWorld, dropLocation, LootCrateTables.Not_Basic_Crate_Table(), "times_to_loot_not_basic_crate");
        }
    }

    public void spawnLoot(ItemStack eventItemStack, World world, Location dropLocation, List<Material > itemMaterialList, String timesToLootKey){
        int stackSize = eventItemStack.getAmount(), i = 0;
        while(i < stackSize){
            int d = 0;
            while(d < config.getInt(timesToLootKey)){
                world.dropItemNaturally(dropLocation, new ItemStack(LootCrateTables.chooseMaterial(itemMaterialList)));
                d++;
            }
            world.spawnParticle(Particle.FIREWORKS_SPARK, dropLocation, 10);
            world.spawnParticle(Particle.EXPLOSION_NORMAL, dropLocation, 10);
            world.playSound(dropLocation, Sound.ENTITY_FIREWORK_ROCKET_BLAST, .5f, 1f);
            world.playSound(dropLocation, Sound.ENTITY_FIREWORK_ROCKET_BLAST, .6f, .9f);
            world.playSound(dropLocation, Sound.ENTITY_EXPERIENCE_ORB_PICKUP, .5f, 1.1f);
            i++;
        }
        eventItemStack.setAmount(-stackSize);
    }


}
