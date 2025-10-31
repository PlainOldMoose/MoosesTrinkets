package me.plainoldmoose.command;

import me.plainoldmoose.trinket.Trinket;
import me.plainoldmoose.trinket.TrinketManager;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.xml.transform.OutputKeys;
import java.util.List;

public class TrinketCommandHandler implements CommandExecutor, TabCompleter {

    private final String USAGE = "Usage: /trinkets <give> <player> <trinket_name>";

    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {
        if (!(commandSender instanceof Player)) {
            return true;
        }

        Player player = (Player) commandSender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + USAGE);
            return true;
        }

        switch (args[0].toLowerCase()) {
            case "give":
                handleGive(player, args);
                return true;
            default:
                player.sendMessage(ChatColor.RED + USAGE);
                return true;
        }
    }

    private void handleGive(Player player, String[] args) {
        if (args.length != 2) {
            player.sendMessage(ChatColor.RED + USAGE);
            return;
        }

        TrinketManager tm = TrinketManager.getInstance();
        player.getInventory().addItem(tm.get(args[1]).getItem());
//        player.give(tm.get(args[1]).getItem()); - not supported by MockBukkit for testing
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
