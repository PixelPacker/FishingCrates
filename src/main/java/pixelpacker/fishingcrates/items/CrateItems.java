package pixelpacker.fishingcrates.items;

import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.profile.PlayerProfile;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class CrateItems {
    public List<String> Basic_Crate_Lore = Arrays.asList(
            "A basic crate.",
            "Drop this to open up what's inside."
    );

    public ItemStack getBasicCrate(Server server) throws MalformedURLException {

        ItemStack item = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) item.getItemMeta();
        meta.setDisplayName("Basic Crate");
        meta.setLore(Basic_Crate_Lore);
        PlayerProfile profile = meta.getOwnerProfile();
        if(profile == null){
            profile = server.createPlayerProfile(UUID.nameUUIDFromBytes("FishCratePlugin".getBytes()), "FishCratePlugin");
        }
        profile.getTextures().setSkin(new URL("https://textures.minecraft.net/texture/e34a3619dc66fc5f940f69aa331e588b5285f6e2e9981b8f93b99916c294b48"));
        meta.setOwnerProfile(profile);
        item.setItemMeta(meta);

        return item;
    }
}
