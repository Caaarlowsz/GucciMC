package me.Pedro.Minigames;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import me.Pedro.Eventos.KitAPI;

public class refillTest {
	Random rand;

	public refillTest(final Player p) {
		this.rand = new Random();
		if (KitAPI.refillTest.contains(p.getName())) {
			p.sendMessage(String.valueOf(GucciPvP.p) + "�7Voc\u00ea k\u00e1 est\u00e1 em um treino");
			return;
		}
		new BukkitRunnable() {
			int seconds = 5;

			public void run() {
				if (this.seconds > 0) {
					p.sendMessage(String.valueOf(GucciPvP.p) + "�7Minigame Iniciando em " + this.seconds + " segundos!");
					--this.seconds;
					return;
				}
				if (this.seconds == 0) {
					this.seconds = -1;
					p.getInventory().clear();
					p.sendMessage(String.valueOf(GucciPvP.p) + "�7O Desafio �cCome\u00e7ou!!");
					KitAPI.refillTest.add(p.getName());
					KitAPI.refillTestTime.put(p.getName(), refillTest.this.getTime(p) + 1);
					final ItemStack sopa = Methodos.itemStack(Material.MUSHROOM_SOUP, "�aSopa");
					final int r = refillTest.this.rand.nextInt(16);
					Methodos.fillLinhaInventory((Inventory) p.getInventory(), r + 9, sopa, sopa, sopa, sopa, sopa, sopa,
							sopa, sopa, sopa);
				}
				KitAPI.refillTestTime.put(p.getName(), refillTest.this.getTime(p) + 1);
				p.setLevel(refillTest.this.getTime(p));
				if (refillTest.this.hasRefiled(p)) {
					p.setExp(0.0f);
					p.sendMessage(String.valueOf(GucciPvP.p) + "�7Voc\u00ea terminou seu refiltest , ele foi feito em �c"
							+ Stringtimer.timerChecker(KitAPI.refillTestTime.get(p.getName())));
					KitAPI.setitem(p, Material.WATCH, "�c�lMiniGames", 0, Enchantment.ARROW_DAMAGE, 0, false);
					KitAPI.setitem(p, Material.PAPER, "�c�lWarps", 1, Enchantment.ARROW_DAMAGE, 0, false);
					KitAPI.setitem(p, Material.ANVIL, "�c�lRanks", 3, Enchantment.ARROW_DAMAGE, 0, false);
					KitAPI.setitem(p, Material.CHEST, "�c�lKits", 4, Enchantment.ARROW_DAMAGE, 0, false);
					KitAPI.setitem(p, Material.STORAGE_MINECART, "�c�lCaixas", 5, Enchantment.ARROW_DAMAGE, 0, false);
					KitAPI.setitem(p, Material.EMERALD, "�c�lLoja", 7, Enchantment.ARROW_DAMAGE, 0, false);
					KitAPI.setitem(p, Material.SKULL_ITEM, "�c�lStatus", 8, Enchantment.ARROW_DAMAGE, 0, false);
					p.teleport(p.getWorld().getSpawnLocation());
					KitAPI.refillTest.remove(p.getName());
					KitAPI.refillTestTime.remove(p.getName());
					this.cancel();
					return;
				}
				if (!KitAPI.refillTest.contains(p.getName()) && this.seconds < 0) {
					this.cancel();
				}
				if (this.seconds >= 60) {
					p.sendMessage(String.valueOf(GucciPvP.p)
							+ "�7Se passou 1 minuto e voc\u00ea n\u00e3o terminou o refil , teste cancelado");
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) GucciPvP.instance, 0L, 20L);
	}

	private int getTime(final Player p) {
		if (!KitAPI.refillTestTime.containsKey(p.getName())) {
			return 0;
		}
		return KitAPI.refillTestTime.get(p.getName());
	}

	private boolean hasRefiled(final Player p) {
		try {
			if (p.getInventory().getItem(0).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(1).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(2).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(3).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(4).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(5).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(6).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(7).getType() == Material.AIR) {
				return false;
			}
			if (p.getInventory().getItem(8).getType() == Material.AIR) {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
