package me.Pedro.Ultis;

import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityExplodeEvent;
import org.bukkit.event.Listener;

public class N\u00e3oExplodirOMapa implements Listener
{
    @EventHandler
    public void semExplosao(final EntityExplodeEvent e) {
        e.setCancelled(true);
    }
}
