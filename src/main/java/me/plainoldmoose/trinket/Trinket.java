package me.plainoldmoose.trinket;

/**
 * Represents a Trinket.
 * A trinket is a essentially a modified ItemStack that provides the user with certain buffs when equipped.
 */
public class Trinket {
    private String displayName;
    private int id;

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
}
