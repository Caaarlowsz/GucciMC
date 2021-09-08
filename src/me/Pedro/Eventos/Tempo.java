package me.Pedro.Eventos;

import me.Pedro.Main;
import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import java.util.HashMap;

public class Tempo
{
    public static HashMap<Player, Long> run;
    
    static {
        Tempo.run = new HashMap<Player, Long>();
    }
    
    public static ItemStack run(final Material m, final int qnt, final String nome, final List<String> lore) {
        final ItemStack item = new ItemStack(m, qnt);
        final ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(nome);
        meta.setLore((List)lore);
        item.setItemMeta(meta);
        return item;
    }
    
    public static void add(final Player p, final int seconds) {
        final long cooldownLength = System.currentTimeMillis() + seconds * 1000;
        Tempo.run.remove(p);
        Tempo.run.put(p, cooldownLength);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Tempo.Tempo$1(p), (long)(seconds * 20));
    }
    
    public static long time(final Player p) {
        final long cooldownLength = Tempo.run.get(p);
        final long left = (cooldownLength - System.currentTimeMillis()) / 1000L;
        return left;
    }
    
    public static boolean cadd(final Player p) {
        return Tempo.run.containsKey(p);
    }
    
    public static void viado(final Player p) {
        Tempo.run.remove(p);
    }
}
