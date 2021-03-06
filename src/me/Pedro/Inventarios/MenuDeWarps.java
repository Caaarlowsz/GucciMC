package me.Pedro.Inventarios;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import me.Pedro.ScoreBoard.Habilidade;

public class MenuDeWarps implements Listener {
	public static void SetarItem(final Inventory inv, final Player p, final Material item, final int quantidade,
			final int data, final String nome, final String desc, final int slot) {
		final ItemStack icone = new ItemStack(item, quantidade, (short) data);
		final ItemMeta iconem = icone.getItemMeta();
		iconem.setDisplayName(nome);
		final ArrayList<String> lore = new ArrayList<String>();
		lore.add(desc);
		iconem.setLore(lore);
		icone.setItemMeta(iconem);
		inv.setItem(slot, icone);
	}

	public static void Warps(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, "�3�lWarps");
		SetarItem(inv, p, Material.COMPASS, 1, 0, "�b�lTREINO", "�c- �7Clique para ver as warps de treino !", 11);
		SetarItem(inv, p, Material.TRIPWIRE_HOOK, 1, 0, "�cFechar", "�c- �7Fechar o menu !", 4);
		SetarItem(inv, p, Material.CAKE, 1, 0, "�b�lEVENTOS", "�c- �7Clique para ver as warps de treino !", 15);
		p.openInventory(inv);
	}

	public static void Treino(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, "�b�lTreino");
		SetarItem(inv, p, Material.TRIPWIRE_HOOK, 1, 0, "�cVoltar", "�c- �7Voltar ao menu de warps !", 4);
		SetarItem(inv, p, Material.GLASS, 1, 0, "�b�lFps", "�c- �7Clique para ir a warp fps !", 10);
		SetarItem(inv, p, Material.POTION, 1, 0, "�b�lMain", "�c- �7Clique para ir a warp main !", 11);
		SetarItem(inv, p, Material.BEDROCK, 1, 0, "�b�lVoidChallenger", "�c- �7Clique para ir a warp void challenge!",
				11);
		SetarItem(inv, p, Material.LAVA_BUCKET, 1, 0, "�b�lLavaChallenger",
				"�c- �7Clique para ir a warp lavachallenger !", 15);
		SetarItem(inv, p, Material.BLAZE_ROD, 1, 0, "�b�l1v1", "�c- �7Clique para ir a warp 1v1 !", 16);
		SetarItem(inv, p, Material.IRON_FENCE, 1, 0, "�b�lGladiator ", "�c- �7Manuten\u00e7\u00e3o !", 22);
		p.openInventory(inv);
	}

	public static void Eventos(final Player p) {
		final Inventory inv = Bukkit.createInventory((InventoryHolder) p, 27, "�b�lEventos");
		SetarItem(inv, p, Material.TRIPWIRE_HOOK, 1, 0, "�cVoltar", "�c- �7Voltar ao menu de warps !", 4);
		SetarItem(inv, p, Material.IRON_CHESTPLATE, 1, 0, "�b�lSkit", "�c- �7Clique para ir ao evento skit !", 11);
		SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "�b�lMdr", "�c- �7Clique para ir ao evento mdr !", 15);
		SetarItem(inv, p, Material.DIAMOND_SWORD, 1, 0, "�b�lRdm", "�c- �7Clique para ir ao evento rdm !", 22);
		p.openInventory(inv);
	}

	@EventHandler
	public static void AbrirWarps(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)
				&& p.getItemInHand().getType() == Material.COMPASS
				&& Habilidade.getAbility(p).equalsIgnoreCase("Nenhum")) {
			Warps(p);
			p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
			e.setCancelled(true);
		}
	}

	@EventHandler
	public static void ClicarWarps(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("�3�lWarps")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				Warps(p);
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lTREINO")) {
				Treino(p);
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lEVENTOS")) {
				Eventos(p);
				e.setCancelled(true);
				return;
			}
			p.closeInventory();
			e.setCancelled(true);
		}
	}

	@EventHandler
	public static void ClicarTreino(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("�b�lTreino")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				Warps(p);
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
				Warps(p);
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lFps")) {
				p.chat("/fps");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lMain")) {
				p.chat("/main");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lVoidChallenger")) {
				p.chat("/void");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lLavaChallenger")) {
				p.chat("/challenge");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�l1v1")) {
				p.chat("/1v1");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			p.closeInventory();
			e.setCancelled(true);
		}
	}

	@EventHandler
	public static void ClicarEventos(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getName().equalsIgnoreCase("�b�lEventos")) {
			if (e.getCurrentItem() == null) {
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
				Warps(p);
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lMdr")) {
				p.sendMessage(String.valueOf(GucciPvP.p) + " �7Warp n\u00e3o �cencontrada �7!");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lRdm")) {
				p.sendMessage(String.valueOf(GucciPvP.p) + " �7Warp n\u00e3o �cencontrada �7!");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�b�lSkit")) {
				p.sendMessage(String.valueOf(GucciPvP.p) + " �7Warp n\u00e3o �cencontrada �7!");
				p.closeInventory();
				e.setCancelled(true);
				return;
			}
			p.closeInventory();
			e.setCancelled(true);
		}
	}
}
