package me.Pedro.Eventos;

import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;
import org.bukkit.event.player.PlayerJoinEvent;
import me.Pedro.Main;
import org.bukkit.event.Listener;

public class Tab implements Listener
{
    private static int VERSION;
    
    static {
        Tab.VERSION = 47;
    }
    
    public Tab(final Main main) {
    }
    
    @EventHandler
    void TabDoServidor(final PlayerJoinEvent e) {
        final Player jogador = e.getPlayer();
        Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), (Runnable)new Tab.Tab$1(this, jogador), 1L, 20L);
    }
}
