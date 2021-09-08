package me.Pedro.CMD;

import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Tp implements CommandExecutor
{
    public String[] aliases;
    
    public Tp() {
        this.aliases = new String[] { "tp" };
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Voce nao e um jogador!");
            return false;
        }
        final Player p = (Player)sender;
        if (p.hasPermission("cmd.admin")) {
            if (args.length == 0) {
                p.sendMessage("§9§lTELEPORT §fUse: /tp <nick>");
            }
            else if (args.length == 1) {
                final Player target = p.getServer().getPlayer(args[0]);
                if (target != null) {
                    p.teleport(target.getLocation());
                    Player[] arrayOfPlayer1;
                    for (int j = (arrayOfPlayer1 = Bukkit.getOnlinePlayers()).length, i = 0; i < j; ++i) {
                        final Player p2 = arrayOfPlayer1[i];
                        if (p2.hasPermission("cmd.admin") || p2.isOp()) {
                            p2.sendMessage("§7§o[" + p.getName() + " foi teleportado para " + target.getName() + "]");
                        }
                    }
                }
                else {
                    p.sendMessage("§9§lTELEPORT §fEste jogador nao esta Online.");
                }
            }
            else if (args.length == 2) {
                final Player target = p.getServer().getPlayer(args[0]);
                final Player starget = p.getServer().getPlayer(args[1]);
                if (target != null) {
                    if (starget != null) {
                        target.teleport(starget.getLocation());
                        Player[] arrayOfPlayer2;
                        for (int k = (arrayOfPlayer2 = Bukkit.getOnlinePlayers()).length, j = 0; j < k; ++j) {
                            final Player p3 = arrayOfPlayer2[j];
                            if (p3.hasPermission("cmd.admin") || p3.isOp()) {
                                p3.sendMessage(ChatColor.GRAY + target.getName() + " foi teleportado para " + starget.getName());
                            }
                        }
                    }
                    else {
                        p.sendMessage("§cO jogador " + args[1] + " §cnao esta online.");
                    }
                }
                else {
                    p.sendMessage("§cO jogador " + args[0] + " §cnao esta online.");
                }
            }
            else if (args.length == 3) {
                final double x2 = args[0].startsWith("~") ? (p.getLocation().getX() + Integer.parseInt(args[0].substring(1))) : Integer.parseInt(args[0]);
                final double y2 = args[1].startsWith("~") ? (p.getLocation().getY() + Integer.parseInt(args[1].substring(1))) : Integer.parseInt(args[1]);
                final double z2 = args[2].startsWith("~") ? (p.getLocation().getZ() + Integer.parseInt(args[2].substring(1))) : Integer.parseInt(args[2]);
                if (x2 > 3.0E7 || y2 > 3.0E7 || z2 > 3.0E7 || x2 < -3.0E7 || y2 < -3.0E7 || z2 < -3.0E7) {
                    return true;
                }
                final Location locpos = new Location(p.getWorld(), x2, y2, z2, p.getLocation().getYaw(), p.getLocation().getPitch());
                p.teleport(locpos);
                Player[] arrayOfPlayer3;
                for (int n = (arrayOfPlayer3 = Bukkit.getOnlinePlayers()).length, m = 0; m < n; ++m) {
                    final Player p4 = arrayOfPlayer3[m];
                    if (p4.hasPermission("cmd.admin") || p4.isOp()) {
                        p4.sendMessage(ChatColor.GRAY + p.getName() + " foi teleportado para X:" + locpos.getBlockX() + " Y:" + locpos.getBlockY() + " Z:" + locpos.getBlockZ() + " .");
                    }
                }
            }
            else if (args.length == 4) {
                final Player target2 = p.getServer().getPlayer(args[0]);
                final double x3 = args[1].startsWith("~") ? (target2.getLocation().getX() + Integer.parseInt(args[0].substring(1))) : Integer.parseInt(args[1]);
                final double y3 = args[2].startsWith("~") ? (target2.getLocation().getY() + Integer.parseInt(args[1].substring(1))) : Integer.parseInt(args[2]);
                final double z3 = args[3].startsWith("~") ? (target2.getLocation().getZ() + Integer.parseInt(args[2].substring(1))) : Integer.parseInt(args[3]);
                if (x3 > 3.0E7 || y3 > 3.0E7 || z3 > 3.0E7 || x3 < -3.0E7 || y3 < -3.0E7 || z3 < -3.0E7 || target2 == null) {
                    return true;
                }
                final Location locpos2 = new Location(p.getWorld(), x3, y3, z3, target2.getLocation().getYaw(), target2.getLocation().getPitch());
                target2.teleport(locpos2);
                Player[] arrayOfPlayer4;
                for (int i2 = (arrayOfPlayer4 = Bukkit.getOnlinePlayers()).length, n = 0; n < i2; ++n) {
                    final Player p5 = arrayOfPlayer4[n];
                    if (p5.hasPermission("cmd.admin") || p5.isOp()) {
                        p5.sendMessage(ChatColor.GRAY + target2.getName() + " foi teleportado para X:" + locpos2.getBlockX() + " Y:" + locpos2.getBlockY() + " Z:" + locpos2.getBlockZ() + " .");
                    }
                }
            }
        }
        return false;
    }
}
