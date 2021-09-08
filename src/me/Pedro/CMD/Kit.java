package me.Pedro.CMD;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.Material;
import me.Pedro.ScoreBoard.Habilidade;
import org.bukkit.GameMode;
import me.Pedro.Eventos.KitAPI;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import me.Pedro.Main;
import org.bukkit.event.Listener;
import org.bukkit.command.CommandExecutor;

public class Kit implements CommandExecutor, Listener
{
    public Kit(final Main main) {
    }
    
    public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
        final Player p = (Player)sender;
        if (label.equalsIgnoreCase("kit")) {
            if (args.length == 0) {
                p.sendMessage(String.valueOf(Main.p) + "§7 Use /Kit [habilidade]");
                return true;
            }
            if (KitAPI.Kit.contains(p.getName())) {
                p.sendMessage(String.valueOf(Main.p) + "Voc\u00ea j\u00e1 esta usando um kit!");
                return true;
            }
            if (args[0].equalsIgnoreCase("pvp")) {
                if (p.hasPermission("kit.pvp")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "PvP");
                    KitAPI.Kit.add(p.getName());
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l PvP");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Forcefield")) {
                if (p.hasPermission("kit.Forcefield")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Forcefield");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Forcefield.add(p.getName());
                    KitAPI.setitem(p, Material.IRON_FENCE, "§BForeField", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Forcefield");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("C4")) {
                if (p.hasPermission("kit.C4")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "C4");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.C4.add(p.getName());
                    KitAPI.setitem(p, Material.SLIME_BALL, "§BC4", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l C4");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Avatar")) {
                if (p.hasPermission("kit.Avatar")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Avatar");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.avatar.add(p.getName());
                    KitAPI.setitem(p, Material.BEACON, "§BAvatar", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Avatar");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Terrorista")) {
                if (p.hasPermission("kit.Terrorista")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Terrorista");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Terrorista.add(p.getName());
                    KitAPI.setitem(p, Material.MAGMA_CREAM, "§BTerroristar", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Terrorista");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("WaterBender")) {
                if (p.hasPermission("kit.WaterBender")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "WaterBender");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.WaterBender.add(p.getName());
                    KitAPI.setitem(p, Material.LAPIS_BLOCK, "§BWaterBender", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l WaterBender");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("DeshFire")) {
                if (p.hasPermission("kit.DeshFirer")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "DeshFire");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.DeshFire.add(p.getName());
                    KitAPI.setitem(p, Material.REDSTONE_BLOCK, "§BDeshFire", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l DeshFire");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("BloodGun")) {
                if (p.hasPermission("kit.BloodGun")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "BloodGun");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.BloodGun.add(p.getName());
                    KitAPI.setitem(p, Material.WOOD_HOE, "§BBloodGun", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l BloodGun");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Velotrol")) {
                if (p.hasPermission("kit.Velotrol")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Velotrol");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Velotrol.add(p.getName());
                    KitAPI.setitem(p, Material.MINECART, "§BVelotrol", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Velotrol");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Grappler")) {
                if (p.hasPermission("kit.Grappler")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Grappler");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Grappler.add(p.getName());
                    KitAPI.setitem(p, Material.LEASH, "§BGrappler", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Grappler");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("QuickDropper")) {
                if (p.hasPermission("kit.QuickDropper")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "QuickDropper");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.QuickDropper.add(p.getName());
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l QuickDropper");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("FireBoost")) {
                if (p.hasPermission("kit.FireBoost")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "FireBoost");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.FireBoost.add(p.getName());
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l FireBoost");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Kangaroo")) {
                if (p.hasPermission("kit.Kangaroo")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Kangaroo");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Kangaroo.add(p.getName());
                    KitAPI.setitem(p, Material.FIREWORK, "§BKangaroo", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Kangaroo");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Batman")) {
                if (p.hasPermission("kit.Batman")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Batman");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Batman.add(p.getName());
                    KitAPI.setitem(p, Material.BLAZE_ROD, "§BBatman", 1, Enchantment.DAMAGE_ALL, 1, true);
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Batman");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Anchor")) {
                if (p.hasPermission("kit.Anchor")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Anchor");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Anchor.add(p.getName());
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Anchor");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Stomper")) {
                if (p.hasPermission("kit.Stomper")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Stomper");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Stomper.add(p.getName());
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Stomper");
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Smoke")) {
                if (p.hasPermission("kit.Smoke")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Smoke");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Smoke.add(p.getName());
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Smoke");
                    KitAPI.setitem(p, Material.FLINT, "§BKit", 1, Enchantment.DAMAGE_ALL, 1, true);
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
            if (args[0].equalsIgnoreCase("Foguinho")) {
                if (p.hasPermission("kit.Foguinho")) {
                    p.getInventory().clear();
                    KitAPI.sopa(p);
                    KitAPI.GiveKit(p);
                    p.setGameMode(GameMode.SURVIVAL);
                    SetArena.TeleportArenaRandom(p);
                    Habilidade.setAbility(p, "Foguinho");
                    KitAPI.Kit.add(p.getName());
                    KitAPI.Foguinho.add(p.getName());
                    p.sendMessage(String.valueOf(Main.p) + "§7Voce pegou o Kit§a§l Foguinho");
                    KitAPI.setitem(p, Material.MAGMA_CREAM, "§BKit", 1, Enchantment.DAMAGE_ALL, 1, true);
                }
                else {
                    p.sendMessage(Main.semperm);
                }
            }
        }
        return false;
    }
}
