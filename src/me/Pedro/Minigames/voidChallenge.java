package me.Pedro.Minigames;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.Pedro.Main;
import me.Pedro.Eventos.KitAPI;

public class voidChallenge {
	public voidChallenge(final Player p) {
		new BukkitRunnable() {
			int seconds = 5;

			public void run() {
				if (this.seconds > 0) {
					p.sendMessage(String.valueOf(Main.p) + "§7Minigame Iniciando em " + this.seconds + " segundos!");
					--this.seconds;
					return;
				}
				if (this.seconds == 0) {
					this.seconds = -1;
					p.getInventory().clear();
					p.teleport(new Location(p.getWorld(), 0.0, -5.0, 0.0));
					p.sendMessage(String.valueOf(Main.p) + "§7O Desafio come\u00e7ou!!!");
					KitAPI.sopa(p);
					KitAPI.voidChallenge.add(p.getName());
				}
				KitAPI.voidChallengeTime.put(p.getName(), voidChallenge.getTime(p) + 1);
				p.setLevel(voidChallenge.getTime(p));
				if (!KitAPI.voidChallenge.contains(p.getName()) && this.seconds < 0) {
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) Main.instance, 0L, 20L);
	}

	public static int getTime(final Player p) {
		if (!KitAPI.voidChallengeTime.containsKey(p.getName())) {
			return 0;
		}
		return KitAPI.voidChallengeTime.get(p.getName());
	}
}
