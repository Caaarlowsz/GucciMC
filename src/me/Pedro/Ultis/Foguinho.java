package me.Pedro.Ultis;

import java.util.Iterator;
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

public class Foguinho implements Listener
{
    @EventHandler
    public void stomperApple(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.MAGMA_CREAM && KitAPI.Foguinho.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Tempo.cadd(p)) {
                p.sendMessage("§7Voce esta em §cCooldown §a" + Tempo.time(p) + "s");
                return;
            }
            final Location loc = p.getLocation();
            Raios.arround(p.getLocation());
            Tempo.add(p, 25);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Foguinho.Foguinho$1(this, p), 0L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Foguinho.Foguinho$2(this, p), 100L);
        }
    }
    
    @EventHandler
    public void fraqueza(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.Foguinho1.contains(p.getName())) {
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (pertos instanceof Player) {
                    final Player perto = (Player)pertos;
                    ((Player)pertos).setFireTicks(150);
                    p.getKiller();
                    ((Player)pertos).getKiller();
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Foguinho.Foguinho$3(this), 100L);
                }
            }
        }
    }
}
