package me.Pedro.Warps;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

import me.Pedro.Main;

public class irLavaFacil implements Listener, CommandExecutor {
	public static Main plugin;

	public irLavaFacil(final Main main) {
		irLavaFacil.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("challenge")) {
			final Player p = (Player) sender;
			final World w = Bukkit.getServer().getWorld(irLavaFacil.plugin.getConfig().getString("challenge.world"));
			final double x = irLavaFacil.plugin.getConfig().getDouble("challenge.x");
			final double y = irLavaFacil.plugin.getConfig().getDouble("challenge.y");
			final double z = irLavaFacil.plugin.getConfig().getDouble("challenge.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) irLavaFacil.plugin.getConfig().getDouble("challenge.pitch"));
			lobby.setYaw((float) irLavaFacil.plugin.getConfig().getDouble("challenge.yaw"));
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.setFireTicks(0);
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BROWN_MUSHROOM, 64) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.RED_MUSHROOM, 64) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOWL, 64) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
			p.teleport(lobby);
			for (final PotionEffect effect : p.getActivePotionEffects()) {
				p.removePotionEffect(effect.getType());
			}
		}
		return false;
	}
}
