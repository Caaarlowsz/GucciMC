package me.Pedro.CMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class Youtuber implements Listener, CommandExecutor {
	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		cmd.getName().equalsIgnoreCase("youtuber");
		p.sendMessage("§a§l*  §b§lYOUTUBER");
		p.sendMessage("§a§l*  §3§lREQUISITOS");
		p.sendMessage("                                                        ");
		p.sendMessage("§a§l* §f500 inscritos, ");
		p.sendMessage("§a§l* §fFeedback bom");
		p.sendMessage("§a§l* §f1 v\u00eddeo no nosso servidor!");
		p.sendMessage("                                                        ");
		p.sendMessage("§b§lYT §f" + p.getName());
		p.sendMessage("§a§l*  §6§lPRO");
		p.sendMessage("§a§l*  §3§lREQUISITOS");
		p.sendMessage("§a§l* §f100 inscritos,");
		p.sendMessage("§a§l* §fFeedback bom");
		p.sendMessage("§a§l* §f1 v\u00eddeo no servidor.");
		p.sendMessage("§6§lPRO §f" + p.getName());
		return false;
	}
}
