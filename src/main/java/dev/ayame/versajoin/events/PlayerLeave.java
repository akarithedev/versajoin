package dev.ayame.versajoin.events;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import dev.ayame.versajoin.VersaJoin;
import dev.ayame.versajoin.handlers.dataHandler;
import org.bukkit.entity.Player;
public class PlayerLeave implements Listener {
    @EventHandler
    public void onPlayerQuit(final PlayerQuitEvent event) {
        Player player = event.getPlayer();
        if(player.hasPermission("versajoin.format.staff")) {
            dataHandler.INSTANCE.runTask(() -> player.sendMessage(dataHandler.INSTANCE.getPAPIMessage(player, dataHandler.INSTANCE.getConfig("chat.format-messages.staff", true).toString())));
        } else if(player.hasPermission("versajoin.format.donator")) {
            dataHandler.INSTANCE.runTask(() -> player.sendMessage(dataHandler.INSTANCE.getPAPIMessage(player, dataHandler.INSTANCE.getConfig("chat.format-messages.donator", true).toString())));
        } else {
            dataHandler.INSTANCE.runTask(() -> player.sendMessage(dataHandler.INSTANCE.getPAPIMessage(player, dataHandler.INSTANCE.getConfig("chat.format-messages.default", true).toString())));

        }
    }
}

