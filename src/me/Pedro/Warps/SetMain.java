package me.Pedro.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class SetMain implements CommandExecutor {
	public static GucciPvP plugin;

	public SetMain(final GucciPvP main) {
		SetMain.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setmain") && sender instanceof Player) {
			if (!sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(GucciPvP.semperm);
			}
			if (sender.hasPermission("kitpvp.setwarp")) {
				final Player p2 = (Player) sender;
				SetMain.plugin.getConfig().set("main.x", (Object) p2.getLocation().getX());
				SetMain.plugin.getConfig().set("main.y", (Object) p2.getLocation().getY());
				SetMain.plugin.getConfig().set("main.z", (Object) p2.getLocation().getZ());
				SetMain.plugin.getConfig().set("main.pitch", (Object) p2.getLocation().getPitch());
				SetMain.plugin.getConfig().set("main.yaw", (Object) p2.getLocation().getYaw());
				SetMain.plugin.getConfig().set("main.world", (Object) p2.getLocation().getWorld().getName());
				SetMain.plugin.saveConfig();
				p2.sendMessage(String.valueOf(GucciPvP.p) + "�7Warp Main setada com sucesso");
			}
			return false;
		}
		return false;
	}
}
