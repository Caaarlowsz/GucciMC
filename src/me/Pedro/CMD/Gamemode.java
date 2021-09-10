package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage("§bPrecisa ser um Player para usar esse comando");
			return true;
		}
		final Player player = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("gm") || cmd.getName().equalsIgnoreCase("gamemode")) {
			if (player.hasPermission("cmd.admin")) {
				if (args.length != 1) {
					player.sendMessage("§3§lGAMEMODE §fExpecifique um gamemode!");
					return true;
				}
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("0")) {
						player.setGameMode(GameMode.SURVIVAL);
						player.sendMessage("§3§lGAMEMODE §fGamemode Alterado!");
					}
					if (args[0].equalsIgnoreCase("1")) {
						player.setGameMode(GameMode.CREATIVE);
						player.sendMessage("§3§lGAMEMODE §fGamemode Alterado!");
						for (int j = (Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
						}
					}
				}
			}
		} else {
			player.sendMessage(ChatColor.RED + "§3§lGAMEMODE §fSem permissao para isso.");
		}
		return false;
	}
}
