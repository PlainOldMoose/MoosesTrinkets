import me.plainoldmoose.trinket.Trinket;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;

import static org.junit.jupiter.api.Assertions.*;

class TrinketTest {
    private ServerMock server;
    Trinket t;

    @BeforeEach
    void setUp() {
        server = MockBukkit.mock();
        t = new Trinket("trinket");
    }

    @AfterEach
    void tearDown() {
        MockBukkit.unmock();
    }

    // Basic construction test
    @Test
    void trinketConstructionTest() {
        assertNotNull(t);
    }

    // Display name test
    @Test
    void displayNameTest() {
        t.setDisplayName("Hello World!");
        assertEquals(t.getDisplayName(), "Hello World!");
    }

    // ID test
    @Test
    void idTest() {
        t.setID(5);
        assertEquals(t.getID(), 5);
    }

    // Internal ItemStack
    @Test
    void getItemTest() {
        assertNull(t.getItem());
        ItemStack item = new ItemStack(Material.DIAMOND, 1);
        t.setItem(item);
        assertEquals(item, t.getItem());
    }

    @Test
    void isTrinketTest() {

    }
}
