package pixelpacker.fishingcrates.crates;

import org.bukkit.Material;
import org.bukkit.configuration.Configuration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.items.CrateItems;
import pixelpacker.fishingcrates.util.RandomSingleton;
import pixelpacker.fishingcrates.util.ServerGetter;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LootCrateTables {
    private static Configuration config = JavaPlugin.getPlugin(FishingCrates.class).getConfig();

    public static List<ItemStack> Table_Of_Crates;

    static {
        try {
            Table_Of_Crates = Arrays.asList(
                    CrateItems.getBasicCrate(ServerGetter.getServer()),
                    CrateItems.getNotBasicCrate(ServerGetter.getServer())
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<Material> Basic_Crate_Table(){
        List<String> Basic_Crate_Table_List = (List<String>) config.getList("basic_crate");
        List<Material> materials = new ArrayList<>();
        for(String material : Basic_Crate_Table_List){
            materials.add(Material.getMaterial(material));
        }
        return materials;
    }

    public static final List<Material> Not_Basic_Crate_Table(){
        List<String> Basic_Crate_Table_List = (List<String>) config.getList("not_basic_crate");
        List<Material> materials = new ArrayList<>();
        for(String material : Basic_Crate_Table_List){
            materials.add(Material.getMaterial(material));
        }
        return materials;
    };


    public LootCrateTables() throws MalformedURLException {
    }

    public static Material chooseMaterial(List<Material> materialList){
        return materialList.get(RandomSingleton.random.nextInt(materialList.size()));
    }

    public static ItemStack chooseItemStack(List<ItemStack> itemStacks){
        return itemStacks.get(RandomSingleton.random.nextInt(itemStacks.size()));
    }
}
