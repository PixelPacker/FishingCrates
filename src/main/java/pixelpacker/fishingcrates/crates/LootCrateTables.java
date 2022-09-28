package pixelpacker.fishingcrates.crates;

import org.bukkit.Material;
import pixelpacker.fishingcrates.util.RandomSingleton;

import java.util.Arrays;
import java.util.List;

public class LootCrateTables {
    public List<Material> Basic_Crate_Table = Arrays.asList(
            Material.DIAMOND,
            Material.IRON_INGOT
    );

    public Material chooseMaterial(List<Material> itemList){
        return itemList.get(RandomSingleton.random.nextInt(itemList.size()));
    }
}
