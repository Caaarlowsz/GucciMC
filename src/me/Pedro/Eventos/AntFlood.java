package me.Pedro.Eventos;

import java.util.HashMap;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import me.Pedro.Main;

public class AntFlood implements Listener {
	public static HashMap<Player, Long> chat;

	static {
		AntFlood.chat = new HashMap<Player, Long>();
	}

	public AntFlood(final Main main) {
	}

	@EventHandler(priority = EventPriority.HIGHEST, ignoreCancelled = false)
	public void aAntiSpam(final AsyncPlayerChatEvent e) {
		final Player p = e.getPlayer();
		if (!AntFlood.chat.containsKey(p)) {
			final long time = System.currentTimeMillis() + 2000L;
			if (p.hasPermission("kitpvp.flood")) {
				return;
			}
			AntFlood.chat.put(p, time);
		} else if (AntFlood.chat.get(p) <= System.currentTimeMillis()) {
			if (p.hasPermission("kitpvp.flood")) {
				return;
			}
			final long time = System.currentTimeMillis() + 2000L;
			AntFlood.chat.put(p, time);
		} else {
			if (AntFlood.chat.get(p) < System.currentTimeMillis() || p.hasPermission("kitpvp.flood")) {
				return;
			}
			p.sendMessage(String.valueOf(String.valueOf("§b§lFANNT§c§lKITS")) + " §7» §aDigite mais devagar!");
			e.setCancelled(true);
		}
	}
}
