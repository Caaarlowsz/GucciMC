package me.Pedro.CMD;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.inventory.Inventory;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.Material;
import me.Pedro.Main;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class AutoSoup implements CommandExecutor, Listener
{
    public static HashMap<String, ItemStack[]> saveinv;
    public static HashMap<String, ItemStack[]> armadura;
    ItemStack sopa;
    ItemMeta msopa;
    ItemStack sopa1;
    ItemMeta msopa1;
    ItemStack sopa2;
    ItemMeta msopa2;
    
    static {
        AutoSoup.saveinv = new HashMap<String, ItemStack[]>();
        AutoSoup.armadura = new HashMap<String, ItemStack[]>();
    }
    
    public AutoSoup(final Main main) {
        this.sopa = new ItemStack(Material.MUSHROOM_SOUP);
        this.msopa = this.sopa.getItemMeta();
        this.sopa1 = new ItemStack(Material.MUSHROOM_SOUP);
        this.msopa1 = this.sopa.getItemMeta();
        this.sopa2 = new ItemStack(Material.MUSHROOM_SOUP);
        this.msopa2 = this.sopa.getItemMeta();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String Label, final String[] args) {
        final Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("autosoup")) {
            if (!p.hasPermission("slicemc.admin")) {
                p.sendMessage(String.valueOf(String.valueOf(Main.p)) + " �7Sem premiss\u00e3o !");
                return true;
            }
            if (args.length == 0) {
                sender.sendMessage(String.valueOf(String.valueOf(Main.p)) + " �7Comando incorreto! Use: /�3Autosoup �7(�3nick�7) !");
                return true;
            }
            final Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null || !(target instanceof Player)) {
                sender.sendMessage(String.valueOf(String.valueOf(Main.p)) + " �7Este jogador se encontra offline !");
                return true;
            }
            if (target.getName() == p.getName()) {
                p.sendMessage(String.valueOf(Main.p) + " �7Voc\u00ea n\u00e3o pode usar o autosoup em voc\u00ea mesmo !");
                return true;
            }
            final Player testando = p.getServer().getPlayer(args[0]);
            p.openInventory((Inventory)testando.getInventory());
            AutoSoup.saveinv.put(testando.getName(), testando.getInventory().getContents());
            AutoSoup.armadura.put(testando.getName(), testando.getInventory().getArmorContents());
            testando.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 70, 999));
            testando.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 70, 999));
            this.sopa.setItemMeta(this.msopa);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new AutoSoup.AutoSoup$1(this, testando), 20L);
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), (Runnable)new AutoSoup.AutoSoup$2(this, testando), 60L);
        }
        return false;
    }
}
