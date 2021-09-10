package me.Pedro.Eventos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.Pedro.Main;

public class KitAPI implements Listener {
	public static ArrayList<String> Foguinho1;
	public static ArrayList<String> Foguinho;
	public static ArrayList<String> SMOKE1;
	public static ArrayList<String> Smoke;
	public static ArrayList<String> Stomper;
	public static ArrayList<String> Anchor;
	public static ArrayList<String> FireBoost;
	public static ArrayList<String> Batman;
	public static ArrayList<String> QuickDropper;
	public static ArrayList<String> Kangaroo;
	public static ArrayList<String> Grappler;
	public static ArrayList<String> BloodGun;
	public static ArrayList<String> Velotrol;
	public static ArrayList<String> DeshFire;
	public static ArrayList<String> WaterBender;
	public static ArrayList<String> Terrorista;
	public static List<Player> Tempo;
	public static ArrayList<String> Avatar2;
	public static ArrayList<String> Terra;
	public static ArrayList<String> Ferro;
	public static ArrayList<String> Red;
	public static ArrayList<String> avatar;
	public static ArrayList<String> C4;
	public static ArrayList<String> Forcefield;
	public static ArrayList<String> Forcefielddano;
	public static ArrayList<String> Kit;
	public static ArrayList<String> voidChallenge;
	public static ArrayList<String> TellReceber;
	public static HashMap<String, Integer> voidChallengeTime;
	public static ArrayList<String> refillTest;
	public static HashMap<String, Integer> refillTestTime;

	static {
		KitAPI.Foguinho1 = new ArrayList<String>();
		KitAPI.Foguinho = new ArrayList<String>();
		KitAPI.SMOKE1 = new ArrayList<String>();
		KitAPI.Smoke = new ArrayList<String>();
		KitAPI.Stomper = new ArrayList<String>();
		KitAPI.Anchor = new ArrayList<String>();
		KitAPI.FireBoost = new ArrayList<String>();
		KitAPI.Batman = new ArrayList<String>();
		KitAPI.QuickDropper = new ArrayList<String>();
		KitAPI.Kangaroo = new ArrayList<String>();
		KitAPI.Grappler = new ArrayList<String>();
		KitAPI.BloodGun = new ArrayList<String>();
		KitAPI.Velotrol = new ArrayList<String>();
		KitAPI.DeshFire = new ArrayList<String>();
		KitAPI.WaterBender = new ArrayList<String>();
		KitAPI.Terrorista = new ArrayList<String>();
		KitAPI.Tempo = new ArrayList<Player>();
		KitAPI.Avatar2 = new ArrayList<String>();
		KitAPI.Terra = new ArrayList<String>();
		KitAPI.Ferro = new ArrayList<String>();
		KitAPI.Red = new ArrayList<String>();
		KitAPI.avatar = new ArrayList<String>();
		KitAPI.C4 = new ArrayList<String>();
		KitAPI.Forcefield = new ArrayList<String>();
		KitAPI.Forcefielddano = new ArrayList<String>();
		KitAPI.Kit = new ArrayList<String>();
		KitAPI.voidChallenge = new ArrayList<String>();
		KitAPI.TellReceber = new ArrayList<String>();
		KitAPI.voidChallengeTime = new HashMap<String, Integer>();
		KitAPI.refillTest = new ArrayList<String>();
		KitAPI.refillTestTime = new HashMap<String, Integer>();
	}

	public KitAPI(final Main main) {
	}

	public static void remove(final Player p) {
		KitAPI.Kit.remove(p.getName());
		KitAPI.BloodGun.remove(p.getName());
		KitAPI.Velotrol.remove(p.getName());
		KitAPI.DeshFire.remove(p.getName());
		KitAPI.WaterBender.remove(p.getName());
		KitAPI.Grappler.remove(p.getName());
		KitAPI.Kangaroo.remove(p.getName());
		KitAPI.Forcefield.remove(p.getName());
		KitAPI.Forcefielddano.remove(p.getName());
		KitAPI.C4.remove(p.getName());
		KitAPI.Tempo.remove(p);
		KitAPI.Terrorista.remove(p.getName());
		KitAPI.Anchor.remove(p.getName());
		KitAPI.Stomper.remove(p.getName());
		KitAPI.Foguinho.remove(p.getName());
		KitAPI.Foguinho1.remove(p.getName());
		KitAPI.avatar.remove(p.getName());
		KitAPI.QuickDropper.remove(p.getName());
		KitAPI.FireBoost.remove(p.getName());
		KitAPI.Batman.remove(p.getName());
		KitAPI.Smoke.remove(p.getName());
		KitAPI.SMOKE1.remove(p.getName());
		KitAPI.voidChallengeTime.remove(p.getName());
		KitAPI.voidChallenge.remove(p.getName());
	}

	public static void sopa(final Player p) {
		final ItemStack sopa = new ItemStack(Material.MUSHROOM_SOUP);
		final ItemMeta ksopa = sopa.getItemMeta();
		ksopa.setDisplayName("§bSopa");
		sopa.setItemMeta(ksopa);
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
		p.getInventory().addItem(new ItemStack[] { sopa });
	}

	public static void GiveKit(final Player p) {
		setitem(p, Material.STONE_SWORD, "§5§lMY NAME IS COMBO", 0, Enchantment.DAMAGE_ALL, 0, false);
		final ItemStack espada1 = new ItemStack(Material.COMPASS);
		final ItemMeta kespada1 = espada1.getItemMeta();
		kespada1.setDisplayName("§bBussola");
		espada1.setItemMeta(kespada1);
		p.getInventory().setItem(8, espada1);
		final ItemStack sopas = new ItemStack(Material.BOWL, 64);
		final ItemMeta ksopas = sopas.getItemMeta();
		sopas.setItemMeta(ksopas);
		final ItemStack cogur = new ItemStack(Material.RED_MUSHROOM, 64);
		final ItemMeta kcogur = cogur.getItemMeta();
		cogur.setItemMeta(kcogur);
		final ItemStack cogum = new ItemStack(Material.BROWN_MUSHROOM, 64);
		final ItemMeta kcogum = cogum.getItemMeta();
		cogum.setItemMeta(kcogum);
		p.getInventory().setItem(13, sopas);
		p.getInventory().setItem(14, cogur);
		p.getInventory().setItem(15, cogum);
	}

	public static void setitem(final Player p, final Material mat, final String nome, final int lugar,
			final Enchantment enchant, final int level, final boolean trueorfalse) {
		final ItemStack item = new ItemStack(mat);
		final ItemMeta itemmeta = item.getItemMeta();
		itemmeta.setDisplayName(nome);
		itemmeta.addEnchant(enchant, level, trueorfalse);
		item.setItemMeta(itemmeta);
		p.getInventory().setItem(lugar, item);
	}

	public static String getkit(final Player t) {
		return null;
	}

	public static void RemoveKit(final Player p) {
	}
}
