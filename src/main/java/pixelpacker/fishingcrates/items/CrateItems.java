package pixelpacker.fishingcrates.items;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CrateItems {
    //ItemStacks go here
    public static ItemStack getBasicCrate(Server server) throws MalformedURLException {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName("Basic Crate");
        meta.setLore(Basic_Crate_Lore);
        PlayerProfile profile = meta.getOwnerProfile();
        if(profile == null){
            profile = getBasicCrateProfile(server);
        }
        profile.getTextures().setSkin(new URL("https://textures.minecraft.net/texture/e34a3619dc66fc5f940f69aa331e588b5285f6e2e9981b8f93b99916c294b48"));
        meta.setOwnerProfile(profile);
        item.setItemMeta(meta);

        return item;
    }

    public static ItemStack getNotBasicCrate(Server server) throws MalformedURLException {
        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName("Not Basic Crate");
        meta.setLore(Not_Basic_Crate_Lore);
        PlayerProfile profile = meta.getOwnerProfile();
        if(profile == null){
            profile = getNotBasicCrateProfile(server);
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
    public static final List<String> Basic_Crate_Lore = Arrays.asList(
            "A basic crate.",
            "Drop this to open up what's inside."
    );

    public static final List<String> Not_Basic_Crate_Lore = Arrays.asList(
            "Not a basic crate.",
            "Drop this to open up what's inside."
    );


    /**
     * - VERY IMPORTANT -
     * Create different PlayerProfile for each crate to give unique name/UUID for each crate to make mineable/retrievable
     */
    public static PlayerProfile getBasicCrateProfile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("BasicCrateFishCrate".getBytes()), "BasicCrateFishCrate");
    }

    public static PlayerProfile getNotBasicCrateProfile(Server server){
        return server.createPlayerProfile(UUID.nameUUIDFromBytes("NotBasicCrateFishCrate".getBytes()), "NotBasicCrateFishCrate");
    }
}
