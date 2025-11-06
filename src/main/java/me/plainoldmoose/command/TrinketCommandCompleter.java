package me.plainoldmoose.command;

import me.plainoldmoose.trinket.TrinketManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class TrinketCommandCompleter implements TabCompleter {

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] args) {


        if (args.length == 1) {
            List<String> completions = new ArrayList<>();
            completions.add("give");

            return completions;
        }

        if (args.length == 2) {
            if (args[0].equalsIgnoreCase("give")) {
                return TrinketManager.getInstance().getTrinketNameList();
            }
        }

        return new ArrayList<>();
    }
}
