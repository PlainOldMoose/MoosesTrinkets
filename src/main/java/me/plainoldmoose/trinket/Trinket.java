package me.plainoldmoose.trinket;

import me.plainoldmoose.MoosesTrinkets;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

/**
 * Represents a Trinket.
 * A trinket is a essentially a modified ItemStack that provides the user with certain buffs when equipped.
 */
public class Trinket {
    private String displayName;
    private NamespacedKey key;
    private int id;
    private ItemStack item;

    public Trinket(String displayName, Material baseMaterial) {
        this.displayName = displayName;
        this.key = new NamespacedKey("moosestrinkets", displayName);
        this.item = applyNamespaceKey(displayName, baseMaterial);
    }

    private ItemStack applyNamespaceKey(String displayName, Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer data = meta.getPersistentDataContainer();

        data.set(key, PersistentDataType.STRING, displayName);
        item.setItemMeta(meta);
        return item;
    }

    public NamespacedKey getKey() {
        return key;
    }

    /**
     * Sets display name.
     *
     * @param displayName the display name
     */
    public void setDisplayName(String displayName) {

        this.displayName = displayName;
    }

    /**
     * Gets display name.
     *
     * @return the display name
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setID(int id) {
        this.id = id;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getID() {
        return id;
    }

    public ItemStack getItem() {
        return item;
    }

    public void setItem(ItemStack item) {
        this.item = item;
    }
}
