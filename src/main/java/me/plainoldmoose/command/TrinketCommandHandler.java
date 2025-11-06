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

    private static final String USAGE = "Usage: /trinkets <give> <player> <trinket_name>";

    private final TrinketCommandActualiser actualiser;

    public TrinketCommandHandler(TrinketCommandActualiser actualiser) {
        this.actualiser = actualiser;
    }


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
                actualiser.giveTrinket(player, args);
                return true;
            default:
                player.sendMessage(ChatColor.RED + USAGE);
                return true;
        }
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {
        return List.of();
    }
}
