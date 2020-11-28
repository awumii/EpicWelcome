package me.xneox.epicwelcome;

import me.xneox.epicwelcome.command.EpicWelcomeCommand;
import me.xneox.epicwelcome.listener.PlayerJoinListener;
import me.xneox.epicwelcome.listener.PlayerQuitListener;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class EpicWelcomePlugin extends JavaPlugin {

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        PluginCommand command = this.getCommand("epicwelcome");
        if (command != null) {
            command.setExecutor(new EpicWelcomeCommand(this));
        } else {
            this.getLogger().severe("Could not register the command, re-download this plugin and restart the server!");
        }

        Bukkit.getPluginManager().registerEvents(new PlayerJoinListener(this), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuitListener(this), this);
    }
}
