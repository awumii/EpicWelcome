package me.xneox.epicwelcome.command;

import me.xneox.epicwelcome.EpicWelcomePlugin;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class EpicWelcomeCommand implements CommandExecutor {

    private final EpicWelcomePlugin plugin;

    public EpicWelcomeCommand(EpicWelcomePlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length < 1) {
            sender.sendMessage(ChatColor.DARK_AQUA + "EpicWelcome v" + this.plugin.getDescription().getVersion() + " (https://github.com/xxneox/EpicWelcome)");
            sender.sendMessage(ChatColor.WHITE + "Use" + ChatColor.BOLD + "/" + label + ChatColor.RESET + " reload to reload the configuration.");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")) {
            this.plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Configuration has been reloaded.");
        } else {
            sender.sendMessage(ChatColor.RED + "Invalid argument.");
        }
        return true;
    }
}
