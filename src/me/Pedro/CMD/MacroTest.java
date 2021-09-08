package me.Pedro.CMD;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import me.Pedro.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import java.util.ArrayList;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class MacroTest implements Listener, CommandExecutor
{
    static final HashMap<String, Integer> Clicks;
    static final ArrayList<String> macro;
    
    static {
        Clicks = new HashMap<String, Integer>();
        macro = new ArrayList<String>();
    }
    
    public static void testeMAcro(final Player p, final Player t) {
        p.sendMessage("§e§lMACROTEST: §fTestando No Jogador: §b" + t.getName());
        MacroTest.macro.add(t.getName());
        MacroTest.Clicks.put(t.getName(), 0);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new MacroTest.MacroTest$1(p, t), 200L);
    }
    
    @EventHandler
    public void macro(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (MacroTest.macro.contains(p.getName()) && (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK)) {
            MacroTest.Clicks.put(p.getName(), MacroTest.Clicks.get(p.getName()) + 1);
        }
    }
    
    public final boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (p.hasPermission("cmd.testmacro")) {
            if (Args.length == 0) {
                p.sendMessage(String.valueOf(String.valueOf("§1§lFANNT§f§lMC")) + " §7» §cErrado, Utilize a Sintaxe Correta: /testmacro (jogador)");
                return true;
            }
            final Player t = Bukkit.getPlayer(Args[0]);
            if (t != null) {
                testeMAcro(p, t);
            }
        }
        return false;
    }
}
