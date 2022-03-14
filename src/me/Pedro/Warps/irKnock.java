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
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;
import me.Pedro.Eventos.KitAPI;

public class irKnock implements Listener, CommandExecutor {
	public static GucciPvP plugin;

	public irKnock(final GucciPvP main) {
		irKnock.plugin = main;
	}

	@SuppressWarnings("unused")
	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("knock")) {
			final Player p = (Player) sender;
			final World w = Bukkit.getServer().getWorld(irKnock.plugin.getConfig().getString("knock.world"));
			final double x = irKnock.plugin.getConfig().getDouble("knock.x");
			final double y = irKnock.plugin.getConfig().getDouble("knock.y");
			final double z = irKnock.plugin.getConfig().getDouble("knock.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) irKnock.plugin.getConfig().getDouble("knock.pitch"));
			lobby.setYaw((float) irKnock.plugin.getConfig().getDouble("knock.yaw"));
			p.getInventory().clear();
			p.setHealthScale(20.0);
			for (final PotionEffect effect : p.getActivePotionEffects()) {
				final ItemStack espada = new ItemStack(Material.STICK);
				final ItemMeta espadameta = espada.getItemMeta();
				espadameta.setDisplayName("�6KNOCK!");
				espada.addUnsafeEnchantment(Enchantment.KNOCKBACK, 2);
				p.getInventory().setItem(0, espada);
				p.setFireTicks(0);
				p.getInventory().setBoots((ItemStack) null);
				p.getInventory().setChestplate((ItemStack) null);
				p.getInventory().setLeggings((ItemStack) null);
				p.getInventory().setHelmet((ItemStack) null);
				p.setHealthScale(20.0);
				KitAPI.sopa(p);
			}
			return false;
		}
		return false;
	}
}
