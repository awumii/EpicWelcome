package me.xneox.epicwelcome.listener;

import me.xneox.epicwelcome.EpicWelcomePlugin;
import me.xneox.epicwelcome.util.ChatUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    private final EpicWelcomePlugin plugin;

    public PlayerQuitListener(EpicWelcomePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        FileConfiguration cfg = this.plugin.getConfig();

        // Custom quit message.
        if (cfg.getBoolean("custom-quit-message")) {
            event.setQuitMessage(ChatUtils.format(cfg.getString("custom-quit-message.message"), player));
        }
    }
}
