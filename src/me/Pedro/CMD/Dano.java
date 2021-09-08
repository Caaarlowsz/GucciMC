package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Dano implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (!cmd.getName().equalsIgnoreCase("dano") || (!sender.hasPermission("staff.dano") && !sender.isOp())) {
            return false;
        }
        if (p.getWorld().getPVP()) {
            p.getWorld().setPVP(false);
            Bukkit.getServer().broadcastMessage("§3§lDANO §7- §fO Dano do servidor foi §c§lDESATIVADO!");
            return true;
        }
        p.getWorld().setPVP(true);
        Bukkit.getServer().broadcastMessage("§3§lDANO §7- §fO Dano do servidor foi §a§lATIVADO!");
        return true;
    }
}
