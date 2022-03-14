package me.Pedro.Inventarios;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class Ranks implements Listener {
	public Ranks(final GucciPvP main) {
	}

	public Ranks() {
	}

	public static void guiKits(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 27, "�aRanks");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
		final ItemMeta metav = vidro.getItemMeta();
		vidro.setItemMeta(metav);
		final ItemStack warp = new ItemStack(Material.COAL);
		final ItemMeta warpv = warp.getItemMeta();
		warpv.setDisplayName("�fUnranked");
		warp.setItemMeta(warpv);
		inv.setItem(10, warp);
		final ItemStack warp2 = new ItemStack(Material.IRON_INGOT);
		final ItemMeta warpv2 = warp2.getItemMeta();
		warpv2.setDisplayName("�7�lPrata");
		warp2.setItemMeta(warpv2);
		inv.setItem(11, warp2);
		final ItemStack warp3 = new ItemStack(Material.GOLD_INGOT);
		final ItemMeta warpv3 = warp3.getItemMeta();
		warpv3.setDisplayName("�e�lOuro");
		warp3.setItemMeta(warpv3);
		inv.setItem(12, warp3);
		final ItemStack warp4 = new ItemStack(Material.NETHER_BRICK_ITEM);
		final ItemMeta warpv4 = warp4.getItemMeta();
		warpv4.setDisplayName("�a�lPlatina");
		warp4.setItemMeta(warpv4);
		inv.setItem(14, warp4);
		final ItemStack warp5 = new ItemStack(Material.DIAMOND);
		final ItemMeta warpv5 = warp5.getItemMeta();
		warpv5.setDisplayName("�b�lDiamante");
		warp5.setItemMeta(warpv5);
		inv.setItem(15, warp5);
		final ItemStack warp6 = new ItemStack(Material.EMERALD);
		final ItemMeta warp2v = warp6.getItemMeta();
		warp2v.setDisplayName("�c�lEsmeralda");
		warp6.setItemMeta(warp2v);
		inv.setItem(16, warp6);
		p.openInventory(inv);
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		if (e.getInventory().getTitle().equalsIgnoreCase("�aRanks") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
		}
	}
}
