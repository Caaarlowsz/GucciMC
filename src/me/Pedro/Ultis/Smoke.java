package me.Pedro.Ultis;

import java.util.Iterator;
import org.bukkit.Effect;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import me.Pedro.Main;
import org.bukkit.Bukkit;
import me.Pedro.Eventos.Tempo;
import org.bukkit.event.block.Action;
import me.Pedro.Eventos.KitAPI;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.Listener;

public class Smoke implements Listener
{
    @EventHandler
    public void stomperApple(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.FLINT && KitAPI.Smoke.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Tempo.cadd(p)) {
                p.sendMessage("§7Voce esta em §cCooldown §a" + Tempo.time(p) + "s");
                return;
            }
            final Location loc = p.getLocation();
            Tempo.add(p, 30);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Smoke.Smoke$1(this, p), 0L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Smoke.Smoke$2(this, p), 100L);
        }
    }
    
    @EventHandler
    public void fraqueza(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.SMOKE1.contains(p.getName())) {
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (pertos instanceof Player) {
                    final Player perto = (Player)pertos;
                    if (KitAPI.SMOKE1.contains(p.getName())) {
                        ((Player)pertos).damage(0.0);
                    }
                    ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 200, 0));
                    ((LivingEntity)pertos).addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 200, 0));
                    p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
                    p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
                    p.getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 200, 200);
                    pertos.getWorld().playEffect(pertos.getLocation(), Effect.SMOKE, 200, 200);
                    pertos.getWorld().playEffect(pertos.getLocation(), Effect.SMOKE, 200, 200);
                    pertos.getWorld().playEffect(pertos.getLocation(), Effect.SMOKE, 200, 200);
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Smoke.Smoke$3(this), 100L);
                }
            }
        }
    }
}
