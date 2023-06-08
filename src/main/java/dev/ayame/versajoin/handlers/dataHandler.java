package dev.ayame.versajoin.handlers;
import dev.ayame.versajoin.VersaJoin;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class dataHandler {
    private final boolean papi;
    public static dataHandler INSTANCE;
    private FileConfiguration config;
    public dataHandler() {
        INSTANCE = this;
        VersaJoin.INSTANCE.getConfig().options().copyDefaults(true);
        VersaJoin.INSTANCE.saveDefaultConfig();
        updateConfig();

        papi = VersaJoin.INSTANCE.getServer().getPluginManager().getPlugin("PlaceholderAPI") != null;

    }
    public void updateConfig() {
        VersaJoin.INSTANCE.reloadConfig();
        config = VersaJoin.INSTANCE.getConfig();
    }
    public final String getPAPIMessage(final Player player, final String query) {
        return papi ? PlaceholderAPI.setPlaceholders(player, query) : query;
    }

    public Object getConfig(final String key, final boolean translate) {
        return config.isSet(key) ? (translate ? ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(config.getString(key))).replace("%nl%", "\n") : config.get(key)) : null;
    }
    public void runTask(final Runnable runnable) {
        if (!Bukkit.isPrimaryThread()) {
            new BukkitRunnable() {

                @Override
                public void run() {
                    runnable.run();
                }
            }.runTask(VersaJoin.INSTANCE);
            return;
        }
        runnable.run();
    }

}

