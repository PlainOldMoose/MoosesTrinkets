package me.plainoldmoose.command;

import me.plainoldmoose.trinket.Trinket;
import me.plainoldmoose.trinket.TrinketManager;
import org.bukkit.entity.Player;

public class TrinketCommandActualiser {
    public void giveTrinket(Player player, String[] args) {

        // -> /trinkets give xyz - if 2 args are not supplied, command was wrong
        if (args.length != 2) {
            return;
        }

        String trinketName = args[1];

        Trinket trinket = TrinketManager.getInstance().get(trinketName);

        if (trinket == null) {
            player.sendMessage("Unknown Trinket: " + trinketName);
            return;
        }

        player.getInventory().addItem(trinket.getItem());
//        player.give(tm.get(args[1]).getItem()); - not supported by MockBukkit for testing
        player.sendMessage("You've been given " + trinketName);
    }
}
