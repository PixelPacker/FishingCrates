package pixelpacker.fishingcrates.handlers;

import org.bukkit.*;
import org.bukkit.configuration.Configuration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.crates.LootCrateTables;
import pixelpacker.fishingcrates.items.CrateItems;
import pixelpacker.fishingcrates.util.RandomSingleton;

import java.util.List;
import java.util.Objects;

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
        if(eventItemLore.equals(CrateItems.getCrate1Lore)){
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate1Table(), "times_to_loot_crate1");
        } else if (eventItemLore.equals(CrateItems.getCrate2Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate2Table(), "times_to_loot_crate2");
        }else if (eventItemLore.equals(CrateItems.getCrate3Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate3Table(), "times_to_loot_crate3");
        }else if (eventItemLore.equals(CrateItems.getCrate4Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate4Table(), "times_to_loot_crate4");
        }else if (eventItemLore.equals(CrateItems.getCrate5Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate5Table(), "times_to_loot_crate5");
        }else if (eventItemLore.equals(CrateItems.getCrate6Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate6Table(), "times_to_loot_crate6");
        }else if (eventItemLore.equals(CrateItems.getCrate7Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate7Table(), "times_to_loot_crate7");
        }else if (eventItemLore.equals(CrateItems.getCrate8Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate8Table(), "times_to_loot_crate8");
        }else if (eventItemLore.equals(CrateItems.getCrate9Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate9Table(), "times_to_loot_crate9");
        }else if (eventItemLore.equals(CrateItems.getCrate10Lore)) {
            spawnLoot(eventItemStack, event, pWorld, dropLocation, LootCrateTables.crate10Table(), "times_to_loot_crate10");
        }
    }

    public void spawnLoot(ItemStack eventItemStack, PlayerDropItemEvent playerDropItemEvent, World world, Location dropLocation, List<Material > itemMaterialList, String timesToLootKey){
        int stackSize = eventItemStack.getAmount(), i = 0;
        while(i < stackSize){
            int d = 0;
            while(d < config.getInt(timesToLootKey)){
                if(config.getBoolean("spawn_loot_in_world")){
                    double x = dropLocation.getX() + RandomSingleton.random.nextInt(2) - 1f;
                    double y = dropLocation.getY();
                    double z = dropLocation.getZ() + RandomSingleton.random.nextInt(2) - 1f;

                    Location randomizedLocation = new Location(world, x, y, z);
                    world.dropItemNaturally(randomizedLocation, new ItemStack(LootCrateTables.chooseMaterial(itemMaterialList)));
                }else{
                    playerDropItemEvent.getPlayer().getInventory().addItem(new ItemStack(LootCrateTables.chooseMaterial(itemMaterialList)));
                }
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
