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
import org.bukkit.potion.PotionEffectType;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class irMain implements Listener, CommandExecutor {
	public static GucciPvP plugin;

	public irMain(final GucciPvP main) {
		irMain.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("main")) {
			final Player p = (Player) sender;
			p.getInventory().clear();
			final World w = Bukkit.getServer().getWorld(irMain.plugin.getConfig().getString("main.world"));
			final double x = irMain.plugin.getConfig().getDouble("main.x");
			final double y = irMain.plugin.getConfig().getDouble("main.y");
			final double z = irMain.plugin.getConfig().getDouble("main.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) irMain.plugin.getConfig().getDouble("main.pitch"));
			lobby.setYaw((float) irMain.plugin.getConfig().getDouble("main.yaw"));
			p.teleport(lobby);
			p.getInventory().clear();
			final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
			final ItemMeta espadameta = espada.getItemMeta();
			espadameta.setDisplayName("�cMain Sword");
			espada.addEnchantment(Enchantment.DAMAGE_ALL, 1);
			p.setFireTicks(0);
			p.getInventory().setItem(0, espada);
			p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
			p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
			p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
			p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
			p.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999, 0));
			p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999999, 0));
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
			p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.MUSHROOM_SOUP, 1) });
		}
		return false;
	}
}
