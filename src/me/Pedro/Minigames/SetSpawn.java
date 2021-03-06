package me.Pedro.Minigames;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class SetSpawn implements CommandExecutor {
	public static GucciPvP plugin;

	public SetSpawn(final GucciPvP main) {
		SetSpawn.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("setspawn") && sender instanceof Player) {
			if (!sender.hasPermission("kitpvp.setwarp")) {
				final Player p = (Player) sender;
				p.sendMessage(GucciPvP.semperm);
			}
			if (sender.hasPermission("kitpvp.setwarp")) {
				final Player p2 = (Player) sender;
				SetSpawn.plugin.getConfig().set("spawn.x", (Object) p2.getLocation().getX());
				SetSpawn.plugin.getConfig().set("spawn.y", (Object) p2.getLocation().getY());
				SetSpawn.plugin.getConfig().set("spawn.z", (Object) p2.getLocation().getZ());
				SetSpawn.plugin.getConfig().set("spawn.pitch", (Object) p2.getLocation().getPitch());
				SetSpawn.plugin.getConfig().set("spawn.yaw", (Object) p2.getLocation().getYaw());
				SetSpawn.plugin.getConfig().set("spawn.world", (Object) p2.getLocation().getWorld().getName());
				SetSpawn.plugin.saveConfig();
				p2.sendMessage(String.valueOf(GucciPvP.p) + "�7Spawn setada com sucesso");
				p2.getWorld().setSpawnLocation(p2.getLocation().getBlockX(), p2.getLocation().getBlockY(),
						p2.getLocation().getBlockZ());
			}
			return false;
		}
		return false;
	}
}
