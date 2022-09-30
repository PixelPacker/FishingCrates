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
import java.util.List;

public class LootCrateTables {
    private static Configuration config = JavaPlugin.getPlugin(FishingCrates.class).getConfig();

    public static List<Material> crate1Table(){
        return createTable("crate1_loot");
    }
    public static List<Material> crate2Table(){
        return createTable("crate2_loot");
    };
    public static List<Material> crate3Table(){
        return createTable("crate3_loot");
    };
    public static List<Material> crate4Table(){
        return createTable("crate4_loot");
    };
    public static List<Material> crate5Table(){
        return createTable("crate5_loot");
    };
    public static List<Material> crate6Table(){
        return createTable("crate6_loot");
    };
    public static List<Material> crate7Table(){
        return createTable("crate7_loot");
    };
    public static List<Material> crate8Table(){
        return createTable("crate8_loot");
    };
    public static List<Material> crate9Table(){
        return createTable("crate9_loot");
    };
    public static List<Material> crate10Table(){
        return createTable("crate10_loot");
    };
    public static List<Material> createTable(String keyToLoot){
        List<String> crateLoot = (List<String>) config.getList(keyToLoot);
        List<Material> materials = new ArrayList<>();
        for(String material : crateLoot){
            materials.add(Material.getMaterial(material));
        }
        return materials;
    }

    public static List<ItemStack> getTableOfCrates() throws MalformedURLException {
        List<ItemStack> crates = new ArrayList<>();

        ItemStack crate1 = CrateItems.getCrate1(ServerGetter.getServer());
        ItemStack crate2 = CrateItems.getCrate2(ServerGetter.getServer());
        ItemStack crate3 = CrateItems.getCrate3(ServerGetter.getServer());
        ItemStack crate4 = CrateItems.getCrate4(ServerGetter.getServer());
        ItemStack crate5 = CrateItems.getCrate5(ServerGetter.getServer());
        ItemStack crate6 = CrateItems.getCrate6(ServerGetter.getServer());
        ItemStack crate7 = CrateItems.getCrate7(ServerGetter.getServer());
        ItemStack crate8 = CrateItems.getCrate8(ServerGetter.getServer());
        ItemStack crate9 = CrateItems.getCrate9(ServerGetter.getServer());
        ItemStack crate10 = CrateItems.getCrate10(ServerGetter.getServer());
        if (config.getBoolean("crate1_enabled")
        ) {
            crates.add(crate1);
        }
        if (config.getBoolean("crate2_enabled")
        ) {
            crates.add(crate2);
        }
        if (config.getBoolean("crate3_enabled")
        ) {
            crates.add(crate3);
        }
        if (config.getBoolean("crate4_enabled")
        ) {
            crates.add(crate4);
        }
        if (config.getBoolean("crate5_enabled")
        ) {
            crates.add(crate5);
        }
        if (config.getBoolean("crate6_enabled")
        ) {
            crates.add(crate6);
        }
        if (config.getBoolean("crate7_enabled")
        ) {
            crates.add(crate7);
        }
        if (config.getBoolean("crate8_enabled")
        ) {
            crates.add(crate8);
        }
        if (config.getBoolean("crate9_enabled")
        ) {
            crates.add(crate9);
        }
        if (config.getBoolean("crate10_enabled")
        ) {
            crates.add(crate10);
        }
        return crates;
    }

    public static Material chooseMaterial(List<Material> materialList){
        return materialList.get(RandomSingleton.random.nextInt(materialList.size()));
    }

    public static ItemStack chooseItemStack(List<ItemStack> itemStacks){
        return itemStacks.get(RandomSingleton.random.nextInt(itemStacks.size()));
    }
}
