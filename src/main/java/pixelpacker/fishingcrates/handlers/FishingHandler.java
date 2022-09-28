package pixelpacker.fishingcrates.handlers;


import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.Configuration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.crates.LootCrateTables;
import pixelpacker.fishingcrates.util.RandomSingleton;


public class FishingHandler implements Listener {
    public FishingHandler(FishingCrates plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    private static Configuration config = JavaPlugin.getPlugin(FishingCrates.class).getConfig();

    @EventHandler
    public void onItemFished(PlayerFishEvent fishEvent) {

        if(fishEvent.getState() != PlayerFishEvent.State.CAUGHT_FISH){
            return;
        }
        if(RandomSingleton.random.nextInt(100) <= config.getInt("chance_to_get_crate")){
            Player player = fishEvent.getPlayer();
            World pWorld = player.getWorld();
            Location playerLocation = player.getLocation();
            Inventory playerInv = player.getInventory();
            ItemStack randomCrate = LootCrateTables.chooseItemStack(LootCrateTables.Table_Of_Crates);

            pWorld.playSound(playerLocation, Sound.BLOCK_NOTE_BLOCK_CHIME, 1f, 1.2f);
            playerInv.addItem(randomCrate);
        }
    }
}
