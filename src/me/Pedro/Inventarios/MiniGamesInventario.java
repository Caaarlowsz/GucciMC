package me.Pedro.Inventarios;

import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Sound;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.meta.ItemMeta;
import java.util.List;
import java.util.ArrayList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.event.Listener;

public class MiniGamesInventario implements Listener
{
    public static void SetarItem(final Inventory inv, final Player p, final Material item, final int quantidade, final int data, final String nome, final String desc, final int slot) {
        final ItemStack icone = new ItemStack(item, quantidade, (short)data);
        final ItemMeta iconem = icone.getItemMeta();
        iconem.setDisplayName(nome);
        final ArrayList<String> lore = new ArrayList<String>();
        lore.add(desc);
        iconem.setLore((List)lore);
        icone.setItemMeta(iconem);
        inv.setItem(slot, icone);
    }
    
    public static void Warps(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 27, "§b§lWarps");
        SetarItem(inv, p, Material.SKULL, 1, 0, " ", " ", 4);
        SetarItem(inv, p, Material.FIREWORK_CHARGE, 1, 11, "-", "", 11);
        SetarItem(inv, p, Material.TRIPWIRE_HOOK, 1, 0, "§cFechar", "§c- §7Fechar o menu !", 13);
        SetarItem(inv, p, Material.FIREWORK_CHARGE, 1, 11, "-", "", 15);
        SetarItem(inv, p, Material.HOPPER, 1, 12, "§b§lExtras", "§7Extras do servidor.", 33);
        SetarItem(inv, p, Material.BOOK, 1, 12, "§b§l", "", 29);
        SetarItem(inv, p, Material.PISTON_BASE, 1, 12, "§b§l", "", 40);
        p.openInventory(inv);
    }
    
    public static void Treino(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 27, "§b§lExtras");
        SetarItem(inv, p, Material.TRIPWIRE_HOOK, 1, 0, "§cVoltar", "§c- §7Voltar ao menu de warps !", 4);
        SetarItem(inv, p, Material.ITEM_FRAME, 1, 0, "§c§lDONOS", "§c- §7Donos do servidor: reacteey e Fentangs", 14);
        SetarItem(inv, p, Material.MAGMA_CREAM, 1, 0, "§3§lCODERS", "§c- §7Coders do servidor: reacteey e iLucasUS", 11);
        SetarItem(inv, p, Material.NETHER_STAR, 1, 0, "§b§lFAKE", "§c- §7Nick aleat\u00f3rio de FAKE!", 15);
        SetarItem(inv, p, Material.REDSTONE_COMPARATOR, 1, 0, "§b§lRANK", "§c- §7BRZ V", 10);
        p.openInventory(inv);
    }
    
    public static void Eventos(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 27, "§b§lEventos");
        SetarItem(inv, p, Material.TRIPWIRE_HOOK, 1, 0, "§cVoltar", "§c- §7Voltar ao menu de warps !", 4);
        SetarItem(inv, p, Material.IRON_CHESTPLATE, 1, 0, "§b§lSkit", "§c- §7Clique para ir ao evento skit !", 11);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§b§lMdr", "§c- §7Clique para ir ao evento mdr !", 15);
        SetarItem(inv, p, Material.DIAMOND_SWORD, 1, 0, "§b§lRdm", "§c- §7Clique para ir ao evento rdm !", 22);
        p.openInventory(inv);
    }
    
    @EventHandler
    public static void AbrirWarps(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.ENCHANTED_BOOK) {
            Warps(p);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public static void ClicarWarps(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("§b§lWarps")) {
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                Warps(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lTREINO")) {
                Treino(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lEVENTOS")) {
                Eventos(p);
                e.setCancelled(true);
                return;
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public static void ClicarTreino(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("§b§lTreino")) {
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                Warps(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                Warps(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lFps")) {
                p.chat("/fps");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lMain")) {
                p.chat("/main");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lLavaChallenger")) {
                p.chat("/challenge");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§l1v1")) {
                p.chat("/1v1");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public static void ClicarEventos(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("§b§lEventos")) {
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                Warps(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                Warps(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lMdr")) {
                p.chat("mdr");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lRdm")) {
                p.chat("/rdm");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§b§lSkit")) {
                p.chat("/skit");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
}
