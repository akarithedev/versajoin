package dev.ayame.versajoin.events;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import dev.ayame.versajoin.VersaJoin;
import dev.ayame.versajoin.handlers.dataHandler;
import org.bukkit.entity.Player;
public class PlayerJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(final PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission("versajoin.format.staff")) {
            dataHandler.INSTANCE.runTask(() -> player.getServer().broadcastMessage(dataHandler.INSTANCE.getPAPIMessage(player, dataHandler.INSTANCE.getConfig("chat.format.staff.join_message", true).toString())));
        }
        if(player.hasPermission("versajoin.format.donator")) {
            dataHandler.INSTANCE.runTask(() -> player.getServer().broadcastMessage(dataHandler.INSTANCE.getPAPIMessage(player, dataHandler.INSTANCE.getConfig("chat.format.donator.join_message", true).toString())));
        }
    }
}
