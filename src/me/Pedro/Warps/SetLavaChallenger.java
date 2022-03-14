package me.Pedro.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class SetLavaChallenger implements CommandExecutor {
	public static GucciPvP plugin;

	public SetLavaChallenger(final GucciPvP main) {
		SetLavaChallenger.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setchallenge") && sender instanceof Player) {
			if (!sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(GucciPvP.semperm);
			}
			if (sender.hasPermission("kitpvp.setwarp")) {
				final Player p2 = (Player) sender;
				SetLavaChallenger.plugin.getConfig().set("challenge.x", (Object) p2.getLocation().getX());
				SetLavaChallenger.plugin.getConfig().set("challenge.y", (Object) p2.getLocation().getY());
				SetLavaChallenger.plugin.getConfig().set("challenge.z", (Object) p2.getLocation().getZ());
				SetLavaChallenger.plugin.getConfig().set("challenge.pitch", (Object) p2.getLocation().getPitch());
				SetLavaChallenger.plugin.getConfig().set("challenge.yaw", (Object) p2.getLocation().getYaw());
				SetLavaChallenger.plugin.getConfig().set("challenge.world",
						(Object) p2.getLocation().getWorld().getName());
				SetLavaChallenger.plugin.saveConfig();
				p2.sendMessage(String.valueOf(GucciPvP.p) + "�7Warp Challenge setada com sucesso");
			}
		}
		return false;
	}
}
