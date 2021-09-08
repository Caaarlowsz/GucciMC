package me.Pedro.Warps;

import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.World;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.Pedro.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class irMdr implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public irMdr(final Main main) {
        irMdr.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("mdr")) {
            final Player p = (Player)sender;
            final World w = Bukkit.getServer().getWorld(irMdr.plugin.getConfig().getString("mdr.world"));
            final double x = irMdr.plugin.getConfig().getDouble("mdr.x");
            final double y = irMdr.plugin.getConfig().getDouble("mdr.y");
            final double z = irMdr.plugin.getConfig().getDouble("mdr.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)irMdr.plugin.getConfig().getDouble("mdr.pitch"));
            lobby.setYaw((float)irMdr.plugin.getConfig().getDouble("mdr.yaw"));
            p.getInventory().clear();
            p.getInventory().setBoots((ItemStack)null);
            p.getInventory().setChestplate((ItemStack)null);
            p.getInventory().setLeggings((ItemStack)null);
            p.getInventory().setHelmet((ItemStack)null);
            p.setHealthScale(20.0);
            final ItemStack pyro2 = new ItemStack(Material.REDSTONE_BLOCK);
            final ItemMeta metapyro2 = pyro2.getItemMeta();
            metapyro2.setDisplayName("§b§lmdr §3[LEIA]");
            final ArrayList<String> descpyro2 = new ArrayList<String>();
            descpyro2.add("§a§l* §fO §3evento §finicia quando h\u00e1 staff on.");
            descpyro2.add("§a§l* §fQuando §acome\u00e7ar, §firemos lhe chamar. :)");
            metapyro2.setLore((List)descpyro2);
            pyro2.setItemMeta(metapyro2);
            p.getInventory().setItem(4, pyro2);
            p.teleport(lobby);
        }
        return false;
    }
}
