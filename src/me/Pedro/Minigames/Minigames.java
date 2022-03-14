package me.Pedro.Minigames;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import me.Pedro.Eventos.KitAPI;

public class Minigames implements Listener {
	public Minigames(final GucciPvP main) {
	}

	public static void joinMinigame(final Player p, final ListGames minigame) {
		if (minigame == ListGames.voidChallenge) {
			new voidChallenge(p);
		}
		if (minigame == ListGames.refillTest) {
			new refillTest(p);
		}
	}

	@EventHandler
	public void onQuit(final PlayerQuitEvent e) {
		if (KitAPI.voidChallenge.contains(e.getPlayer().getName())) {
			KitAPI.voidChallenge.remove(e.getPlayer().getName());
			KitAPI.voidChallengeTime.remove(e.getPlayer().getName());
		}
		if (KitAPI.refillTest.contains(e.getPlayer().getName())) {
			KitAPI.refillTest.remove(e.getPlayer().getName());
			KitAPI.refillTestTime.remove(e.getPlayer().getName());
		}
	}
}
