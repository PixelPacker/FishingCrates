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
        ItemStack crate1, crate2, crate3, crate4, crate5, crate6, crate7, crate8, crate9, crate10;
        try {
            crate1 = CrateItems.getCrate1(sender.getServer());
            crate2 = CrateItems.getCrate2(sender.getServer());
            crate3 = CrateItems.getCrate3(sender.getServer());
            crate4 = CrateItems.getCrate4(sender.getServer());
            crate5 = CrateItems.getCrate5(sender.getServer());
            crate6 = CrateItems.getCrate6(sender.getServer());
            crate7 = CrateItems.getCrate7(sender.getServer());
            crate8 = CrateItems.getCrate8(sender.getServer());
            crate9 = CrateItems.getCrate9(sender.getServer());
            crate10 = CrateItems.getCrate10(sender.getServer());
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
                case ("crate1") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 1");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 1){
                        player.getInventory().addItem(crate1);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate1);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate2") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 2");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate2);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate2);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate3") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 3");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate3);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate3);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate4") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 4");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate4);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate4);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate5") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 5");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate5);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate5);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate6") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 6");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate6);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate6);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate7") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 7");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate7);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate7);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate8") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 8");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate8);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate8);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate9") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 9");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate9);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate9);
                            i++;
                        }
                    }
                    return true;
                }
                case ("crate10") -> {
                    sender.sendMessage("Gave " + playerName + " Crate 10");
                    player.playSound(targetPlayerLocation, Sound.ENTITY_ITEM_PICKUP, 1f, 1f);
                    if(numberOfCrates == 0){
                        player.getInventory().addItem(crate10);
                    }else{
                        int i = 0;
                        while(i < numberOfCrates){
                            player.getInventory().addItem(crate10);
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
