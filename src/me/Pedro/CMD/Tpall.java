package me.Pedro.CMD;

import org.bukkit.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Tpall implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        final Player p = (Player)sender;
        if (commandLabel.equalsIgnoreCase("teleportall") && p.hasPermission("cmd.admin")) {
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, k = 0; k < length; ++k) {
                final Player s = onlinePlayers[k];
                s.sendMessage("§9§lTELEPORT §fTodos os jogadores do servidor foram teleportados at\u00e9 " + p.getName());
            }
            Player[] arrayOfPlayer;
            for (int j = (arrayOfPlayer = Bukkit.getServer().getOnlinePlayers()).length, i = 0; i < j; ++i) {
                final Player all = arrayOfPlayer[i];
                all.teleport((Entity)p);
            }
        }
        return false;
    }
}
