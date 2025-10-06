package me.plainoldmoose.trinket;

import java.util.HashMap;

public class TrinketManager {
    private static TrinketManager instance = new TrinketManager();

    private TrinketManager() {
    }

    public static TrinketManager getInstance() {
        return instance;
    }

    private HashMap<String, Trinket> trinkets = new HashMap<>();

    public void add(Trinket t) {
        trinkets.put(t.getDisplayName(), t);
    }

    public Trinket get(String trinket) {
        return trinkets.get(trinket);
    }
}
