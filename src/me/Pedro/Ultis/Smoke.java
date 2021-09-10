package me.Pedro.Ultis;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import me.Pedro.Main;
import me.Pedro.Eventos.KitAPI;
import me.Pedro.Eventos.Tempo;

public class Smoke implements Listener {
	@EventHandler
	public void stomperApple(final PlayerInteractEvent event) {
		final Player p = event.getPlayer();
		if (event.getPlayer().getItemInHand().getType() == Material.FLINT
				&& KitAPI.Smoke.contains(event.getPlayer().getName())) {
			if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK
					|| event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
				event.setCancelled(true);
			}
			if (Tempo.cadd(p)) {
				p.sendMessage("§7Voce esta em §cCooldown §a" + Tempo.time(p) + "s");
				return;
			}
			Tempo.add(p, 30);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.SMOKE1.add(p.getName());
					p.sendMessage("§7Voce ativou sua habilidade");
					p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 200, 0));
					p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 200, 0));
					p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
					p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
					p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
				}
			}, 0L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable) new Runnable() {
				@Override
				public void run() {
					KitAPI.SMOKE1.remove(p.getName());
				}
			}, 100L);
		}
	}

	@EventHandler
	public void fraqueza(final PlayerMoveEvent event) {
		final Player p = event.getPlayer();
		if (KitAPI.SMOKE1.contains(p.getName())) {
			for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
				if (pertos instanceof Player) {
					if (KitAPI.SMOKE1.contains(p.getName())) {
						((Player) pertos).damage(0.0);
					}
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
					((LivingEntity) pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
					p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
					p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
					p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
					pertos.getWorld().playEffect(pertos.getLocation(), Effect.SMOKE, 200, 200);
					pertos.getWorld().playEffect(pertos.getLocation(), Effect.SMOKE, 200, 200);
					pertos.getWorld().playEffect(pertos.getLocation(), Effect.SMOKE, 200, 200);
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
