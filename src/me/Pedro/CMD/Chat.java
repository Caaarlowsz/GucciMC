package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Pedro.Main;

public class Chat implements CommandExecutor, Listener {
	public static boolean c;

	static {
		Chat.c = false;
	}

	public Chat(final Main main) {
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("Chat")) {
			if (!p.hasPermission("kitpvp.Chat")) {
				p.sendMessage("§cVoc\u00ea n\u00e3o possui permiss\u00e3o para executar este comando.");
				return true;
			}
			if (Args.length == 0) {
				p.sendMessage("§9§lCHAT §7- §fComando inv\u00e1lido ou voc\u00ea n\u00e3o possu\u00ed permiss\u00e3o.");
				return true;
			}
			if (Args[0].equalsIgnoreCase("Off")) {
				Chat.c = true;
				p.sendMessage("§cVoc\u00ea desativou o chat global!");
				Bukkit.broadcastMessage("§9§lCHAT §7- §fO chat est\u00e1 §3desativo.");
			}
			if (Args[0].equalsIgnoreCase("On")) {
				Chat.c = false;
				p.sendMessage("§aVoc\u00ea ativou o chat global! ");
				Bukkit.broadcastMessage("§9§lCHAT §7- §fO chat est\u00e1 §3ativo.");
			}
		}
		return false;
	}

	@EventHandler
	public void naoFalarNoChatQuandoTiverOFF(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (!p.hasPermission("bits.falarChat") && Chat.c) {
			e.setCancelled(true);
			p.sendMessage("§9§lCHAT §7- §fO chat est\u00e1 §3desativo.");
		}
	}
}
