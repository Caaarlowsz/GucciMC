package me.Pedro.Eventos;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Sign;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Placas implements Listener {
	@EventHandler
	public void placadesopa(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("sopas")) {
			e.setLine(0, "                ");
			e.setLine(1, "§b§lFANNT");
			e.setLine(3, "    §bSopas     ");
		}
	}

	@EventHandler
	public void clicarnaplacadesopa(final PlayerInteractEvent e) {
		if (e.getAction() == Action.RIGHT_CLICK_BLOCK && (e.getClickedBlock().getType() == Material.SIGN
				|| e.getClickedBlock().getType() == Material.SIGN_POST
				|| e.getClickedBlock().getType() == Material.WALL_SIGN)) {
			final Sign sign = (Sign) e.getClickedBlock().getState();
			if (sign.getLine(1).equals("§b§lFANNT")) {
				final Inventory inv = Bukkit.createInventory((InventoryHolder) null, 54, "§bSopas");
				final ItemStack Sopa = new ItemStack(Material.MUSHROOM_SOUP);
				final ItemMeta SopaMeta = Sopa.getItemMeta();
				SopaMeta.setDisplayName("§bSopas");
				Sopa.setItemMeta(SopaMeta);
				for (int i = 0; i < 54; ++i) {
					inv.addItem(new ItemStack[] { new ItemStack(Sopa) });
				}
				e.getPlayer().openInventory(inv);
			}
		}
	}
}
