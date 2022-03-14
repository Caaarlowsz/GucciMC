package iLucasUS.Pedro.Lauchers;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class Diamante implements Listener {
	public static GucciPvP plugin;
	public static ArrayList<String> Diamante;

	static {
		iLucasUS.Pedro.Lauchers.Diamante.Diamante = new ArrayList<String>();
	}

	public Diamante(final GucciPvP main) {
		iLucasUS.Pedro.Lauchers.Diamante.plugin = main;
	}

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onPlayerJump1(final PlayerMoveEvent e) {
		final Player p = e.getPlayer();
		if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.DIAMOND_BLOCK) {
			iLucasUS.Pedro.Lauchers.Diamante.Diamante.remove(p.getName());
			final Vector sponge = p.getLocation().getDirection().multiply(0).setY(1);
			p.setVelocity(sponge);
			iLucasUS.Pedro.Lauchers.Diamante.Diamante.add(p.getName());
		}
	}

	@EventHandler
	public void onFall(final EntityDamageEvent e) {
		if (e.getEntity() instanceof Player) {
			final Player p = (Player) e.getEntity();
			if (e.getCause().equals((Object) EntityDamageEvent.DamageCause.FALL)
					&& iLucasUS.Pedro.Lauchers.Diamante.Diamante.contains(p.getName())) {
				e.setCancelled(true);
				iLucasUS.Pedro.Lauchers.Diamante.Diamante.remove(p.getName());
			}
		}
	}
}
