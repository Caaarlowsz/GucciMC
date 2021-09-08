package me.Pedro.Eventos;

import org.bukkit.event.EventPriority;
import org.bukkit.event.EventHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.Listener;

public class ChatFormat implements Listener
{
    @EventHandler(priority = EventPriority.HIGHEST)
    public void chat(final PlayerChatEvent e) {
        final Player p = e.getPlayer();
        if (!p.hasPermission("kitpvp.falarcolorido")) {
            e.setFormat("§7(§f-§7) " + p.getDisplayName() + " §7» " + e.getMessage());
        }
        else {
            e.setFormat("§7(§f-§7) " + p.getDisplayName() + " §7» " + e.getMessage().replace("&", "§"));
        }
    }
    
    public static void Link(final Player p, final String string, final String string2, final String string3) {
    }
}
