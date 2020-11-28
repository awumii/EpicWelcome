package me.xneox.epicwelcome.util;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public final class ChatUtils {

    public static String format(String string, Player player) {
        return ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, string));
    }

    private ChatUtils() {}
}
