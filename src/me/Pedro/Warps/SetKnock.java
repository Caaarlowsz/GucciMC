package me.Pedro.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class SetKnock implements CommandExecutor, Listener {
	public static GucciPvP plugin;

	public SetKnock(final GucciPvP main) {
		SetKnock.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setknock") && sender instanceof Player) {
			if (!sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(GucciPvP.semperm);
			}
			if (sender.hasPermission("kitpvp.setwarp")) {
				final Player p2 = (Player) sender;
				SetKnock.plugin.getConfig().set("knock.x", (Object) p2.getLocation().getX());
				SetKnock.plugin.getConfig().set("knock.y", (Object) p2.getLocation().getY());
				SetKnock.plugin.getConfig().set("knock.z", (Object) p2.getLocation().getZ());
				SetKnock.plugin.getConfig().set("knock.pitch", (Object) p2.getLocation().getPitch());
				SetKnock.plugin.getConfig().set("knock.yaw", (Object) p2.getLocation().getYaw());
				SetKnock.plugin.getConfig().set("knock.world", (Object) p2.getLocation().getWorld().getName());
				SetKnock.plugin.saveConfig();
				p2.sendMessage(String.valueOf(GucciPvP.p) + "�7Warp Knock setada com sucesso");
			}
		}
		return false;
	}
}
