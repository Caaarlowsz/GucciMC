package me.Pedro.Minigames;

import me.Pedro.Eventos.KitAPI;
import org.bukkit.plugin.Plugin;
import me.Pedro.Main;
import org.bukkit.entity.Player;

public class voidChallenge
{
    public voidChallenge(final Player p) {
        new voidChallenge.voidChallenge$1(this, p).runTaskTimer((Plugin)Main.instance, 0L, 20L);
    }
    
    public static int getTime(final Player p) {
        if (!KitAPI.voidChallengeTime.containsKey(p.getName())) {
            return 0;
        }
        return KitAPI.voidChallengeTime.get(p.getName());
    }
}
