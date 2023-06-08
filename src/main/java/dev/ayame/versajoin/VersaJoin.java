package dev.ayame.versajoin;

import org.bukkit.plugin.java.JavaPlugin;
import dev.ayame.versajoin.handlers.dataHandler;
import dev.ayame.versajoin.commands.*;
import dev.ayame.versajoin.events.PlayerJoin;
import dev.ayame.versajoin.events.PlayerLeave;
import java.util.Objects;

public final class VersaJoin extends JavaPlugin {
    public static VersaJoin INSTANCE;
    @Override
    public void onEnable() {
        INSTANCE = this;
        new dataHandler();
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        Objects.requireNonNull(getCommand("versajoin")).setExecutor(new CommandVersaJoin());
        getLogger().info("Loading config...");
        getLogger().info("Config loaded");
        getLogger().info("The plugin is now enabled");
    }

    @Override
    public void onDisable() {
        getLogger().info("Unloading commands and config");
        getLogger().info("Plugin is now disabled");
    }
}
