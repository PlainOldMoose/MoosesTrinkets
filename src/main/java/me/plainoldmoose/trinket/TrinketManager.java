package me.plainoldmoose.trinket;

import org.bukkit.Material;

import java.util.HashMap;

public class TrinketManager {
    private static TrinketManager instance = new TrinketManager();
    private HashMap<String, Trinket> trinkets = new HashMap<>();

    private TrinketManager() {
        trinkets.clear();
        trinkets.put("hello", new Trinket("hello", Material.DIAMOND));
    }

    public static TrinketManager getInstance() {
        return instance;
    }

    public void add(Trinket t) {
        trinkets.put(t.getDisplayName(), t);
    }

    public Trinket get(String trinket) {
        return trinkets.get(trinket);
    }
}
