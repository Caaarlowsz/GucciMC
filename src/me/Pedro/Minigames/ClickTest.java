package me.Pedro.Minigames;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import me.Pedro.Eventos.KitAPI;

public class ClickTest implements CommandExecutor, Listener {
	public static ArrayList<Player> sela;
	public static ClickTest m;

	static {
		ClickTest.sela = new ArrayList<Player>();
	}

	public ClickTest(final GucciPvP main) {
	}

	public static ClickTest getMain() {
		return ClickTest.m;
	}

	@EventHandler
	public void bater(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (ClickTest.sela.contains(p) && e.getAction() == Action.LEFT_CLICK_AIR) {
			p.setLevel(p.getLevel() + 1);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) GucciPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							if (ClickTest.sela.contains(p)) {
								ClickTest.sela.remove(p);
								p.sendMessage(String.valueOf(GucciPvP.p) + "�7Voc\u00ea fez " + p.getLevel()
										+ " clicks em 10 segundos");
								p.sendMessage(String.valueOf(GucciPvP.p) + "�7Voc\u00ea fez em media " + p.getLevel() / 10
										+ "  clicks por segundo!");
								p.getInventory().clear();
								KitAPI.setitem(p, Material.BOOK, "�3�lMenu", 3, Enchantment.SILK_TOUCH, 0, false);
								KitAPI.setitem(p, Material.COMPASS, "�3�lWarps", 5, Enchantment.SILK_TOUCH, 0, false);
								KitAPI.setitem(p, Material.CHEST, "�3�lKits", 4, Enchantment.SILK_TOUCH, 0, false);
								p.teleport(p.getWorld().getSpawnLocation());
								if (p.getLevel() >= 200) {
									p.setBanned(true);
								}
							}
						}
					}, 200L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) GucciPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.setLevel(0);
							ClickTest.sela.remove(p);
						}
					}, 260L);
		}
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		if (sender instanceof Player && cmd.getName().equalsIgnoreCase("clicktest")) {
			final Player p = (Player) sender;
			p.setLevel(0);
			p.setGameMode(GameMode.SURVIVAL);
			p.getInventory().clear();
			p.sendMessage(String.valueOf(GucciPvP.p) + "�7O ClickTeste ir\u00e1 come\u00e7ar em 5 segundos");
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) GucciPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(
									String.valueOf(GucciPvP.p) + "�7O ClickTeste ir\u00e1 come\u00e7ar em 4 segundos");
						}
					}, 20L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) GucciPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(
									String.valueOf(GucciPvP.p) + "�7O ClickTeste ir\u00e1 come\u00e7ar em 3 segundos");
						}
					}, 40L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) GucciPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(
									String.valueOf(GucciPvP.p) + "�7O ClickTeste ir\u00e1 come\u00e7ar em 2 segundos");
						}
					}, 60L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) GucciPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage(String.valueOf(GucciPvP.p) + "�7O ClickTeste ir\u00e1 come\u00e7ar em 1 segundo");
						}
					}, 80L);
			Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin) GucciPvP.instance,
					(Runnable) new Runnable() {
						@Override
						public void run() {
							p.sendMessage("  ");
							p.sendMessage("  ");
							p.sendMessage(String.valueOf(GucciPvP.p) + "�7O ClickTeste Come\u00e7ou");
							p.sendMessage(String.valueOf(GucciPvP.p) + "�7�7Apenas os Clicks no Ar Ser\u00e3o Contados");
							p.sendMessage("  ");
							p.sendMessage("  ");
							ClickTest.sela.add(p);
						}
					}, 100L);
		}
		return false;
	}
}
