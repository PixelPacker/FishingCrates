package pixelpacker.fishingcrates.handlers;


import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.items.CrateItems;

import java.net.MalformedURLException;


public class FishingHandler implements Listener {
    public FishingHandler(FishingCrates plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }
    private static final CrateItems crateItems = new CrateItems();

    @EventHandler
    public void onItemFished(PlayerFishEvent fishEvent) throws MalformedURLException {

        if(fishEvent.getState() != PlayerFishEvent.State.CAUGHT_FISH){
            return;
        }
        Player player = fishEvent.getPlayer();
        Inventory playerInv = player.getInventory();

        playerInv.addItem(new ItemStack(crateItems.getBasicCrate(player.getServer())));
    }
}
