package me.Pedro.Eventos;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Ip implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel, final String[] args) {
        final Player player = (Player)sender;
        if (commandLabel.equalsIgnoreCase("Ip")) {
            player.sendMessage(ChatColor.GREEN + "A conex\u00e3o, IP do servidor atual: " + ChatColor.GRAY + "fanntmc.mcbr.com.br");
            return true;
        }
        return false;
    }
}
