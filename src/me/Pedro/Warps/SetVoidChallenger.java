package me.Pedro.Warps;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.Pedro.Main;
import org.bukkit.command.CommandExecutor;

public class SetVoidChallenger implements CommandExecutor
{
    public static Main plugin;
    
    public SetVoidChallenger(final Main main) {
        SetVoidChallenger.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("setvoid") && sender instanceof Player) {
            if (!sender.hasPermission("kitpvp.setwarp")) {
                final Player p = (Player)sender;
                p.sendMessage(Main.semperm);
            }
            if (sender.hasPermission("kitpvp.setwarp")) {
                final Player p2 = (Player)sender;
                SetVoidChallenger.plugin.getConfig().set("void.x", (Object)p2.getLocation().getX());
                SetVoidChallenger.plugin.getConfig().set("void.y", (Object)p2.getLocation().getY());
                SetVoidChallenger.plugin.getConfig().set("void.z", (Object)p2.getLocation().getZ());
                SetVoidChallenger.plugin.getConfig().set("void.pitch", (Object)p2.getLocation().getPitch());
                SetVoidChallenger.plugin.getConfig().set("void.yaw", (Object)p2.getLocation().getYaw());
                SetVoidChallenger.plugin.getConfig().set("void.world", (Object)p2.getLocation().getWorld().getName());
                SetVoidChallenger.plugin.saveConfig();
                p2.sendMessage(String.valueOf(Main.p) + "§7Warp void setada com sucesso");
            }
        }
        return false;
    }
}
