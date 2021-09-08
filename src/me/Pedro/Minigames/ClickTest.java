package me.Pedro.Minigames;

import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.plugin.Plugin;
import org.bukkit.Bukkit;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import me.Pedro.Main;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class ClickTest implements CommandExecutor, Listener
{
    public static ArrayList<Player> sela;
    public static ClickTest m;
    
    static {
        ClickTest.sela = new ArrayList<Player>();
    }
    
    public ClickTest(final Main main) {
    }
    
    public static ClickTest getMain() {
        return ClickTest.m;
    }
    
    @EventHandler
    public void bater(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (ClickTest.sela.contains(p) && e.getAction() == Action.LEFT_CLICK_AIR) {
            p.setLevel(p.getLevel() + 1);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new ClickTest.ClickTest$1(this, p), 200L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new ClickTest.ClickTest$2(this, p), 260L);
        }
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (sender instanceof Player && cmd.getName().equalsIgnoreCase("clicktest")) {
            final Player p = (Player)sender;
            p.setLevel(0);
            p.setGameMode(GameMode.SURVIVAL);
            p.getInventory().clear();
            p.sendMessage(String.valueOf(Main.p) + "§7O ClickTeste ir\u00e1 come\u00e7ar em 5 segundos");
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new ClickTest.ClickTest$3(this, p), 20L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new ClickTest.ClickTest$4(this, p), 40L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new ClickTest.ClickTest$5(this, p), 60L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new ClickTest.ClickTest$6(this, p), 80L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask((Plugin)Main.instance, (Runnable)new ClickTest.ClickTest$7(this, p), 100L);
        }
        return false;
    }
}
