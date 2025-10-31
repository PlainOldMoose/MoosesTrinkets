package Trinket;

import me.plainoldmoose.trinket.Trinket;
import me.plainoldmoose.trinket.TrinketManager;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TrinketManagerTest {
    private TrinketManager tm;
    private ServerMock server;

    @BeforeEach
    void setUp() {
        server = MockBukkit.mock();
        tm = TrinketManager.getInstance();
    }

    @AfterEach
    void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void managerConstructionTest() {
        assertNotNull(tm);
    }

    @Test
    void managerAddTest() {
        Trinket t = new Trinket("trinket", Material.DIAMOND);
        Trinket t1 = new Trinket("another_trinket", Material.DIAMOND);
        tm.add(t);
        assertEquals(t, tm.get("trinket"));
        assertNotEquals(t1, tm.get("trinket"));
    }

    @Test
    void managerNamespaceKeyTest() {
        Trinket t = new Trinket("trinket", Material.DIAMOND);
        tm.add(t);
        Trinket t1 = tm.get("trinket");
        PersistentDataContainer data = t1.getItem().getItemMeta().getPersistentDataContainer();
        assertTrue(data.has(new NamespacedKey("moosestrinkets", "trinket")));
    }
}
