import me.plainoldmoose.trinket.Trinket;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class TrinketTest {

    Trinket t;

    @BeforeEach
    void setup() {
        t = new Trinket();
    }

    @Test
    void trinketConstructionTest() {
        assertNotNull(t);
    }
}
