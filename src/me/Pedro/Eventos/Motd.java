package me.Pedro.Eventos;

import org.bukkit.event.EventHandler;
import me.Pedro.Main;
import org.bukkit.event.server.ServerListPingEvent;
import org.bukkit.event.Listener;

public class Motd implements Listener
{
    @EventHandler
    public void Motd(final ServerListPingEvent e) {
        e.setMotd(Main.getInstance().getConfig().getString("motd").replace("&", "§"));
    }
}
