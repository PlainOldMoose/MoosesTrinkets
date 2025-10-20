package Trinket;

import me.plainoldmoose.MoosesTrinkets;
import me.plainoldmoose.command.TrinketCommandHandler;
import org.bukkit.plugin.Plugin;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;
import org.mockbukkit.mockbukkit.ServerMock;
import org.mockbukkit.mockbukkit.command.CommandMapMock;
import org.mockbukkit.mockbukkit.entity.PlayerMock;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void TrinketCommandTest() {
        assertNotNull(server.getPluginCommand("trinket"));
//        boolean result = tch.onCommand(player, server.getPluginCommand("trinket"), "trinkets", new String[]{}
//        );
//
//        assertTrue(result);
    }
}
