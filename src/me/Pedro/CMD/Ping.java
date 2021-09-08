package me.Pedro.CMD;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Ping implements CommandExecutor, Listener
{
    public boolean onCommand(final CommandSender sender, final Command command, final String c, final String[] args) {
        if (sender instanceof Player) {
            final Player p = (Player)sender;
            final int ping = ((CraftPlayer)p).getHandle().ping;
            if (c.equalsIgnoreCase("ping")) {
                if (args.length == 0) {
                    p.sendMessage("§c§lFaant§f§lMC §a>> §7Seu ping e de: §c" + ping + " §7ms §7!");
                }
                else if (p.getServer().getPlayer(args[0]) != null) {
                    final String player2 = args[0];
                    final Player target = Bukkit.getServer().getPlayer(args[0]);
                    final int ping2 = ((CraftPlayer)target).getHandle().ping;
                    p.sendMessage("§c§lFaant§f§lMC §a>> §7O jogador: §c" + player2 + " §7Tem Um ping de: §c" + ping2 + "§7 ms §7!");
                }
                else {
                    final String player2 = args[0];
                    p.sendMessage("§c§lFaant§f§lMC §a>> §7Este jogador: §c" + player2 + " §7se encontra offline !");
                }
            }
        }
        return false;
    }
}
