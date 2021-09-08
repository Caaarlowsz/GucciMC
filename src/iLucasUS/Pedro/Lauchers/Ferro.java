package iLucasUS.Pedro.Lauchers;

import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.util.Vector;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.event.player.PlayerMoveEvent;
import java.util.ArrayList;
import me.Pedro.Main;
import org.bukkit.event.Listener;

public class Ferro implements Listener
{
    public static Main plugin;
    public static ArrayList<String> Ferro;
    
    static {
        iLucasUS.Pedro.Lauchers.Ferro.Ferro = new ArrayList<String>();
    }
    
    public Ferro(final Main main) {
        iLucasUS.Pedro.Lauchers.Ferro.plugin = main;
    }
    
    @EventHandler(priority = EventPriority.MONITOR)
    public void onPlayerJump1(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (e.getTo().getBlock().getRelative(BlockFace.DOWN).getType() == Material.IRON_BLOCK) {
            iLucasUS.Pedro.Lauchers.Ferro.Ferro.remove(p.getName());
            final Location loc = e.getTo().getBlock().getLocation();
            final Vector sponge = p.getLocation().getDirection().multiply(0).setY(2);
            p.setVelocity(sponge);
            iLucasUS.Pedro.Lauchers.Ferro.Ferro.add(p.getName());
        }
    }
    
    @EventHandler
    public void onFall(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause().equals((Object)EntityDamageEvent.DamageCause.FALL) && iLucasUS.Pedro.Lauchers.Ferro.Ferro.contains(p.getName())) {
                e.setCancelled(true);
                iLucasUS.Pedro.Lauchers.Ferro.Ferro.remove(p.getName());
            }
        }
    }
}
