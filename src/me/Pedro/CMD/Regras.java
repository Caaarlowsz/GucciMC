package me.Pedro.CMD;

import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;

public class Regras implements CommandExecutor
{
    public boolean onCommand(final CommandSender sender, final Command command, final String commandLabel, final String[] args) {
        final Player player = (Player)sender;
        if (commandLabel.equalsIgnoreCase("regras")) {
            player.sendMessage("§c- §7N\u00e3o usar §cHACK §7(Banimento §4PERMANENTE§7)");
            player.sendMessage("§c- §7N\u00e3o testar §3staff §7(Banimento §4PERMANENTE§7)");
            player.sendMessage("§c- §7N\u00e3o §3forjar §7hack §7(Banimento §4PERMANENTE§7)");
            player.sendMessage("§C- §7N\u00e3o §3divulgar §7servidores. (Banimento §4PERMANENTE§7)");
            player.sendMessage("§c- §7N\u00e3o ofender §3jogadores §7(Banimento §9TEMPORARIO§7)");
            return true;
        }
        return false;
    }
}
