package me.Pedro.Minigames;

import org.bukkit.Material;
import org.bukkit.plugin.Plugin;
import me.Pedro.Main;
import me.Pedro.Eventos.KitAPI;
import org.bukkit.entity.Player;
import java.util.Random;

public class refillTest
{
    Random rand;
    
    public refillTest(final Player p) {
        this.rand = new Random();
        if (KitAPI.refillTest.contains(p.getName())) {
            p.sendMessage(String.valueOf(Main.p) + "§7Voc\u00ea k\u00e1 est\u00e1 em um treino");
            return;
        }
        new refillTest.refillTest$1(this, p).runTaskTimer((Plugin)Main.instance, 0L, 20L);
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
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }
}
