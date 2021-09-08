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

public class Menu implements Listener
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
    
    public static void Menu(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 54, "§3§lMenu");
        SetarItem(inv, p, Material.SKULL_ITEM, 1, 3, "§3§lMenu", "§c- §7Veja nosso menu!", 13);
        SetarItem(inv, p, Material.STONE_SWORD, 1, 0, "§3§lClickTest", "§c- §7Teste o seu click no servidor!", 31);
        SetarItem(inv, p, Material.MAGMA_CREAM, 1, 0, "§3§lRanks", "§c- §7Veja os ranks do servidor!", 33);
        SetarItem(inv, p, Material.BED, 1, 0, "§3§lFormul\u00e1rios", "§c- §7Veja os formul\u00e1rios do servidor!", 49);
        SetarItem(inv, p, Material.BOOK, 1, 0, "§3§lRegras", "§c- §7Veja as regras do servidor!", 29);
        p.openInventory(inv);
    }
    
    public static void Quests(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 54, "§3§lRegras");
        SetarItem(inv, p, Material.SKULL_ITEM, 1, 3, "§3lRegras", "§c- §7Veja nossas regras!", 13);
        SetarItem(inv, p, Material.STAINED_GLASS_PANE, 1, 5, "-", "", 16);
        SetarItem(inv, p, Material.STAINED_GLASS_PANE, 1, 14, "-", "", 10);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-1", "§7N\u00e3o utilizar qualquer tipo de §4HACK!", 29);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-2", "§7N\u00e3o divulgar qualquer §3tipo §7de servidor ou IP!", 30);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-3", "§7N\u00e3o abusar de §3bugs!", 31);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-4", "§7N\u00e3o ofender os §3jogadores!", 32);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-5", "§7N\u00e3o ofender §3staff!", 33);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-6", "§7N\u00e3o usar macro, nem qualquer tipo de §3estado §7que altere o jogo!", 37);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-7", "§7N\u00e3o §3forjar §7qualquer tipo de hack!", 38);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-8", "§7N\u00e3o §3atacar §7bot ou §3ddos §7no servidor!", 39);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 14, "§c§lREGRAS-9", "§7N\u00e3o ofender o servidor!", 40);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 3, "§c§lRECOMENDADO-1", "§7N\u00e3o se envolver em §3tretas!", 41);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 3, "§c§lRECOMENDADO-2", "§7N\u00e3o usar regedit, op ms, que altere seu §3knockback!", 42);
        SetarItem(inv, p, Material.STAINED_CLAY, 1, 3, "§c§lRECOMENDADO-3", "§7N\u00e3o pedir para ler seu §3formul\u00e1rio!", 43);
        p.openInventory(inv);
    }
    
    public static void Info(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 54, "§3§lFormul\u00e1rios");
        SetarItem(inv, p, Material.SKULL_ITEM, 1, 3, "§§lFormul\u00e1rios", "§c- §7Veja nossos formul\u00e1rios!", 13);
        SetarItem(inv, p, Material.STAINED_GLASS_PANE, 1, 5, "", "", 16);
        SetarItem(inv, p, Material.STAINED_GLASS_PANE, 1, 14, "", "", 10);
        SetarItem(inv, p, Material.WOOL, 1, 4, "§e§lBUILDER", "§7Fa\u00e7a o §3teste§7, com um jogador §3superior.", 39);
        SetarItem(inv, p, Material.WOOL, 1, 6, "§d§lTRIAL", "§ahttps://goo.gl/QsGpaU", 40);
        SetarItem(inv, p, Material.WOOL, 1, 3, "§1§lHELPER", "§7Ajude os §3jogadores§7, §7quando haver §epossibilidade.", 41);
        p.openInventory(inv);
    }
    
    public static void Ranks(final Player p) {
        final Inventory inv = Bukkit.createInventory((InventoryHolder)p, 54, "§3§lRanks");
        SetarItem(inv, p, Material.SKULL_ITEM, 1, 3, "§§lFormul\u00e1rios", "§c- §7Veja nossos formul\u00e1rios!", 13);
        SetarItem(inv, p, Material.STAINED_GLASS_PANE, 1, 5, "", "", 16);
        SetarItem(inv, p, Material.STAINED_GLASS_PANE, 1, 14, "", "", 10);
        SetarItem(inv, p, Material.IRON_CHESTPLATE, 1, 0, "§a§lRanks", "§c- §7Clique e veja os ranks!", 40);
        p.openInventory(inv);
    }
    
    @EventHandler
    public static void AbrirMenu(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) && p.getItemInHand().getType() == Material.BOOK) {
            Menu(p);
            p.playSound(p.getLocation(), Sound.LEVEL_UP, 5.0f, 5.0f);
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public static void ClicarMenu(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("§3§lMenu")) {
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lClickTest")) {
                p.chat("/clicktest");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                Menu(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                Menu(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lRegras")) {
                Quests(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lFormul\u00e1rios")) {
                Info(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lRanks")) {
                Ranks(p);
                e.setCancelled(true);
                return;
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public static void ClicarQuests(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("§3§lRegras")) {
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                Menu(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lAPLICAR")) {
                p.chat("/aplicar");
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("")) {
                p.chat("/main");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("")) {
                p.chat("/challenge");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("")) {
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
    public static void ClicarMenuGeral(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("§3§lMenu")) {
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                Menu(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lRanks")) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lRegras")) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lFormul\u00e1rios")) {
                e.setCancelled(true);
                return;
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public static void ClicarRanks(final InventoryClickEvent e) {
        final Player p = (Player)e.getWhoClicked();
        if (e.getInventory().getName().equalsIgnoreCase("§3§lRanks")) {
            if (e.getCurrentItem() == null) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.STAINED_GLASS_PANE) {
                Menu(p);
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getType() == Material.TRIPWIRE_HOOK) {
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§a§lRanks")) {
                p.chat("/ranks");
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lREGRAS")) {
                e.setCancelled(true);
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase("§3§lFORMULARIOS")) {
                p.closeInventory();
                e.setCancelled(true);
                return;
            }
            p.closeInventory();
            e.setCancelled(true);
        }
    }
}
