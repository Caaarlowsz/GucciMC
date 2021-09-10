package me.Pedro.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.Pedro.Main;

public class SetSkit implements Listener, CommandExecutor {
	public static Main plugin;

	public SetSkit(final Main main) {
		SetSkit.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setskit") && sender instanceof Player) {
			if (!sender.hasPermission("kitpvp.setskit")) {
				final Player p = (Player) sender;
				p.sendMessage(Main.semperm);
			}
			if (sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				SetSkit.plugin.getConfig().set("skit.x", (Object) p.getLocation().getX());
				SetSkit.plugin.getConfig().set("skit.y", (Object) p.getLocation().getY());
				SetSkit.plugin.getConfig().set("skit.z", (Object) p.getLocation().getZ());
				SetSkit.plugin.getConfig().set("skit.pitch", (Object) p.getLocation().getPitch());
				SetSkit.plugin.getConfig().set("skit.yaw", (Object) p.getLocation().getYaw());
				SetSkit.plugin.getConfig().set("skit.world", (Object) p.getLocation().getWorld().getName());
				SetSkit.plugin.saveConfig();
				p.sendMessage(String.valueOf(Main.p) + "§7Warp §b§lSKIT §7setada com §3sucesso!");
			}
			return true;
		}
		return false;
	}
}
