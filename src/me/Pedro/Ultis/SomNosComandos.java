package me.Pedro.Ultis;

import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class SomNosComandos implements Listener {
	@EventHandler
	public void digitarComando(final PlayerCommandPreprocessEvent a) {
		final float tmp17_16 = 1.0f;
		a.getPlayer().playSound(a.getPlayer().getLocation(), Sound.LEVEL_UP, tmp17_16, tmp17_16);
	}
}
