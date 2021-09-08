package me.Pedro.CMD;

import org.bukkit.inventory.Inventory;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.meta.ItemMeta;
import me.Pedro.Eventos.KitAPI;
import org.bukkit.Material;
import org.bukkit.GameMode;
import org.bukkit.Bukkit;
import me.Pedro.ScoreBoard.Habilidade;
import me.Pedro.Main;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.inventory.ItemStack;
import java.util.HashMap;
import java.util.ArrayList;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Admin implements CommandExecutor, Listener
{
    public static ArrayList<String> admin;
    public static HashMap<String, ItemStack[]> saveinv;
    public static HashMap<String, ItemStack[]> savearmor;
    
    static {
        Admin.admin = new ArrayList<String>();
        Admin.saveinv = new HashMap<String, ItemStack[]>();
        Admin.savearmor = new HashMap<String, ItemStack[]>();
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }
        if (!sender.hasPermission("kitpvp.admin")) {
            sender.sendMessage(String.valueOf(Main.p) + " §7Sem permiss\u00e3o !");
            return true;
        }
        final Player p = (Player)sender;
        if (args.length == 0) {
            if (!Habilidade.getAbility(p).equalsIgnoreCase("Admin")) {
                p.sendMessage(String.valueOf(Main.p) + " §7Voc\u00ea §aentrou §7no modo §6§lADMIN §7!");
                Player[] onlinePlayers;
                for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                    final Player s = onlinePlayers[i];
                    if (!s.hasPermission("kitpvp.admin")) {
                        s.hidePlayer(p);
                    }
                }
                p.setGameMode(GameMode.CREATIVE);
                p.getInventory().clear();
                Habilidade.setAbility(p, "Admin");
                p.setAllowFlight(true);
                p.getInventory().clear();
                p.updateInventory();
                final ItemStack prender = new ItemStack(Material.IRON_FENCE);
                final ItemMeta prendermeta = prender.getItemMeta();
                prendermeta.setDisplayName("§b§lPrender");
                prender.setItemMeta(prendermeta);
                final ItemStack troca = new ItemStack(Material.MAGMA_CREAM);
                final ItemMeta trocameta = troca.getItemMeta();
                trocameta.setDisplayName("§b§lTroca-Rapida");
                troca.setItemMeta(trocameta);
                final ItemStack autosoup = new ItemStack(Material.MUSHROOM_SOUP);
                final ItemMeta autosoupmeta = autosoup.getItemMeta();
                autosoupmeta.setDisplayName("§b§lAuto-Soup");
                autosoup.setItemMeta(autosoupmeta);
                p.getInventory().setItem(7, prender);
                p.getInventory().setItem(4, troca);
                p.getInventory().setItem(1, autosoup);
                p.updateInventory();
            }
            else {
                p.sendMessage(String.valueOf(Main.p) + " §7Voc\u00ea §csaiu §7no modo §6§lADMIN §7!");
                p.getInventory().clear();
                Habilidade.setAbility(p, "Nenhum");
                KitAPI.remove(p);
                Player[] onlinePlayers2;
                for (int length2 = (onlinePlayers2 = Bukkit.getOnlinePlayers()).length, j = 0; j < length2; ++j) {
                    final Player s = onlinePlayers2[j];
                    if (!s.hasPermission("kitpvp.admin")) {
                        s.showPlayer(p);
                    }
                }
                p.setGameMode(GameMode.SURVIVAL);
            }
        }
        return false;
    }
    
    @EventHandler
    public void Prender(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.IRON_FENCE && Habilidade.getAbility(p).equalsIgnoreCase("Admin")) {
            final Player t = (Player)e.getRightClicked();
            p.chat("/arena " + t.getName());
        }
    }
    
    @EventHandler
    public void AutoSoup(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.MUSHROOM_SOUP && Habilidade.getAbility(p).equalsIgnoreCase("Admin")) {
            final Player t = (Player)e.getRightClicked();
            p.chat("/autosoup " + t.getName());
        }
    }
    
    @EventHandler
    public void TrocaRapida(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.MAGMA_CREAM && Habilidade.getAbility(p).equalsIgnoreCase("Admin")) {
            Player[] onlinePlayers;
            for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
                final Player s = onlinePlayers[i];
                if (!s.hasPermission("kitpvp.admin")) {
                    s.showPlayer(p);
                }
            }
            p.setGameMode(GameMode.SURVIVAL);
            final ItemStack troca = new ItemStack(Material.SLIME_BALL);
            final ItemMeta trocameta = troca.getItemMeta();
            trocameta.setDisplayName("§b§lTroca-Rapida");
            troca.setItemMeta(trocameta);
            p.getInventory().setItem(4, troca);
            p.updateInventory();
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Admin.Admin$1(this, p), 15L);
        }
    }
    
    public static int getMaterial(final Player p, final Material m) {
        int value = 0;
        ItemStack[] contents;
        for (int length = (contents = p.getInventory().getContents()).length, i = 0; i < length; ++i) {
            final ItemStack item = contents[i];
            if (item != null && item.getType() == m && item.getAmount() > 0) {
                value += item.getAmount();
            }
        }
        return value;
    }
    
    @EventHandler
    public void Abririnv(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        if (e.getRightClicked() instanceof Player && e.getPlayer().getItemInHand().getType() == Material.AIR && Habilidade.getAbility(p).equalsIgnoreCase("Admin")) {
            final Player t = (Player)e.getRightClicked();
            e.getPlayer().openInventory((Inventory)t.getInventory());
        }
    }
}
