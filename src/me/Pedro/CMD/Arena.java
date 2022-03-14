package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class Arena implements CommandExecutor, Listener {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String arg2, final String[] args) {
		final Player p = (Player) sender;
		if (p.hasPermission("kitpvp.admin") && cmd.getName().equalsIgnoreCase("arena")) {
			if (args.length == 0) {
				p.sendMessage(String.valueOf(GucciPvP.p) + " �7Use /�3Arena �7(�3nick�7) !");
			}
			if (args.length == 1) {
				final Player o = Bukkit.getPlayer(args[0]);
				if (o != null) {
					o.getLocation().add(0.0, 13.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 11.0, 1.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 11.0, -1.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(-1.0, 11.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.getLocation().add(0.0, 10.0, 0.0).getBlock().setType(Material.BEDROCK);
					o.teleport(o.getLocation().add(0.0, 11.0, -0.05));
					p.sendMessage(String.valueOf(GucciPvP.p) + " �7O jogador: �b" + o.getName()
							+ " �7foi preso com �asucesso �7!");
					for (int j = (Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
						p.sendMessage(" ");
					}
				}
			}
		}
		return false;
	}
}
