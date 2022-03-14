package me.Pedro.ScoreBoard;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class Status implements Listener {
	public Status(final GucciPvP main) {
	}

	@EventHandler
	void aoLogar(final PlayerJoinEvent evento) {
		final Player jogador = evento.getPlayer();
		if (GucciPvP.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".kills") == null) {
			GucciPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object) 0);
			GucciPvP.plugin.saveConfig();
		}
		if (GucciPvP.plugin.getConfig().get("status." + jogador.getName().toLowerCase() + ".mortes") == null) {
			GucciPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object) 0);
			GucciPvP.plugin.saveConfig();
		}
	}

	@EventHandler
	void aoMatar(final PlayerDeathEvent evento) {
		if (evento.getEntity().getKiller() instanceof Player) {
			final Player jogador = evento.getEntity().getKiller();
			final int kills = GucciPvP.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".kills");
			GucciPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".kills", (Object) (kills + 1));
			GucciPvP.plugin.saveConfig();
		}
	}

	@EventHandler
	void aoMorrer(final PlayerDeathEvent evento) {
		if (evento.getEntity() instanceof Player) {
			final Player jogador = evento.getEntity();
			final int mortes = GucciPvP.plugin.getConfig().getInt("status." + jogador.getName().toLowerCase() + ".mortes");
			GucciPvP.plugin.getConfig().set("status." + jogador.getName().toLowerCase() + ".mortes", (Object) (mortes + 1));
			GucciPvP.plugin.saveConfig();
		}
	}
}
