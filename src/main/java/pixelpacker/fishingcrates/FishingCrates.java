package pixelpacker.fishingcrates;

import org.bukkit.configuration.Configuration;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import pixelpacker.fishingcrates.handlers.BlockBreakHandler;
import pixelpacker.fishingcrates.handlers.FishingHandler;
import pixelpacker.fishingcrates.handlers.ItemDropHandler;
import pixelpacker.fishingcrates.util.ConfigUtil;

public final class FishingCrates extends JavaPlugin {



    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        FishingHandler fishingHandler = new FishingHandler(this);
        ItemDropHandler itemDropHandler = new ItemDropHandler(this);
        BlockBreakHandler blockBreakHandler = new BlockBreakHandler(this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
