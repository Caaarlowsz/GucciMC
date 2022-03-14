package me.Pedro.Eventos;

import java.sql.SQLException;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import ca.wacos.nametagedit.NametagAPI;
import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import me.Pedro.Inventarios.Kits;
import me.Pedro.Inventarios.Ranks;
import me.Pedro.ScoreBoard.ScoreboardLibs;
import ru.tehkode.permissions.bukkit.PermissionsEx;

public class Players implements Listener {

	static {
	}

	public Players(final GucciPvP main) {
	}

	@EventHandler
	public void join(final PlayerJoinEvent e) {
		final Player p = e.getPlayer();
		e.setJoinMessage((String) null);
		p.getInventory().clear();
		p.teleport(p.getWorld().getSpawnLocation());
		KitAPI.remove(p);
		p.getInventory().clear();
		ScoreboardLibs.iniciarScoreboard(p);
		TheTitle.sendTitle(p, "�3�lFannt�f�lMC");
		TheTitle.sendSubTitle(p, "�7Bem vindo - �c" + p.getName());
		p.sendMessage("  �3�lFannt�f�lMC  ");
		p.sendMessage("");
		p.sendMessage("�7Bem vindo ao nosso servidor!");
		p.sendMessage("�7Todo trabalho, pela sua divers\u00e3o.");
		p.sendMessage("�7Hackers ou bugs, reporte a �3�lSTAFF.");
		p.sendMessage("");
		KitAPI.setitem(p, Material.BOOK, "�3�lMenu", 3, Enchantment.SILK_TOUCH, 0, false);
		KitAPI.setitem(p, Material.COMPASS, "�3�lWarps", 5, Enchantment.SILK_TOUCH, 0, false);
		KitAPI.setitem(p, Material.CHEST, "�3�lKits", 4, Enchantment.SILK_TOUCH, 0, false);
		if (PermissionsEx.getUser(p).inGroup("default")) {
			p.setDisplayName("�c�lNATAL �c" + p.getName());
			p.setPlayerListName("�c" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�c�lNATAL �c");
		}
		if (PermissionsEx.getUser(p).inGroup("pro")) {
			p.setDisplayName("�6�lPRO �6" + p.getName());
			p.setPlayerListName("�6" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�6�lPRO �6");
		}
		if (PermissionsEx.getUser(p).inGroup("builder")) {
			p.setDisplayName("�9�lBUILDER �9" + p.getName());
			p.setPlayerListName("�9" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�9�lBUILDER �9");
		}
		if (PermissionsEx.getUser(p).inGroup("mvp")) {
			p.setDisplayName("�9�lMVP �9" + p.getName());
			p.setPlayerListName("�9" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�9�lMVP �9");
		}
		if (PermissionsEx.getUser(p).inGroup("yt")) {
			p.setDisplayName("�b�lYT �b" + p.getName());
			p.setPlayerListName("�b" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�b�lYT �b");
		}
		if (PermissionsEx.getUser(p).inGroup("trial")) {
			p.setDisplayName("�d�lTRIAL �d" + p.getName());
			p.setPlayerListName("�d" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�d�lTRIAL �d");
		}
		if (PermissionsEx.getUser(p).inGroup("tk")) {
			p.setDisplayName("�7�lTK �7" + p.getName());
			p.setPlayerListName("�7" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�7�lTK �7");
		}
		if (PermissionsEx.getUser(p).inGroup("mod")) {
			p.setDisplayName("�5�lMOD �5" + p.getName());
			p.setPlayerListName("�5" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�5�lMOD �5");
		}
		if (PermissionsEx.getUser(p).inGroup("mod+")) {
			p.setDisplayName("�5�lMOD+ �5" + p.getName());
			p.setPlayerListName("�5" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�5�lMOD+ �5");
		}
		if (PermissionsEx.getUser(p).inGroup("ajudante")) {
			p.setDisplayName("�e�lAJUDANTE �e" + p.getName());
			p.setPlayerListName("�e" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�e�lAJUDANTE �e");
		}
		if (PermissionsEx.getUser(p).inGroup("vip")) {
			p.setDisplayName("�a�lVIP �a" + p.getName());
			p.setPlayerListName("�a" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�a�lVIP �a");
		}
		if (PermissionsEx.getUser(p).inGroup("spro")) {
			p.setDisplayName("�6�lSPRO �6" + p.getName());
			p.setPlayerListName("�6" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�6�lSPRO �6");
		}
		if (PermissionsEx.getUser(p).inGroup("dono")) {
			p.setDisplayName("�4�lDONO �4" + p.getName());
			p.setPlayerListName("�4" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�4�lDONO �4");
		}
		if (p.getName().equals("reacteey")) {
			p.setDisplayName("�3�lFUNDADOR �3" + p.getName());
			p.setPlayerListName("�3" + getShortStr(p.getName()));
			NametagAPI.setPrefix(p.getName(), "�3�lFUNDADOR �3");
		}
	}

	public void onDeath(final PlayerDeathEvent e) throws SQLException {
		e.setDeathMessage((String) null);
		final Player p = e.getEntity();
		if (p.getKiller() instanceof Player) {
			final Player k = p.getKiller();
			TheTitle.sendTitle(k, "�c�lFaant�f�lMC");
			TheTitle.sendSubTitle(k, "�7Morreu para: �c" + k.getName());
			p.sendMessage(String.valueOf(String.valueOf(GucciPvP.p)) + " �7Voc\u00ea foi �cmorto �7por: �b" + k.getName()
					+ " �7!");
			KitAPI.remove(p);
			KitAPI.Kit.remove(p.getName());
		}
	}

	@EventHandler
	public void Fome1(final FoodLevelChangeEvent e) {
		e.setCancelled(true);
		e.setFoodLevel(20);
	}

	@EventHandler
	public void resspawn(final PlayerRespawnEvent e) {
		final Player p = e.getPlayer();
		p.getInventory().clear();
		KitAPI.remove(p);
		KitAPI.setitem(p, Material.BOOK, "�3�lMenu", 3, Enchantment.SILK_TOUCH, 0, false);
		KitAPI.setitem(p, Material.COMPASS, "�3�lWarps", 5, Enchantment.SILK_TOUCH, 0, false);
		KitAPI.setitem(p, Material.CHEST, "�3�lKits", 4, Enchantment.SILK_TOUCH, 0, false);
	}

	@EventHandler
	public void quick(final PlayerQuitEvent e) {
		e.setQuitMessage((String) null);
	}

	@EventHandler
	public void abrirClassses(final PlayerInteractEvent evento) {
		final Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals((Object) Material.AIR)
				&& jogador.getItemInHand().getItemMeta().hasDisplayName()
				&& jogador.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("")) {
			evento.setCancelled(true);
			evento.getAction();
		}
	}

	@EventHandler
	public void abrirClasssedddds(final PlayerInteractEvent evento) {
		final Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals((Object) Material.CHEST)
				&& jogador.getItemInHand().getItemMeta().hasDisplayName()) {
			if (jogador.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("�3�lKits")) {
				evento.setCancelled(true);
			}
			if (evento.getAction() == Action.RIGHT_CLICK_AIR) {
				Kits.guiKits1(jogador);
			}
		}
	}

	@EventHandler
	public void abrirClsdassdses(final PlayerInteractEvent evento) {
		final Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals((Object) Material.AIR)
				&& jogador.getItemInHand().getItemMeta().hasDisplayName()
				&& jogador.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("")) {
			evento.setCancelled(true);
			if (evento.getAction() == Action.RIGHT_CLICK_AIR) {
				Ranks.guiKits(jogador);
			}
		}
	}

	@EventHandler
	public void abrirClassdses(final PlayerInteractEvent evento) {
		final Player jogador = evento.getPlayer();
		if (jogador.getItemInHand().getType().equals((Object) Material.AIR)
				&& jogador.getItemInHand().getItemMeta().hasDisplayName()
				&& jogador.getItemInHand().getItemMeta().getDisplayName().equalsIgnoreCase("")) {
			evento.setCancelled(true);
			evento.getAction();
		}
	}

	public static String getShortStr(final String s) {
		if (s.length() == 20) {
			final String shorts = s.substring(0, s.length() - 12);
			return shorts;
		}
		if (s.length() == 19) {
			final String shorts = s.substring(0, s.length() - 11);
			return shorts;
		}
		if (s.length() == 18) {
			final String shorts = s.substring(0, s.length() - 10);
			return shorts;
		}
		if (s.length() == 17) {
			final String shorts = s.substring(0, s.length() - 9);
			return shorts;
		}
		if (s.length() == 16) {
			final String shorts = s.substring(0, s.length() - 8);
			return shorts;
		}
		if (s.length() == 15) {
			final String shorts = s.substring(0, s.length() - 7);
			return shorts;
		}
		if (s.length() == 14) {
			final String shorts = s.substring(0, s.length() - 6);
			return shorts;
		}
		if (s.length() == 13) {
			final String shorts = s.substring(0, s.length() - 5);
			return shorts;
		}
		if (s.length() == 12) {
			final String shorts = s.substring(0, s.length() - 4);
			return shorts;
		}
		if (s.length() == 11) {
			final String shorts = s.substring(0, s.length() - 3);
			return shorts;
		}
		if (s.length() == 10) {
			final String shorts = s.substring(0, s.length() - 2);
			return shorts;
		}
		if (s.length() == 9) {
			final String shorts = s.substring(0, s.length() - 1);
			return shorts;
		}
		return s;
	}
}
