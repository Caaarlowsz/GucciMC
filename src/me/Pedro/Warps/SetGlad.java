package me.Pedro.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class SetGlad implements Listener, CommandExecutor {
	public static GucciPvP plugin;

	public SetGlad(final GucciPvP main) {
		SetGlad.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setglad") && sender instanceof Player) {
			if (!sender.hasPermission("glad.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(GucciPvP.semperm);
			}
			if (sender.hasPermission("glad.setwarp")) {
				final Player p = (Player) sender;
				SetGlad.plugin.getConfig().set("glad.x", (Object) p.getLocation().getX());
				SetGlad.plugin.getConfig().set("glad.y", (Object) p.getLocation().getY());
				SetGlad.plugin.getConfig().set("glad.z", (Object) p.getLocation().getZ());
				SetGlad.plugin.getConfig().set("glad.pitch", (Object) p.getLocation().getPitch());
				SetGlad.plugin.getConfig().set("glad.yaw", (Object) p.getLocation().getYaw());
				SetGlad.plugin.getConfig().set("glad.world", (Object) p.getLocation().getWorld().getName());
				SetGlad.plugin.saveConfig();
				p.sendMessage(String.valueOf(GucciPvP.p) + "�7Warp glad setada com sucesso");
			}
			return true;
		}
		return false;
	}
}
