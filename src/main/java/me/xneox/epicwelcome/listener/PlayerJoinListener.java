package me.xneox.epicwelcome.listener;

import me.xneox.epicwelcome.EpicWelcomePlugin;
import me.xneox.epicwelcome.util.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private final EpicWelcomePlugin plugin;

    public PlayerJoinListener(EpicWelcomePlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        FileConfiguration cfg = this.plugin.getConfig();

        // Custom join message.
        if (cfg.getBoolean("custom-join-message.enabled")) {
            event.setJoinMessage(ChatUtils.format(cfg.getString("custom-join-message.message"), player));
        }

        // Custom join motd.
        if (cfg.getBoolean("join-motd.enabled")) {
            player.sendMessage(ChatUtils.format(cfg.getString("join-motd.message"), player));
        }

        // Annoucing the first join.
        if (!player.hasPlayedBefore() && cfg.getBoolean("annouce-first-join.enabled")) {
            Bukkit.broadcastMessage(ChatUtils.format(cfg.getString("annouce-first-join.message"), player));
        }

        // Custom join actionbar
        if (cfg.getBoolean("join-actionbar.enabled")) {
            if (player.hasPlayedBefore()) {
                player.sendActionBar(ChatUtils.format(cfg.getString("join-actionbar.existing-players"), player));
            } else {
                player.sendActionBar(ChatUtils.format(cfg.getString("join-actionbar.new-players"), player));
            }
        }

        // Custom join title (that's a lot of lines :P )
        if (cfg.getBoolean("join-title.enabled")) {
            if (player.hasPlayedBefore()) {
                player.sendTitle(
                        ChatUtils.format(cfg.getString("join-title.existing-players.title"), player),
                        ChatUtils.format(cfg.getString("join-title.existing-players.subtitle"), player),
                        cfg.getInt("join-title.time.fade-in"),
                        cfg.getInt("join-title.time.fade-out"),
                        cfg.getInt("join-title.time.stay"));
            } else {
                player.sendTitle(
                        ChatUtils.format(cfg.getString("join-title.new-players.title"), player),
                        ChatUtils.format(cfg.getString("join-title.new-players.subtitle"), player),
                        cfg.getInt("join-title.time.fade-in"),
                        cfg.getInt("join-title.time.fade-out"),
                        cfg.getInt("join-title.time.stay"));
            }
        }
    }
}
