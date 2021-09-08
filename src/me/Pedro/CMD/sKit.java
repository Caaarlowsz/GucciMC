package me.Pedro.CMD;

import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.Pedro.Main;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class sKit implements Listener, CommandExecutor
{
    public HashMap<String, ItemStack[]> itens;
    public HashMap<String, ItemStack[]> armor;
    
    public sKit(final Main main) {
        this.itens = new HashMap<String, ItemStack[]>();
        this.armor = new HashMap<String, ItemStack[]>();
    }
    
    public boolean isInt(final String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
    
    public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
        final Player p = (Player)Sender;
        if (Label.equalsIgnoreCase("criarkit") && Sender instanceof Player) {
            if (!p.hasPermission("cmd.skit")) {
                p.sendMessage(String.valueOf(String.valueOf("§b§lFANNT§c§lKITS §7")) + " §7» §cSem Permiss\u00e3o");
                return true;
            }
            if (Args.length == 0) {
                p.sendMessage("       ");
                p.sendMessage("                §3§lFANNT§fMC §7");
                p.sendMessage("                  §c§lERROR");
                p.sendMessage("§f» §bUtilize /criarkit criar [nome]");
                p.sendMessage("§f» §bUtilize /criarkit aplicar [nome] [blocos]");
                p.sendMessage("       ");
                return true;
            }
            if (Args[0].equalsIgnoreCase("criar")) {
                if (Args.length == 1) {
                    p.sendMessage(String.valueOf(String.valueOf("§b§lFANNT§c§lKITS §7")) + " §7» §fD\u00favidas? §3/criarkit.");
                    return true;
                }
                final String nome = Args[1];
                this.itens.put(nome, p.getInventory().getContents());
                this.armor.put(nome, p.getInventory().getArmorContents());
                p.sendMessage(String.valueOf(String.valueOf("§b§lFANNT§c§lKITS §7")) + " §7» CriarKit: " + Args[1] + " §acriado!");
                return true;
            }
            else if (Args[0].equalsIgnoreCase("aplicar")) {
                if (Args.length <= 2) {
                    p.sendMessage(String.valueOf(String.valueOf("§b§lFANNT§c§lKITS §7")) + " §7» §fD\u00favidas? §3/criarkit.");
                    return true;
                }
                final String nome = Args[1];
                if (!this.itens.containsKey(nome) && !this.armor.containsKey(nome)) {
                    p.sendMessage(String.valueOf(String.valueOf("§b§lFANNT§c§lKITS §7")) + " §7» §cO Kit §c" + nome + " §7N\u00e3o Existe");
                    return true;
                }
                if (this.isInt(Args[2])) {
                    final int n = Integer.parseInt(Args[2]);
                    for (final Entity e : p.getNearbyEntities((double)n, (double)n, (double)n)) {
                        if (e instanceof Player) {
                            final Player p2 = (Player)e;
                            p2.getInventory().setArmorContents((ItemStack[])this.armor.get(nome));
                            p2.getInventory().setContents((ItemStack[])this.itens.get(nome));
                        }
                    }
                    Bukkit.getServer().broadcastMessage("");
                    Bukkit.getServer().broadcastMessage(String.valueOf(String.valueOf("§b§lFANNT§c§lKITS §7")) + " §7»  CriarKit: " + nome + " §aplicado!");
                    Bukkit.getServer().broadcastMessage("");
                    return false;
                }
            }
        }
        return false;
    }
}
