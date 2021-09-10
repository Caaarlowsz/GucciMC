package me.Pedro.Eventos;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.Pedro.ScoreBoard.Habilidade;

public class KillEvent implements Listener {
	@EventHandler
	public void Matan\u00e7a(final PlayerDeathEvent e) {
		final Player p = e.getEntity();
		if (e.getEntity().getKiller() instanceof Player) {
			final Player t = p.getKiller();
			KitAPI.RemoveKit(p);
			e.setDeathMessage((String) null);
			p.sendMessage("§3§lKILL §fVoce morreu para " + t.getDisplayName());
			t.sendMessage("§3§lKILL §fVoce matou " + p.getDisplayName());
		} else {
			KitAPI.RemoveKit(p);
			Habilidade.setAbility(p, "Nenhum");
			e.setDeathMessage((String) null);
			p.sendMessage("§3§lKILL §fVoc\u00ea morreu");
		}
	}
}
