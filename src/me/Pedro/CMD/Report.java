package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Report implements CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (label.equalsIgnoreCase("report")) {
			if (args.length == 0) {
				p.sendMessage("§3§lREPORT §7- §fUtilize /report {nick} {motivo}");
				return true;
			}
			if (args.length == 1) {
				p.sendMessage("§3§lREPORT §7- §fUtilize /report {nick} {motivo}");
				return true;
			}
			if (args.length >= 2) {
				final String alvo = args[0];
				final Player target = Bukkit.getPlayer(alvo);
				if (target == null) {
					p.sendMessage("§3§lREPORT §7- §fJOGADOR N\u00c3O ENCONTRADO!");
					return true;
				}
				final StringBuilder sb = new StringBuilder();
				for (int i = 1; i < args.length; ++i) {
					sb.append(args[i]);
					if (i < args.length) {
						sb.append(" ");
					}
				}
				p.sendMessage("§3§lREPORT §7- §fREALIZADO!");
				Player[] arrayOfPlayer;
				for (int j = (arrayOfPlayer = Bukkit.getOnlinePlayers()).length, k = 0; k < j; ++k) {
					final Player staff = arrayOfPlayer[k];
					if (staff.hasPermission("kitpvp.staff") || staff.isOp()) {
						staff.sendMessage("§3§lREPORT          ");
						staff.sendMessage("§fVit\u00edma: §a" + p.getName());
						staff.sendMessage("§fSuspeito: §c" + target.getName());
						staff.sendMessage("§fMotivo: §4" + sb.toString());
						staff.playSound(staff.getLocation(), Sound.CHICKEN_HURT, 10.0f, 1.0f);
					}
				}
			}
		}
		return false;
	}
}
