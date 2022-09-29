package pixelpacker.fishingcrates.commands;

import org.bukkit.Location;
import org.bukkit.Server;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.profile.PlayerProfile;
import pixelpacker.fishingcrates.FishingCrates;
import pixelpacker.fishingcrates.items.CrateItems;

import java.net.MalformedURLException;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GiveCrate implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        ItemStack basicCrate;
        ItemStack notBasicCrate;
        try {
            basicCrate = CrateItems.getBasicCrate(sender.getServer());
            notBasicCrate = CrateItems.getNotBasicCrate(sender.getServer());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        List<String> commandInput = Arrays.stream(args).toList();
        String crateInput = commandInput.get(1).toLowerCase(Locale.ROOT), playerName = commandInput.get(0);
        int numberOfCrates = 1;
        if(commandInput.size() == 3){
             numberOfCrates = Integer.parseInt(commandInput.get(2));
        }
        Player player = FishingCrates.getPlugin(FishingCrates.class).getServer().getPlayer(playerName);
        if(player != null){
            Location targetPlayerLocation = player.getLocation();
            switch (crateInput) {
                case ("basiccrate") -> {
                    sender.sendMessage("Gave " + playerName + " Basic Crate");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 1){
                        player.getInventory().addItem(basicCrate);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(basicCrate);
                            i++;
                        }
                    }
                    return true;
                }
                case ("notbasiccrate") -> {
                    sender.sendMessage("Gave " + playerName + " Not Basic Crate");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(notBasicCrate);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(notBasicCrate);
                            i++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
