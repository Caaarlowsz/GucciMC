package me.Pedro.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import me.Pedro.Main;
import me.Pedro.Eventos.KitAPI;
import me.Pedro.ScoreBoard.Habilidade;

public class irSpawn implements Listener, CommandExecutor {
	public static Main plugin;

	public irSpawn(final Main main) {
		irSpawn.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("spawn")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			final World w = Bukkit.getServer().getWorld(irSpawn.plugin.getConfig().getString("spawn.world"));
			final double x = irSpawn.plugin.getConfig().getDouble("spawn.x");
			final double y = irSpawn.plugin.getConfig().getDouble("spawn.y");
			final double z = irSpawn.plugin.getConfig().getDouble("spawn.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) irSpawn.plugin.getConfig().getDouble("spawn.pitch"));
			lobby.setYaw((float) irSpawn.plugin.getConfig().getDouble("spawn.yaw"));
			KitAPI.remove(p);
			Habilidade.setAbility(p, "Nenhum");
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.teleport(lobby);
			p.setExp(0.0f);
			p.setExhaustion(20.0f);
			p.setFireTicks(0);
			p.setFoodLevel(20000);
			p.getInventory().clear();
			p.setMaxHealth(20);
			p.setHealth(20.0);
			KitAPI.setitem(p, Material.BOOK, "§3§lMenu", 3, Enchantment.SILK_TOUCH, 0, false);
			KitAPI.setitem(p, Material.COMPASS, "§3§lWarps", 5, Enchantment.SILK_TOUCH, 0, false);
			KitAPI.setitem(p, Material.CHEST, "§3§lKits", 4, Enchantment.SILK_TOUCH, 0, false);
		}
		return false;
	}
}
