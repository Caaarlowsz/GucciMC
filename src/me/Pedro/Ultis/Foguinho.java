package me.Pedro.Ultis;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;

import me.Pedro.Main;
import me.Pedro.Eventos.KitAPI;
import me.Pedro.Eventos.Tempo;

public class Foguinho implements Listener {
	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.MAGMA_CREAM
				&& KitAPI.Foguinho.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Tempo.cadd(p)) {
				p.sendMessage("§7Voce esta em §cCooldown §a" + Tempo.time(p) + "s");
				return;
			}
			Raios.arround(p.getLocation());
			Tempo.add(p, 25);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.Foguinho1.add(p.getName());
					p.sendMessage("§7Voce ativou sua habilidade");
					Raios.arround(p.getLocation());
					p.getKiller();
				}
			}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.Foguinho1.remove(p.getName());
					Raios.arround(p.getLocation());
					p.getKiller();
				}
			}, 100L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (KitAPI.Foguinho1.contains(p.getName())) {
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					((Player) pertos).setFireTicks(150);
					p.getKiller();
					((Player) pertos).getKiller();
					Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
						@Override
						public void run() {
						}
					}, 100L);
				}
			}
		}
	}
}
