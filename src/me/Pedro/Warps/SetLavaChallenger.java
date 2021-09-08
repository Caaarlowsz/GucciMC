package me.Pedro.Warps;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.Pedro.Main;
import org.bukkit.command.CommandExecutor;

public class SetLavaChallenger implements CommandExecutor
{
    public static Main plugin;
    
    public SetLavaChallenger(final Main main) {
        SetLavaChallenger.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setchallenge") && sender instanceof Player) {
            if (!sender.hasPermission("kitpvp.setwarp")) {
                final Player p = (Player)sender;
                p.sendMessage(Main.semperm);
            }
            if (sender.hasPermission("kitpvp.setwarp")) {
                final Player p2 = (Player)sender;
                SetLavaChallenger.plugin.getConfig().set("challenge.x", (Object)p2.getLocation().getX());
                SetLavaChallenger.plugin.getConfig().set("challenge.y", (Object)p2.getLocation().getY());
                SetLavaChallenger.plugin.getConfig().set("challenge.z", (Object)p2.getLocation().getZ());
                SetLavaChallenger.plugin.getConfig().set("challenge.pitch", (Object)p2.getLocation().getPitch());
                SetLavaChallenger.plugin.getConfig().set("challenge.yaw", (Object)p2.getLocation().getYaw());
                SetLavaChallenger.plugin.getConfig().set("challenge.world", (Object)p2.getLocation().getWorld().getName());
                SetLavaChallenger.plugin.saveConfig();
                p2.sendMessage(String.valueOf(Main.p) + "§7Warp Challenge setada com sucesso");
            }
        }
        return false;
    }
}
