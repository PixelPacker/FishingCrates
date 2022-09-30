package pixelpacker.fishingcrates.items;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.configuration.Configuration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.profile.PlayerProfile;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.util.ServerGetter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

public class CrateItems {
    private static Configuration config = JavaPlugin.getPlugin(FishingCrates.class).getConfig();

    //ItemStacks go here
    public static ItemStack getCrate1(Server server) throws MalformedURLException {
        return createCrate("crate1_name", "crate1_lore", getCrate1Profile(server));
    }

    public static ItemStack getCrate2(Server server) throws MalformedURLException {
        return createCrate("crate2_name", "crate2_lore", getCrate2Profile(server));
    }

    public static ItemStack getCrate3(Server server) throws MalformedURLException {
        return createCrate("crate3_name", "crate3_lore", getCrate3Profile(server));
    }

    public static ItemStack getCrate4(Server server) throws MalformedURLException {
        return createCrate("crate4_name", "crate4_lore", getCrate4Profile(server));
    }

    public static ItemStack getCrate5(Server server) throws MalformedURLException {
        return createCrate("crate5_name", "crate5_lore", getCrate5Profile(server));
    }

    public static ItemStack getCrate6(Server server) throws MalformedURLException {
        return createCrate("crate6_name", "crate6_lore", getCrate6Profile(server));
    }

    public static ItemStack getCrate7(Server server) throws MalformedURLException {
        return createCrate("crate7_name", "crate7_lore", getCrate7Profile(server));
    }

    public static ItemStack getCrate8(Server server) throws MalformedURLException {
        return createCrate("crate8_name", "crate8_lore", getCrate8Profile(server));
    }

    public static ItemStack getCrate9(Server server) throws MalformedURLException {
        return createCrate("crate9_name", "crate9_lore", getCrate9Profile(server));
    }

    public static ItemStack getCrate10(Server server) throws MalformedURLException {
        return createCrate("crate10_name", "crate10_lore", getCrate10Profile(server));
    }

    private static ItemStack createCrate(String keyToCrateName, String keyToCrateLore, PlayerProfile playerProfile) throws MalformedURLException {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName(config.getString(keyToCrateName));
        meta.setLore(config.getStringList(keyToCrateLore));
        PlayerProfile profile = meta.getOwnerProfile();
        if(profile == null){
            profile = playerProfile;
        }
        profile.getTextures().setSkin(new URL("https://textures.minecraft.net/texture/e34a3619dc66fc5f940f69aa331e588b5285f6e2e9981b8f93b99916c294b48"));
        meta.setOwnerProfile(profile);
        item.setItemMeta(meta);

        return item;
    }

    /**
     * - VERY IMPORTANT -
     * Each crate is required to have different lore as it's
     * used to figure out which table should be used when dropped
     */
    public static final List<String> getCrate1Lore = config.getStringList("crate1_lore");
    public static final List<String> getCrate2Lore = config.getStringList("crate2_lore");
    public static final List<String> getCrate3Lore = config.getStringList("crate3_lore");
    public static final List<String> getCrate4Lore = config.getStringList("crate4_lore");
    public static final List<String> getCrate5Lore = config.getStringList("crate5_lore");
    public static final List<String> getCrate6Lore = config.getStringList("crate6_lore");
    public static final List<String> getCrate7Lore = config.getStringList("crate7_lore");
    public static final List<String> getCrate8Lore = config.getStringList("crate8_lore");
    public static final List<String> getCrate9Lore = config.getStringList("crate9_lore");
    public static final List<String> getCrate10Lore = config.getStringList("crate10_lore");

    /**
     * - VERY IMPORTANT -
     * Create different PlayerProfile for each crate to give unique name/UUID for each crate to make mineable/retrievable
     */
    public static PlayerProfile getCrate1Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate1fishcrate".getBytes()), "crate1fishcrate");
    }

    public static PlayerProfile getCrate2Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate2fishcrate".getBytes()), "crate2fishcrate");
    }

    public static PlayerProfile getCrate3Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate3fishcrate".getBytes()), "crate3fishcrate");
    }

    public static PlayerProfile getCrate4Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate4fishcrate".getBytes()), "crate4fishcrate");
    }

    public static PlayerProfile getCrate5Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate5fishcrate".getBytes()), "crate5fishcrate");
    }

    public static PlayerProfile getCrate6Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate6fishcrate".getBytes()), "crate6fishcrate");
    }

    public static PlayerProfile getCrate7Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate7fishcrate".getBytes()), "crate7fishcrate");
    }

    public static PlayerProfile getCrate8Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate8fishcrate".getBytes()), "crate8fishcrate");
    }

    public static PlayerProfile getCrate9Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate9fishcrate".getBytes()), "crate9fishcrate");
    }

    public static PlayerProfile getCrate10Profile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("crate10fishcrate".getBytes()), "crate10fishcrate");
    }
}
