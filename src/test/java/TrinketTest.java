import me.plainoldmoose.trinket.Trinket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TrinketTest {
    Trinket t;

    @BeforeEach
    void setup() {
        t = new Trinket();
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
}
