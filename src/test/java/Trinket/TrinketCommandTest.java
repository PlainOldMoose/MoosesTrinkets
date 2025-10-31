package Trinket;

import me.plainoldmoose.MoosesTrinkets;
import me.plainoldmoose.command.TrinketCommandHandler;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;
import org.mockbukkit.mockbukkit.entity.PlayerMock;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class TrinketCommandTest {
    TrinketCommandHandler tch = new TrinketCommandHandler();
    private ServerMock server;
    private PlayerMock player;
    private Plugin plugin;


    @BeforeEach
    void setup() {
        server = MockBukkit.mock();
        plugin = MockBukkit.load(MoosesTrinkets.class);
        player = server.addPlayer();
    }

    @AfterEach
    void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void TrinketCommandExists() {
        assertNotNull(server.getPluginCommand("trinkets"));
    }

    @Test
    void TrinketCommandRunTest() {
        boolean result = tch.onCommand(player, server.getPluginCommand("trinkets"), "trinkets", new String[]{}
        );

        assertTrue(result);
    }

    @Test
    void TrinketGiveCommandTest() {
        tch.onCommand(player, server.getPluginCommand("trinkets"), "trinkets", new String[]{"give", "hello"}); // Mock the player issuing /trinkets give hello

        // Check inventory was given an item
        Inventory inv = player.getInventory();
        assertFalse(inv.isEmpty());

        // Check item belongs to moosestrinkets
        ItemStack i = inv.getItem(0);
        PersistentDataContainer data = i.getItemMeta().getPersistentDataContainer();
        assertTrue(data.has(new NamespacedKey("moosestrinkets", "hello")));
    }
}