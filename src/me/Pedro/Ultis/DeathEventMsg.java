package me.Pedro.Ultis;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathEventMsg implements Listener {
	@EventHandler
	public void MsgDeath(final PlayerDeathEvent e) {
		e.setDeathMessage((String) null);
	}
}
