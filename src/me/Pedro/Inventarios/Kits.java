package me.Pedro.Inventarios;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class Kits implements Listener, CommandExecutor {
	public Kits(final GucciPvP main) {
	}

	public static void guiKits1(final Player p) {
		final Inventory inv = Bukkit.getServer().createInventory((InventoryHolder) p, 54, "�b�lKITS");
		final ItemStack vidro = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) 4);
		final ItemMeta metav = vidro.getItemMeta();
		metav.setDisplayName("");
		vidro.setItemMeta(metav);
		final ItemStack pyro2 = new ItemStack(Material.CHEST);
		final ItemMeta metapyro2 = pyro2.getItemMeta();
		metapyro2.setDisplayName("�b�lKits");
		final ArrayList<String> descpyro2 = new ArrayList<String>();
		descpyro2.add("�a�l* �fJogue com seu kit �3preferido!");
		descpyro2.add("�a�l* �fA �3habilidade �fimportante \u00e9 a sua.");
		metapyro2.setLore(descpyro2);
		pyro2.setItemMeta(metapyro2);
		inv.setItem(4, pyro2);
		final ItemStack pyro3 = new ItemStack(Material.ENCHANTED_BOOK);
		final ItemMeta metapyro3 = pyro3.getItemMeta();
		metapyro3.setDisplayName("�e�lWarps");
		final ArrayList<String> descpyro3 = new ArrayList<String>();
		descpyro3.add("�a�l* �fJogue em sua warp �3preferida!");
		descpyro3.add("�a�l* �fTodas muito �adivertidas!");
		metapyro3.setLore(descpyro3);
		pyro3.setItemMeta(metapyro3);
		inv.setItem(3, pyro3);
		final ItemStack pyro4 = new ItemStack(Material.DIAMOND);
		final ItemMeta metapyro4 = pyro4.getItemMeta();
		metapyro4.setDisplayName("�e�lLoja");
		final ArrayList<String> descpyro4 = new ArrayList<String>();
		descpyro4.add("�a�l* �fO servidor possu\u00ed uma loja!");
		descpyro4.add("�a�l* �fwww.fannt.buycraft.net");
		metapyro4.setLore(descpyro4);
		pyro4.setItemMeta(metapyro4);
		inv.setItem(5, pyro4);
		if (p.hasPermission("kit.pvp")) {
			final ItemStack pyro5 = new ItemStack(Material.STONE_SWORD);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT PVP");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lPVP");
			descpyro5.add("�fRaridade: �7Normal");
			descpyro5.add("�fUnica �3habilidade �fdo kit \u00e9 a sua habilidade!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(22, pyro5);
		}
		if (p.hasPermission("kit.Forcefield")) {
			final ItemStack pyro5 = new ItemStack(Material.IRON_FENCE);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT FORCEFIELD");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lFORCEFIELD");
			descpyro5.add("�fRaridade: �7�lEPIC");
			descpyro5.add("�fSua �3habilidade �f\u00e9 utilizar hack por 10 segundos!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(40, pyro5);
		}
		if (p.hasPermission("kit.C4")) {
			final ItemStack pyro5 = new ItemStack(Material.SLIME_BALL);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT C4");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lC4");
			descpyro5.add("�fRaridade: �f�lEPIC");
			descpyro5.add("�fSua �3habilidade �f\u00e9 explodir a todos, sem exe\u00e7\u00e3o!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(30, pyro5);
		}
		if (p.hasPermission("kit.AVATAR")) {
			final ItemStack pyro5 = new ItemStack(Material.BEACON);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT AVATAR");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lAVATAR");
			descpyro5.add("�fRaridade: �7RARO");
			descpyro5.add("�fSua �3habilidade �f\u00e9 dominar os elementos!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(29, pyro5);
		}
		if (p.hasPermission("kit.TERRORISTA")) {
			final ItemStack pyro5 = new ItemStack(Material.MAGMA_CREAM);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT TERRORISTA");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lTERRORISTA");
			descpyro5.add("�fRaridade: �7RARO");
			descpyro5.add("�fSua �3habilidade �f\u00e9 ser um terrorista!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(32, pyro5);
		}
		if (p.hasPermission("kit.DESHFIRE")) {
			final ItemStack pyro5 = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT DESHFIRE");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lDESHFIRE");
			descpyro5.add("�fRaridade: �7EPIC");
			descpyro5.add("�fSua �3habilidade �f\u00e9 virar um FIRE!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(33, pyro5);
		}
		if (p.hasPermission("kit.WATERBENDER")) {
			final ItemStack pyro5 = new ItemStack(Material.LAPIS_BLOCK);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT WATERBENDER");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lWATERBENDER");
			descpyro5.add("�fRaridade: �7RARO");
			descpyro5.add("�fSua �3habilidade �f\u00e9 envenenar os inimigos!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(39, pyro5);
		}
		if (p.hasPermission("kit.VELOTROL")) {
			final ItemStack pyro5 = new ItemStack(Material.MINECART);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT VELOTROL");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lVELOTROL");
			descpyro5.add("�fRaridade: �7LENDARY");
			descpyro5.add("�fSua �3habilidade �f\u00e9 dar um dash e explodir seus inimigos!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(41, pyro5);
		}
		if (p.hasPermission("kit.BLOODGUN")) {
			final ItemStack pyro5 = new ItemStack(Material.WOOD_HOE);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT BLOODGUN");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lBLOODGUN");
			descpyro5.add("�fRaridade: �7OP");
			descpyro5.add("�fSua �3habilidade �f\u00e9 ter uma PISTOLA!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(42, pyro5);
		}
		if (p.hasPermission("kit.KANGAROO")) {
			final ItemStack pyro5 = new ItemStack(Material.FIREWORK);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT KANGAROO");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lKANGAROO");
			descpyro5.add("�fRaridade: �7LEGENDARY");
			descpyro5.add("�fSua �3habilidade �f\u00e9 dar v\u00e1rios dashs para se locomover rapidamente!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(31, pyro5);
		}
		if (p.hasPermission("kit.GRAPPLER")) {
			final ItemStack pyro5 = new ItemStack(Material.LEASH);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT GRAPPLER");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lGRAPPLER");
			descpyro5.add("�fRaridade: �7EPIC");
			descpyro5.add("�fSua �3habilidade �f\u00e9Se locomover rapidamente fisgando!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(49, pyro5);
		}
		if (p.hasPermission("kit.Batman")) {
			final ItemStack pyro5 = new ItemStack(Material.BLAZE_ROD);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT BATMAN");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lBATMAN");
			descpyro5.add("�fRaridade: �7OP");
			descpyro5.add("�fSua �3habilidade �f\u00e9 chamar morcegos assasinos para matar seus inimigos!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(48, pyro5);
		}
		if (p.hasPermission("kit.QuickDropper")) {
			final ItemStack pyro5 = new ItemStack(Material.BOWL);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT QUICKDROPPER");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lQUICKDROPPER");
			descpyro5.add("�fRaridade: �7Normal");
			descpyro5.add("�fSua �3habilidade �f\u00e9 fazer quickdropp para voc\u00ea!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(38, pyro5);
		}
		if (p.hasPermission("kit.FireBoost")) {
			final ItemStack pyro5 = new ItemStack(Material.BLAZE_POWDER);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT FIREBOOST");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lFIREBOOST");
			descpyro5.add("�fRaridade: �7OP");
			descpyro5.add("�fSua �3habilidade �f\u00e9 dar dashs e atingir seus inimigos com FIRE!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(47, pyro5);
		}
		if (p.hasPermission("kit.Anchor")) {
			final ItemStack pyro5 = new ItemStack(Material.ANVIL);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT ANCHOR");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lPVP");
			descpyro5.add("�fRaridade: �7OP");
			descpyro5.add("�fSua �3habilidade �f\u00e9n\u00e3o tomar repuls\u00e3o!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(51, pyro5);
		}
		if (p.hasPermission("kit.Stomper")) {
			final ItemStack pyro5 = new ItemStack(Material.IRON_BOOTS);
			final ItemMeta metapyro5 = pyro5.getItemMeta();
			metapyro5.setDisplayName("�7�lKIT STOMPER");
			final ArrayList<String> descpyro5 = new ArrayList<String>();
			descpyro5.add("�fKit: �a�lSTOMPER");
			descpyro5.add("�fRaridade: �7LEGENDARY");
			descpyro5.add("�fSua �3habilidade �f\u00e9 esmagar os outros, ser gordo tem suas vantagens!");
			metapyro5.setLore(descpyro5);
			pyro5.setItemMeta(metapyro5);
			inv.setItem(50, pyro5);
		}
		p.openInventory(inv);
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (commandLabel.equalsIgnoreCase("kits")) {
			final Player p = (Player) sender;
			guiKits1(p);
		}
		return false;
	}

	@EventHandler
	public void onPlayerCLickInventry(final InventoryClickEvent e) {
		final Player p = (Player) e.getWhoClicked();
		if (e.getInventory().getTitle().equalsIgnoreCase("�b�lKITS") && e.getCurrentItem() != null
				&& e.getCurrentItem().getTypeId() != 0) {
			e.setCancelled(true);
			if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
				e.setCancelled(true);
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT PVP")) {
				p.closeInventory();
				p.chat("/kit pvp");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT ANCHOR")) {
				p.closeInventory();
				p.chat("/kit ANCHOR");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT STOMPER")) {
				p.closeInventory();
				p.chat("/kit STOMPER");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT GRAPPLER")) {
				p.closeInventory();
				p.chat("/kit GRAPPLER");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT KANGAROO")) {
				p.closeInventory();
				p.chat("/kit KANGAROO");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT QUICKDROPPER")) {
				p.closeInventory();
				p.chat("/kit QUICKDROPPER");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT FIREBOOST")) {
				p.closeInventory();
				p.chat("/kit FIREBOOST");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT BATMAN")) {
				p.closeInventory();
				p.chat("/kit BATMAN");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT C4")) {
				p.closeInventory();
				p.chat("/kit C4");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT AVATAR")) {
				p.closeInventory();
				p.chat("/kit AVATAR");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT VELOTROL")) {
				p.closeInventory();
				p.chat("/kit VELOTROL");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT BLOODGUN")) {
				p.closeInventory();
				p.chat("/kit BLOODGUN");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT WATERBENDER")) {
				p.closeInventory();
				p.chat("/kit WATERBENDER");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT DESHFIRE")) {
				p.closeInventory();
				p.chat("/kit DESHFIRE");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT TERRORISTA")) {
				p.closeInventory();
				p.chat("/kit TERRORISTA");
				p.closeInventory();
				return;
			}
			if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("�7�lKIT FORCEFIELD")) {
				p.closeInventory();
				p.chat("/kit FORCEFIELD");
				p.closeInventory();
			}
		}
	}
}
