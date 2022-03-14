package me.Pedro.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Material;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class Sopa implements Listener {
	public Sopa(final GucciPvP main) {
	}

	@EventHandler
	public void AoTomarSopa(final PlayerInteractEvent e) {
		final ItemStack pote = new ItemStack(Material.BOWL, 1);
		final ItemMeta kpote = pote.getItemMeta();
		kpote.setDisplayName("�8Pote");
		pote.setItemMeta(kpote);
		final Damageable hp;
		final Player p = (Player) (hp = (Damageable) e.getPlayer());
		if (hp.getHealth() != 20.0) {
			final int sopa = 7;
			if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
					&& p.getItemInHand().getTypeId() == 282) {
				p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
				if (!KitAPI.QuickDropper.contains(p.getName())) {
					p.getItemInHand().setItemMeta(kpote);
					p.getItemInHand().setType(Material.BOWL);
				} else {
					p.getItemInHand().setType(Material.BOWL);
					p.getPlayer().getInventory().remove(p.getItemInHand());
					p.getInventory().remove(new ItemStack(Material.BOWL, 1));
					p.getWorld().dropItemNaturally(p.getLocation(), new ItemStack(Material.BOWL));
					p.updateInventory();
				}
			}
		}
	}

	@EventHandler
	public void onItemDrop(final ItemSpawnEvent e) {
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(GucciPvP.plugin, (Runnable) new Runnable() {
			@Override
			public void run() {
				e.getEntity().remove();
				e.getLocation().getWorld().playEffect(e.getEntity().getLocation(), Effect.SMOKE, 10);
			}
		}, 10L);
	}
}
