package me.plainoldmoose;

import me.plainoldmoose.command.TrinketCommandActualiser;
import me.plainoldmoose.command.TrinketCommandHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class MoosesTrinkets extends JavaPlugin {

    public static MoosesTrinkets getInstance() {
        return getPlugin(MoosesTrinkets.class);
    }

    @Override
    public void onEnable() {
        getCommand("trinkets").setExecutor(new TrinketCommandHandler(new TrinketCommandActualiser()));

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
