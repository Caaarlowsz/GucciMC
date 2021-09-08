package me.Pedro.XP;

import org.bukkit.entity.Player;
import me.Pedro.Main;

public class XpM
{
    public static MyConfig PlayerMoney;
    public static int defaultmoney;
    
    static {
        XpM.defaultmoney = 0;
    }
    
    public static void loadMoneyManager() {
        XpM.PlayerMoney = Main.manager.getNewConfig("XP.yml");
    }
    
    public static int getPlayerMoney(final Player p) {
        return XpM.PlayerMoney.getInt(p.getUniqueId().toString());
    }
    
    public static void addMoney(final Player p, final int add) {
        XpM.PlayerMoney.set(p.getUniqueId().toString(), getPlayerMoney(p) + add);
        XpM.PlayerMoney.saveConfig();
    }
    
    public static void removeMoney(final Player p, final int remove) {
        XpM.PlayerMoney.set(p.getUniqueId().toString(), getPlayerMoney(p) - remove);
        XpM.PlayerMoney.saveConfig();
    }
}
