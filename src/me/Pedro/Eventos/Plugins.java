package me.Pedro.Eventos;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class Plugins implements Listener {
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onCommandPreProcess(final PlayerCommandPreprocessEvent e) {
		final String[] msg = e.getMessage().split(" ");
		final List<String> plugins = new ArrayList<String>();
		plugins.add("pl");
		plugins.add("plugin");
		plugins.add("ver" + msg);
		plugins.add("help" + msg);
		plugins.add("ver");
		plugins.add("help");
		plugins.add("?");
		plugins.add("me");
		plugins.add("calc");
		plugins.add("about");
		plugins.add("bukkit:help");
		plugins.add("plugins");
		plugins.add("minecraft:me");
		for (final String Loop : plugins) {
			if (msg[0].equalsIgnoreCase("/" + Loop)) {
				e.getPlayer().sendMessage("          §c§lERROR");
				e.getPlayer().sendMessage("§fTodos plugins foram desenvolvidos para o servidor!");
				e.getPlayer().sendMessage(
						"§fDireitos autorais, direitos de autor. Qualquer uso deste plugin em outro local, ser\u00e1 processado.");
				e.setCancelled(true);
			}
		}
	}
}
