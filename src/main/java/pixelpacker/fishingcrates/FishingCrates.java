package pixelpacker.fishingcrates;

import org.bukkit.plugin.java.JavaPlugin;
import pixelpacker.fishingcrates.commands.GiveCrate;
import pixelpacker.fishingcrates.handlers.BlockBreakHandler;
import pixelpacker.fishingcrates.handlers.FishingHandler;
import pixelpacker.fishingcrates.handlers.ItemDropHandler;

public final class FishingCrates extends JavaPlugin {

    @Override
    public void onEnable() {
        saveDefaultConfig();
        // Plugin startup logic
        getCommand("givecrate").setExecutor(new GiveCrate());
        FishingHandler fishingHandler = new FishingHandler(this);
        ItemDropHandler itemDropHandler = new ItemDropHandler(this);
        BlockBreakHandler blockBreakHandler = new BlockBreakHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
