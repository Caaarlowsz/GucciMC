package me.Pedro.Eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;

import me.Pedro.Main;

public class Motd implements Listener {
	@EventHandler
	public void motd(final ServerListPingEvent e) {
		e.setMotd(Main.getInstance().getConfig().getString("motd").replace("&", "§"));
	}
}
