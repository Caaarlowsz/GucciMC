package me.Pedro.Warps;

import org.bukkit.World;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.Pedro.Main;
import org.bukkit.command.CommandExecutor;
import org.bukkit.event.Listener;

public class irGlad implements Listener, CommandExecutor
{
    public static Main plugin;
    
    public irGlad(final Main main) {
        irGlad.plugin = main;
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String commandLabel, final String[] args) {
        if (cmd.getName().equalsIgnoreCase("glad")) {
            final Player p = (Player)sender;
            final World w = Bukkit.getServer().getWorld(irGlad.plugin.getConfig().getString("glad.world"));
            final double x = irGlad.plugin.getConfig().getDouble("glad.x");
            final double y = irGlad.plugin.getConfig().getDouble("glad.y");
            final double z = irGlad.plugin.getConfig().getDouble("glad.z");
            final Location lobby = new Location(w, x, y, z);
            lobby.setPitch((float)irGlad.plugin.getConfig().getDouble("glad.pitch"));
            lobby.setYaw((float)irGlad.plugin.getConfig().getDouble("glad.yaw"));
            p.getInventory().clear();
            p.getInventory().setBoots(new ItemStack(Material.IRON_BOOTS));
            p.getInventory().setChestplate(new ItemStack(Material.IRON_CHESTPLATE));
            p.getInventory().setLeggings(new ItemStack(Material.IRON_LEGGINGS));
            p.getInventory().setHelmet(new ItemStack(Material.IRON_HELMET));
            p.setHealthScale(20.0);
            final ItemStack espada = new ItemStack(Material.DIAMOND_SWORD);
            p.getInventory().setItem(0, espada);
            p.setFireTicks(0);
            final ItemStack trapei = new ItemStack(Material.WOOD, 64);
            p.getInventory().setItem(1, trapei);
            p.setFireTicks(0);
            final ItemStack trapei2 = new ItemStack(Material.COBBLE_WALL, 64);
            p.getInventory().setItem(2, trapei2);
            p.setFireTicks(0);
            final ItemStack lava = new ItemStack(Material.LAVA_BUCKET);
            p.getInventory().setItem(7, lava);
            p.setFireTicks(0);
            final ItemStack agua = new ItemStack(Material.WATER_BUCKET);
            p.getInventory().setItem(8, agua);
            p.setFireTicks(0);
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_CHESTPLATE, 2) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_LEGGINGS, 2) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_HELMET, 2) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.IRON_BOOTS, 1) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BROWN_MUSHROOM, 64) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.RED_MUSHROOM, 64) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.RED_MUSHROOM, 64) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BROWN_MUSHROOM, 64) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOWL, 64) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOWL, 64) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.BOWL, 64) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.DIAMOND_SWORD, 1) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_PICKAXE, 1) });
            p.getInventory().addItem(new ItemStack[] { new ItemStack(Material.STONE_AXE, 1) });
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
        }
        return false;
    }
}
