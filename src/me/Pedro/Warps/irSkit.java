package me.Pedro.Warps;

import java.util.ArrayList;

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
import org.bukkit.inventory.meta.ItemMeta;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class irSkit implements Listener, CommandExecutor {
	public static GucciPvP plugin;

	public irSkit(final GucciPvP main) {
		irSkit.plugin = main;
	}

	public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel,
			final String[] args) {
		if (cmd.getName().equalsIgnoreCase("skit")) {
			final Player p = (Player) sender;
			final World w = Bukkit.getServer().getWorld(irSkit.plugin.getConfig().getString("skit.world"));
			final double x = irSkit.plugin.getConfig().getDouble("skit.x");
			final double y = irSkit.plugin.getConfig().getDouble("skit.y");
			final double z = irSkit.plugin.getConfig().getDouble("skit.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) irSkit.plugin.getConfig().getDouble("skit.pitch"));
			lobby.setYaw((float) irSkit.plugin.getConfig().getDouble("skit.yaw"));
			p.getInventory().clear();
			p.getInventory().setBoots((ItemStack) null);
			p.getInventory().setChestplate((ItemStack) null);
			p.getInventory().setLeggings((ItemStack) null);
			p.getInventory().setHelmet((ItemStack) null);
			p.setHealthScale(20.0);
			final ItemStack pyro2 = new ItemStack(Material.REDSTONE_BLOCK);
			final ItemMeta metapyro2 = pyro2.getItemMeta();
			metapyro2.setDisplayName("�b�lSKIT �3[LEIA]");
			final ArrayList<String> descpyro2 = new ArrayList<String>();
			descpyro2.add("�a�l* �fO �3evento �finicia quando h\u00e1 staff on.");
			descpyro2.add("�a�l* �fQuando �acome\u00e7ar, �firemos lhe chamar. :)");
			metapyro2.setLore(descpyro2);
			pyro2.setItemMeta(metapyro2);
			p.getInventory().setItem(4, pyro2);
			p.teleport(lobby);
		}
		return false;
	}
}
