package me.Pedro.CMD;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import me.Pedro.Eventos.TheTitle;
import me.Pedro.ScoreBoard.Habilidade;

public final class Build implements Listener, CommandExecutor {
	public static ArrayList<Player> embuild;

	static {
		Build.embuild = new ArrayList<Player>();
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		final Player p = (Player) sender;
		if (cmd.getName().equalsIgnoreCase("build")) {
			if (p.hasPermission("kitpvp.build")) {
				if (args.length == 0) {
					if (!Build.embuild.contains(p)) {
						Build.embuild.add(p);
						p.sendMessage(String.valueOf(String.valueOf(GucciPvP.p)) + " �7Modo build �a�lATIVADO�7 !");
						Habilidade.setAbility(p, "Build");
						TheTitle.sendTitle(p, "�c�lFannt�f�lMC");
						TheTitle.sendSubTitle(p, "�7Build: �a�lON");
						p.setGameMode(GameMode.CREATIVE);
					} else {
						Build.embuild.remove(p);
						p.sendMessage(String.valueOf(String.valueOf(GucciPvP.p)) + " �7Modo build �c�lDESATIVADO�7 !");
						Habilidade.setAbility(p, "Nenhum");
						TheTitle.sendTitle(p, "�c�lFannt�f�lMC");
						TheTitle.sendSubTitle(p, "�7Build: �c�lOFF");
						p.setGameMode(GameMode.SURVIVAL);
					}
				} else {
					final Player t = Bukkit.getPlayer(args[0]);
					if (t == null) {
						p.sendMessage(String.valueOf(String.valueOf(GucciPvP.p)) + " �7Este jogador se encontra offline !");
						return true;
					}
					if (!Build.embuild.contains(t)) {
						Build.embuild.add(t);
						p.sendMessage(String.valueOf(String.valueOf(GucciPvP.p))
								+ " �7Voc\u00ea �aativou �7o modo build para o jogador: �b" + t.getName() + " �7!");
					} else {
						Build.embuild.remove(t);
						p.sendMessage(String.valueOf(String.valueOf(GucciPvP.p))
								+ " �7Voc\u00ea �cdesativou �7o modo build para o jogador: �b" + t.getName());
					}
				}
			} else {
				p.sendMessage(String.valueOf(String.valueOf(GucciPvP.p)) + " �7Sem permiss\u00e3o !");
			}
		}
		return false;
	}

	@EventHandler
	public void aoconstruir(final BlockPlaceEvent e) {
		final Player p = e.getPlayer();
		if (!Build.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}

	@EventHandler
	public void aoconstruir(final BlockBreakEvent e) {
		final Player p = e.getPlayer();
		if (!Build.embuild.contains(p)) {
			e.setCancelled(true);
		}
	}
}
