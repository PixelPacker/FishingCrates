package pixelpacker.fishingcrates.handlers;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.items.CrateItems;

import java.net.MalformedURLException;
import java.util.*;

public class BlockBreakHandler implements Listener {

    public BlockBreakHandler(FishingCrates plugin){
        Bukkit.getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent blockBreakEvent) throws MalformedURLException {
        List<ItemStack> droppedItems = blockBreakEvent.getBlock().getDrops().stream().toList();
        int droppedItemsSize = droppedItems.size(), i = 0;
        while(i < droppedItemsSize){
            ItemStack itemStack = droppedItems.get(i);
            if(blockBreakEvent.getBlock().getType() == Material.PLAYER_HEAD){
                SkullMeta skullMeta = (SkullMeta) itemStack.getItemMeta();
                Server server = blockBreakEvent.getPlayer().getServer();
                Location location = blockBreakEvent.getBlock().getLocation();
                if(skullMeta.getOwnerProfile() != null){
                    //Introduce new crates here in order to get said crate when block is broken
                    if(skullMeta.getOwnerProfile().getName() == CrateItems.getBasicCrateProfile(server).getName()){
                        replaceDroppedItem(CrateItems.getBasicCrate(server), location, blockBreakEvent);
                    } else if (skullMeta.getOwnerProfile().getName() == CrateItems.getNotBasicCrateProfile(server).getName()) {
                        replaceDroppedItem(CrateItems.getNotBasicCrate(server), location, blockBreakEvent);
                    }
                }
            }
            i++;
        }
    }

    private void replaceDroppedItem(ItemStack replaceWith, Location location, BlockBreakEvent blockBreakEvent){
        blockBreakEvent.getBlock().setType(Material.AIR);
        blockBreakEvent.getBlock().getWorld().dropItemNaturally(location, replaceWith);
    }
}
