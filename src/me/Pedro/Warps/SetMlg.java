package me.Pedro.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import me.Pedro.Main;

public class SetMlg implements CommandExecutor, Listener {
	public static Main plugin;

	public SetMlg(final Main main) {
		SetMlg.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setmlg") && sender instanceof Player) {
			if (!sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(Main.semperm);
			}
			if (sender.hasPermission("kitpvp.setwarp")) {
				final Player p2 = (Player) sender;
				SetMlg.plugin.getConfig().set("mlg.x", (Object) p2.getLocation().getX());
				SetMlg.plugin.getConfig().set("mlg.y", (Object) p2.getLocation().getY());
				SetMlg.plugin.getConfig().set("mlg.z", (Object) p2.getLocation().getZ());
				SetMlg.plugin.getConfig().set("mlg.pitch", (Object) p2.getLocation().getPitch());
				SetMlg.plugin.getConfig().set("mlg.yaw", (Object) p2.getLocation().getYaw());
				SetMlg.plugin.getConfig().set("mlg.world", (Object) p2.getLocation().getWorld().getName());
				SetMlg.plugin.saveConfig();
				p2.sendMessage(String.valueOf(Main.p) + "§7Warp MLG setada com sucesso");
			}
		}
		return false;
	}
}
