package me.Pedro.Warps;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class SetRdm implements Listener, CommandExecutor {
	public static GucciPvP plugin;

	public SetRdm(final GucciPvP main) {
		SetRdm.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setrdm") && sender instanceof Player) {
			if (!sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(GucciPvP.semperm);
			}
			if (sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				SetRdm.plugin.getConfig().set("rdm.x", (Object) p.getLocation().getX());
				SetRdm.plugin.getConfig().set("rdm.y", (Object) p.getLocation().getY());
				SetRdm.plugin.getConfig().set("rdm.z", (Object) p.getLocation().getZ());
				SetRdm.plugin.getConfig().set("rdm.pitch", (Object) p.getLocation().getPitch());
				SetRdm.plugin.getConfig().set("rdm.yaw", (Object) p.getLocation().getYaw());
				SetRdm.plugin.getConfig().set("rdm.world", (Object) p.getLocation().getWorld().getName());
				SetRdm.plugin.saveConfig();
				p.sendMessage(String.valueOf(GucciPvP.p) + "�7Warp �b�lRDM �7setada com sucesso");
			}
			return true;
		}
		return false;
	}
}
