package me.Pedro.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.entity.Damageable;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.event.block.Action;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import me.Pedro.Main;
import org.bukkit.event.Listener;

public class Sopa implements Listener
{
    public Sopa(final Main main) {
    }
    
    @EventHandler
    public void AoTomarSopa(final PlayerInteractEvent e) {
        final ItemStack pote = new ItemStack(Material.BOWL, 1);
        final ItemMeta kpote = pote.getItemMeta();
        kpote.setDisplayName("�8Pote");
        pote.setItemMeta(kpote);
        final Damageable hp;
        final Player p = (Player)(hp = (Damageable)e.getPlayer());
        if (hp.getHealth() != 20.0) {
            final int sopa = 7;
            if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getTypeId() == 282) {
                p.setHealth((hp.getHealth() + sopa > hp.getMaxHealth()) ? hp.getMaxHealth() : (hp.getHealth() + sopa));
                if (!KitAPI.QuickDropper.contains(p.getName())) {
                    p.getItemInHand().setItemMeta(kpote);
                    p.getItemInHand().setType(Material.BOWL);
                }
                else {
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
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Sopa.Sopa$1(this, e), 10L);
    }
}