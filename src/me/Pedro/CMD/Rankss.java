package me.Pedro.CMD;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Rankss implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel, final String[] args) {
        final Player player = (Player)sender;
        if (commandLabel.equalsIgnoreCase("ranks")) {
            player.sendMessage("");
            player.sendMessage("§3§lRANKS");
            player.sendMessage("");
            player.sendMessage("§fUnranked (§7\u268a§f)");
            player.sendMessage("§aPrimary §f(§a\u268c§f)");
            player.sendMessage("§eAdvanced §f(§e\u2630§f)");
            player.sendMessage("§bDiamond §f(§b\u2739§f)");
            player.sendMessage("§cMaster §f(§c\u273a§f)");
            player.sendMessage("§4Legendary §f(§4\u272a§f)");
            player.sendMessage("");
            return true;
        }
        return false;
    }
}
