package pixelpacker.fishingcrates;

import org.bukkit.plugin.java.JavaPlugin;
import pixelpacker.fishingcrates.handlers.FishingHandler;
import pixelpacker.fishingcrates.handlers.ItemDropHandler;

public final class FishingCrates extends JavaPlugin {
    @Override
    public void onEnable() {
        // Plugin startup logic
        FishingHandler fishingHandler = new FishingHandler(this);
        ItemDropHandler itemDropHandler = new ItemDropHandler(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
