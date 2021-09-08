package me.Pedro.CMD;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Aplicar implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel, final String[] args) {
        final Player player = (Player)sender;
        if (commandLabel.equalsIgnoreCase("aplicar")) {
            player.sendMessage("");
            player.sendMessage("        §3§lAPLICAR");
            player.sendMessage("");
            player.sendMessage("      §d§lTrialModerador");
            player.sendMessage("§a§l* §fTer no min\u00edmo 13 anos,");
            player.sendMessage("§a§l* §fFormalidade, respeito e \u00e9tica.");
            player.sendMessage("§a§l* §fFidelidade, e fieldade.");
            player.sendMessage("§a§l* §fConhecer sobre hacks.");
            player.sendMessage("§a§l* §fTer um meio de contato.");
            player.sendMessage("");
            player.sendMessage("§a§l* §fhttps://goo.gl/QsGpaU");
            return true;
        }
        return false;
    }
}
