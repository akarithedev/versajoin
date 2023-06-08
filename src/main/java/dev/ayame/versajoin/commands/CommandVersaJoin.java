package dev.ayame.versajoin.commands;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.ayame.versajoin.handlers.dataHandler;
import dev.ayame.versajoin.VersaJoin;
public class CommandVersaJoin implements CommandExecutor {
    @SuppressWarnings("deprecated")
    @Override
    public boolean onCommand(CommandSender sender, @org.jetbrains.annotations.NotNull Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("versajoin")) {
            if(args.length > 0) {
                if(args[0].equals("reload")) {
                    if(sender instanceof Player) {
                        Player player = (Player) sender;
                        if(player.hasPermission("versajoin.admin")) {
                            dataHandler.INSTANCE.updateConfig();
                            player.sendMessage("§fConfiguration file has been reloaded");
                        } else {
                            player.sendMessage("§cI'm sorry but you cannot use this command.");
                        }
                    } else {
                        dataHandler.INSTANCE.updateConfig();
                        sender.sendMessage("§fConfiguration file has been reloaded");
                    }
                } else if(args[0].equals("version")) {
                    if(sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage("§fYou are running version §b" + VersaJoin.INSTANCE.getDescription().getVersion() + "§fof versajoin");
                    } else {
                        sender.sendMessage("§fYou are running version §b" + VersaJoin.INSTANCE.getDescription().getVersion() + "§fof versajoin");

                    }
                } else {
                    if (sender instanceof Player) {
                        Player player = (Player) sender;
                        player.sendMessage("§fAvailable commands:\n§b/versajoin - §fShows this message\n§b/versajoin reload - §fReloads the plugin\n§b/versajoin version - §fGet the version of the plugin");
                    } else {
                        sender.sendMessage("§fAvailable commands:\n§b/versajoin - §fShows this message\n§b/versajoin reload - §fReloads the plugin\n§b/versajoin version - §fGet the version of the plugin");

                    }
                }
            }
        }
        return true;
    }
}
