package me.Pedro.Eventos;

import java.util.concurrent.TimeUnit;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import java.util.List;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Bat;
import net.minecraft.server.v1_7_R4.EntityHuman;
import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
import org.bukkit.event.entity.PlayerLeashEntityEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.entity.Fireball;
import org.bukkit.plugin.Plugin;
import me.Pedro.Ultis.Raios;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.Color;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.entity.LivingEntity;
import org.bukkit.Sound;
import org.bukkit.Effect;
import org.bukkit.util.BlockIterator;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.ChatColor;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import java.util.Random;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import java.util.Iterator;
import org.bukkit.util.Vector;
import org.bukkit.entity.Entity;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.Location;
import org.bukkit.Bukkit;
import org.bukkit.event.block.Action;
import org.bukkit.Material;
import org.bukkit.event.player.PlayerInteractEvent;
import me.Pedro.Main;
import java.util.Map;
import org.bukkit.inventory.ItemStack;
import org.bukkit.entity.Snowball;
import java.util.ArrayList;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import java.util.HashMap;
import org.bukkit.event.Listener;

public class Abilidades implements Listener
{
    HashMap<Player, Item> c62;
    ArrayList<Player> qswqsq;
    public static ArrayList<String> gayddrf;
    ArrayList<Snowball> Soltou;
    public int id1;
    ArrayList<Snowball> Soltou1;
    public int id11;
    public int boost;
    public static ArrayList<String> Deshfire;
    static ArrayList<String> fall;
    public static HashMap<String, ItemStack[]> Armadura;
    public static HashMap<String, ItemStack[]> saveinv;
    public static HashMap<String, ItemStack[]> armadura;
    public static HashMap<String, ItemStack[]> Armadura2;
    public static ArrayList<String> wateratack;
    public static ArrayList<String> velotrol;
    public static ArrayList<Player> cantkanga;
    public static HashMap<Player, Integer> kanga;
    Map<Player, Cordinha> hooks;
    private HashMap<Player, Long> shift;
    public static ArrayList<String> particu;
    public static final HashMap<Player, Integer> countdown_id;
    
    static {
        Abilidades.gayddrf = new ArrayList<String>();
        Abilidades.Deshfire = new ArrayList<String>();
        Abilidades.fall = new ArrayList<String>();
        Abilidades.Armadura = new HashMap<String, ItemStack[]>();
        Abilidades.saveinv = new HashMap<String, ItemStack[]>();
        Abilidades.armadura = new HashMap<String, ItemStack[]>();
        Abilidades.Armadura2 = new HashMap<String, ItemStack[]>();
        Abilidades.wateratack = new ArrayList<String>();
        Abilidades.velotrol = new ArrayList<String>();
        Abilidades.cantkanga = new ArrayList<Player>();
        Abilidades.kanga = new HashMap<Player, Integer>();
        Abilidades.particu = new ArrayList<String>();
        countdown_id = new HashMap<Player, Integer>();
    }
    
    public Abilidades(final Main main) {
        this.c62 = new HashMap<Player, Item>();
        this.qswqsq = new ArrayList<Player>();
        this.Soltou = new ArrayList<Snowball>();
        this.Soltou1 = new ArrayList<Snowball>();
        this.boost = 6;
        this.hooks = new HashMap<Player, Cordinha>();
        this.shift = new HashMap<Player, Long>();
    }
    
    @EventHandler
    public void stomperApple(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.IRON_FENCE && KitAPI.Forcefield.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Tempo.cadd(p)) {
                p.sendMessage("§7Cooldown §c" + Tempo.time(p) + "s");
                return;
            }
            final Location loc = p.getLocation();
            Tempo.add(p, 60);
            KitAPI.Forcefielddano.add(p.getName());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$1(this, p), 200L);
        }
    }
    
    @EventHandler
    public void fraqueza(final PlayerMoveEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.Forcefielddano.contains(p.getName())) {
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (pertos instanceof Player) {
                    final Player perto = (Player)pertos;
                    if (KitAPI.Forcefield.contains(p.getName())) {
                        ((Player)pertos).damage(3.0);
                    }
                    pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
                    ((Player)pertos).sendMessage(String.valueOf(Main.p) + "§7A um forcefield te §cbatendo");
                    Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$2(this), 10L);
                }
            }
        }
    }
    
    @EventHandler
    public void run(final PlayerInteractEvent e) {
        if (!this.qswqsq.contains(e.getPlayer()) && e.getMaterial().equals((Object)Material.WOOD_BUTTON) && !Abilidades.gayddrf.contains(e.getPlayer().getName()) && KitAPI.C4.contains(e.getPlayer().getName())) {
            if (e.getAction().equals((Object)Action.LEFT_CLICK_AIR) || e.getAction().equals((Object)Action.LEFT_CLICK_BLOCK)) {
                this.c62.get(e.getPlayer()).remove();
                this.c62.remove(e.getPlayer());
                e.getPlayer().getItemInHand().setType(Material.SLIME_BALL);
                e.getPlayer().sendMessage(String.valueOf(Main.p) + "§7Voce removeu sua bomba!");
                KitAPI.C4.remove(e.getPlayer().getName());
            }
            else {
                this.c62.get(e.getPlayer()).getLocation().getWorld().createExplosion(this.c62.get(e.getPlayer()).getLocation(), 2.0f, true);
                this.c62.get(e.getPlayer()).remove();
                this.c62.remove(e.getPlayer());
                e.getPlayer().getItemInHand().setType(Material.SLIME_BALL);
                e.getPlayer().sendMessage(String.valueOf(Main.p) + "§7Kabum!");
                KitAPI.C4.remove(e.getPlayer().getName());
                Abilidades.gayddrf.add(e.getPlayer().getName());
                Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$3(this, e), 200L);
            }
        }
    }
    
    @EventHandler
    public void qswqsq(final PlayerInteractEvent e) {
        if (e.getMaterial().equals((Object)Material.SLIME_BALL) && !Abilidades.gayddrf.contains(e.getPlayer().getName()) && KitAPI.C4.contains(e.getPlayer().getName()) && (e.getAction().equals((Object)Action.RIGHT_CLICK_AIR) || e.getAction().equals((Object)Action.RIGHT_CLICK_BLOCK))) {
            final Item bomba = e.getPlayer().getWorld().dropItemNaturally(e.getPlayer().getLocation(), new ItemStack(Material.TNT));
            bomba.setVelocity(e.getPlayer().getLocation().getDirection().multiply(1.2));
            this.c62.put(e.getPlayer(), bomba);
            e.getPlayer().sendMessage(String.valueOf(Main.p) + "§7Voce lancou sua bomba!");
            e.getPlayer().getItemInHand().setType(Material.WOOD_BUTTON);
            e.getPlayer().updateInventory();
            KitAPI.C4.add(e.getPlayer().getName());
            this.qswqsq.add(e.getPlayer());
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$4(this, e), 10L);
        }
    }
    
    @EventHandler
    public void Bater(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player t = (Player)e.getDamager();
            if (KitAPI.getkit(t) == "Viper" && t.getItemInHand().getType() == Material.STONE_SWORD && new Random().nextInt(100) <= 40) {
                p.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 100, 0));
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGHEST)
    public void run(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.C4.contains(p.getName())) {
            this.c62.get(p).remove();
            this.c62.remove(p);
            KitAPI.C4.remove(e.getPlayer().getName());
        }
    }
    
    @EventHandler
    public void run(final PlayerPickupItemEvent e) {
        if (this.c62.containsValue(e.getItem())) {
            e.setCancelled(true);
        }
    }
    
    @EventHandler
    public void Trocar(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        final ItemStack Terra = new ItemStack(Material.GRASS);
        final ItemMeta terram = Terra.getItemMeta();
        terram.setDisplayName(ChatColor.DARK_GREEN + "Terra");
        Terra.setItemMeta(terram);
        final ItemStack Agua = new ItemStack(Material.LAPIS_BLOCK);
        final ItemMeta Aguam = Agua.getItemMeta();
        Aguam.setDisplayName(ChatColor.DARK_AQUA + "Agua");
        Agua.setItemMeta(Aguam);
        final ItemStack Aguac = new ItemStack(Material.BEACON);
        final ItemMeta Aguacm = Aguac.getItemMeta();
        Aguacm.setDisplayName(ChatColor.DARK_AQUA + "B");
        Aguac.setItemMeta(Aguacm);
        final ItemStack AR = new ItemStack(Material.WOOL);
        final ItemMeta ARm = AR.getItemMeta();
        ARm.setDisplayName("AR");
        AR.setItemMeta(ARm);
        final ItemStack Fogo = new ItemStack(Material.REDSTONE_BLOCK);
        final ItemMeta Fogom = Fogo.getItemMeta();
        Fogom.setDisplayName(ChatColor.RED + "Fogo");
        Fogo.setItemMeta(Fogom);
        if ((e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().getType() == Material.BEACON) {
            p.setItemInHand(AR);
            KitAPI.Ferro.add(p.getName());
        }
        else if (KitAPI.Ferro.contains(p.getName()) && (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().equals((Object)AR)) {
            p.setItemInHand(Agua);
            KitAPI.Ferro.remove(p.getName());
            KitAPI.Avatar2.add(p.getName());
        }
        else if (KitAPI.Avatar2.contains(p.getName()) && (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().equals((Object)Agua)) {
            p.setItemInHand(Terra);
            KitAPI.Avatar2.remove(p.getName());
            KitAPI.Terra.add(p.getName());
        }
        else if (KitAPI.Terra.contains(p.getName()) && KitAPI.Terra.contains(p.getName()) && (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().equals((Object)Terra)) {
            p.setItemInHand(Fogo);
            KitAPI.Terra.remove(p.getName());
            KitAPI.Red.add(p.getName());
        }
        else if (KitAPI.Red.contains(p.getName()) && (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().equals((Object)Fogo)) {
            p.setItemInHand(AR);
            KitAPI.Red.remove(p.getName());
            KitAPI.Ferro.add(p.getName());
        }
    }
    
    @EventHandler
    public void AvatarAr(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.Ferro.contains(p.getName()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().getType() == Material.WOOL) {
            event.setCancelled(true);
            if (!KitAPI.Tempo.contains(p)) {
                KitAPI.Tempo.add(p);
                final Vector Ferro = p.getLocation().getDirection().normalize().multiply(55);
                final Snowball FerroH = (Snowball)p.launchProjectile((Class)Snowball.class);
                FerroH.setVelocity(Ferro);
                FerroH.setMetadata("Ar", (MetadataValue)new FixedMetadataValue(Main.plugin, (Object)true));
                final Location pegou = p.getEyeLocation();
                final BlockIterator Ferrao = new BlockIterator(pegou, 0.0, 40);
                while (Ferrao.hasNext()) {
                    final Location Ferrao2 = Ferrao.next().getLocation();
                    final Effect camelo = Effect.STEP_SOUND;
                    p.playSound(p.getLocation(), Sound.STEP_WOOL, 5.5f, 5.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOL, 1.5f, 1.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOL, 2.5f, 2.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOL, 3.5f, 3.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOL, 4.5f, 4.5f);
                    p.getWorld().playEffect(Ferrao2, camelo, 35);
                }
                this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$5(this, p), 250L);
            }
            else {
                p.sendMessage("§7Cooldown");
            }
        }
    }
    
    @EventHandler
    public void EntityDamageEvent(final EntityDamageByEntityEvent event) {
        final Entity Tomou2 = event.getEntity();
        if (event.getDamager() instanceof Snowball) {
            final Snowball Tomou3 = (Snowball)event.getDamager();
            if (Tomou3.hasMetadata("Ar")) {
                event.setDamage(16.0);
                ((LivingEntity)Tomou2).addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100, 0), true);
            }
        }
    }
    
    @EventHandler
    public void AvatarAr1(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.Avatar2.contains(p.getName()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().getType() == Material.LAPIS_BLOCK) {
            event.setCancelled(true);
            if (!KitAPI.Tempo.contains(p)) {
                KitAPI.Tempo.add(p);
                final Vector Agua = p.getLocation().getDirection().normalize().multiply(55);
                final Snowball AguaH = (Snowball)p.launchProjectile((Class)Snowball.class);
                AguaH.setVelocity(Agua);
                AguaH.setMetadata("Agua", (MetadataValue)new FixedMetadataValue(Main.plugin, (Object)true));
                final Location pegou = p.getEyeLocation();
                final BlockIterator Aguao = new BlockIterator(pegou, 0.0, 40);
                while (Aguao.hasNext()) {
                    final Location Aguao2 = Aguao.next().getLocation();
                    final Effect camelo = Effect.STEP_SOUND;
                    p.playSound(p.getLocation(), Sound.STEP_WOOD, 5.5f, 5.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOD, 1.5f, 1.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOD, 2.5f, 2.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOD, 3.5f, 3.5f);
                    p.playSound(p.getLocation(), Sound.STEP_WOOD, 4.5f, 4.5f);
                    p.getWorld().playEffect(Aguao2, camelo, 9);
                }
                this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$6(this, p), 250L);
            }
            else {
                p.sendMessage("§7Cooldown");
            }
        }
    }
    
    @EventHandler
    public void EntityDamageEvent11(final EntityDamageByEntityEvent event) {
        final Entity Tomou2 = event.getEntity();
        if (event.getDamager() instanceof Snowball) {
            final Snowball Tomou3 = (Snowball)event.getDamager();
            if (Tomou3.hasMetadata("Agua")) {
                event.setDamage(11.0);
                ((LivingEntity)Tomou2).addPotionEffect(new PotionEffect(PotionEffectType.POISON, 300, 0), true);
                final Vector vector = Tomou2.getLocation().getDirection();
                vector.multiply(-1.0f);
                Tomou2.setVelocity(vector);
            }
        }
    }
    
    @EventHandler
    public void AvatarAr11(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.Red.contains(p.getName()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().getType() == Material.REDSTONE_BLOCK) {
            event.setCancelled(true);
            if (!KitAPI.Tempo.contains(p)) {
                KitAPI.Tempo.add(p);
                final Vector Fogo = p.getLocation().getDirection().normalize().multiply(55);
                final Snowball FogoH = (Snowball)p.launchProjectile((Class)Snowball.class);
                FogoH.setVelocity(Fogo);
                FogoH.setMetadata("Fogo", (MetadataValue)new FixedMetadataValue(Main.plugin, (Object)true));
                final Location pegou = p.getEyeLocation();
                final BlockIterator Fogao = new BlockIterator(pegou, 0.0, 40);
                while (Fogao.hasNext()) {
                    final Location Fogao2 = Fogao.next().getLocation();
                    final Effect camelo = Effect.STEP_SOUND;
                    p.playSound(p.getLocation(), Sound.FIRE, 5.5f, 5.5f);
                    p.playSound(p.getLocation(), Sound.FIRE, 1.5f, 1.5f);
                    p.playSound(p.getLocation(), Sound.FIRE, 2.5f, 2.5f);
                    p.playSound(p.getLocation(), Sound.FIRE, 3.5f, 3.5f);
                    p.playSound(p.getLocation(), Sound.FIRE, 4.5f, 4.5f);
                    p.getWorld().playEffect(Fogao2, camelo, 10);
                }
                this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$7(this, p), 250L);
            }
            else {
                p.sendMessage("§7Cooldown");
            }
        }
    }
    
    @EventHandler
    public void EntityDamageEvent1(final EntityDamageByEntityEvent event) {
        final Entity Tomou2 = event.getEntity();
        if (event.getDamager() instanceof Snowball) {
            final Snowball Tomou3 = (Snowball)event.getDamager();
            if (Tomou3.hasMetadata("Fogo")) {
                event.setDamage(12.0);
                Tomou2.setFireTicks(150);
            }
        }
    }
    
    @EventHandler
    public void AvatarTerra(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (KitAPI.Terra.contains(p.getName()) && (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) && KitAPI.avatar.contains(p.getName()) && p.getItemInHand().getType() == Material.GRASS) {
            event.setCancelled(true);
            if (!KitAPI.Tempo.contains(p)) {
                KitAPI.Tempo.add(p);
                final Vector Terra = p.getLocation().getDirection().normalize().multiply(55);
                final Snowball TerraH = (Snowball)p.launchProjectile((Class)Snowball.class);
                TerraH.setVelocity(Terra);
                TerraH.setMetadata("Terra", (MetadataValue)new FixedMetadataValue(Main.plugin, (Object)true));
                final Location pegou = p.getEyeLocation();
                final BlockIterator Terrao = new BlockIterator(pegou, 0.0, 40);
                while (Terrao.hasNext()) {
                    final Location Terrao2 = Terrao.next().getLocation();
                    final Effect camelo = Effect.STEP_SOUND;
                    p.playSound(p.getLocation(), Sound.STEP_GRASS, 5.5f, 5.5f);
                    p.playSound(p.getLocation(), Sound.STEP_GRASS, 1.5f, 1.5f);
                    p.playSound(p.getLocation(), Sound.STEP_GRASS, 2.5f, 2.5f);
                    p.playSound(p.getLocation(), Sound.STEP_GRASS, 3.5f, 3.5f);
                    p.playSound(p.getLocation(), Sound.STEP_GRASS, 4.5f, 4.5f);
                    p.getWorld().playEffect(Terrao2, camelo, 2);
                }
                this.id1 = Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$8(this, p), 250L);
            }
            else {
                p.sendMessage("§7Cooldown");
            }
        }
    }
    
    @EventHandler
    public void EntityDamageEvent111(final EntityDamageByEntityEvent event) {
        final Entity Tomou2 = event.getEntity();
        if (event.getDamager() instanceof Snowball) {
            final Snowball Tomou3 = (Snowball)event.getDamager();
            if (Tomou3.hasMetadata("Terra")) {
                event.setDamage(14.0);
                final Vector vector = Tomou2.getLocation().getDirection();
                vector.multiply(-3.2f);
                Tomou2.setVelocity(vector);
            }
        }
    }
    
    @EventHandler
    public void stomperApp7le(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.MAGMA_CREAM && KitAPI.Terrorista.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Tempo.cadd(p)) {
                p.sendMessage("§7Cooldown §c" + Tempo.time(p) + "s");
                return;
            }
            final Vector vector = p.getEyeLocation().getDirection();
            vector.multiply(0.0f);
            vector.setY(6.0f);
            p.setVelocity(vector);
            Tempo.add(p, 20);
        }
    }
    
    @EventHandler
    public void idknow(final EntityDamageEvent e) {
        if (e.getEntity() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION) {
                return;
            }
            if (KitAPI.Terrorista.contains(p.getName())) {
                e.setCancelled(true);
            }
            else {
                e.setDamage(e.getDamage() * 2.0);
            }
        }
    }
    
    @EventHandler
    public void stomper(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        final Player p = (Player)event.getEntity();
        if (KitAPI.Terrorista.contains(p.getName()) && event.getDamage() >= 8.0) {
            event.setDamage(8.0);
            for (final Entity e : p.getNearbyEntities(4.0, 4.0, 4.0)) {
                if (e instanceof Player && !((Player)e).isSneaking()) {
                    p.getWorld().createExplosion(p.getLocation(), 1.5f);
                }
            }
        }
    }
    
    @EventHandler
    public void DeshClick(final PlayerInteractEvent event) {
        final int fire = 6;
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.REDSTONE_BLOCK && KitAPI.DeshFire.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Tempo.cadd(p)) {
                p.sendMessage("§7Cooldown §c" + Tempo.time(p) + "s");
                return;
            }
            Tempo.add(p, 25);
            Abilidades.fall.add(p.getName());
            p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
            p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
            final Location loc = p.getLocation();
            for (final Entity pertos : p.getNearbyEntities(8.0, 8.0, 8.0)) {
                if (pertos instanceof Player) {
                    final Player perto = (Player)pertos;
                    ((Player)pertos).damage(10.0);
                    pertos.setVelocity(new Vector(0.1, 0.0, 0.1));
                    ((Player)pertos).setFireTicks(fire * 20);
                }
            }
            final ItemStack Capacete = new ItemStack(Material.LEATHER_HELMET);
            final LeatherArmorMeta kCapacete = (LeatherArmorMeta)Capacete.getItemMeta();
            kCapacete.setColor(Color.RED);
            Capacete.setItemMeta((ItemMeta)kCapacete);
            final ItemStack Peitoral = new ItemStack(Material.LEATHER_CHESTPLATE);
            final LeatherArmorMeta kPeitoral = (LeatherArmorMeta)Peitoral.getItemMeta();
            kPeitoral.setColor(Color.RED);
            Peitoral.setItemMeta((ItemMeta)kPeitoral);
            final ItemStack Calss = new ItemStack(Material.LEATHER_LEGGINGS);
            final LeatherArmorMeta kCalss = (LeatherArmorMeta)Calss.getItemMeta();
            kCalss.setColor(Color.RED);
            Calss.setItemMeta((ItemMeta)kCalss);
            final ItemStack Bota = new ItemStack(Material.LEATHER_BOOTS);
            final LeatherArmorMeta kBota = (LeatherArmorMeta)Capacete.getItemMeta();
            kBota.setColor(Color.RED);
            Bota.setItemMeta((ItemMeta)kBota);
            Abilidades.Armadura.put(p.getName(), p.getInventory().getArmorContents());
            p.getInventory().setHelmet(Capacete);
            p.getInventory().setChestplate(Peitoral);
            p.getInventory().setLeggings(Calss);
            p.getInventory().setBoots(Bota);
            p.updateInventory();
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$9(this, p), 100L);
        }
    }
    
    @EventHandler
    public void AiMeuCuv5(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL && Abilidades.fall.contains(p.getName())) {
            Abilidades.fall.remove(p.getName());
            e.setDamage(6.5);
        }
    }
    
    @EventHandler
    public void PlayerInteractEvt(final PlayerInteractEntityEvent e) {
        final Player p = e.getPlayer();
        final Player ent = (Player)e.getRightClicked();
        if (Tempo.cadd(p)) {
            p.sendMessage("§7Cooldown §c" + Tempo.time(p) + "s");
            return;
        }
        if (KitAPI.WaterBender.contains(p.getName()) && p.getItemInHand().getType() == Material.LAPIS_BLOCK) {
            Abilidades.wateratack.add(ent.getName());
            Raios.kitaguala(ent.getLocation());
            Tempo.add(p, 30);
            ent.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 50, 200));
            Bukkit.getScheduler().scheduleAsyncDelayedTask((Plugin)Main.instance, (Runnable)new Abilidades.Abilidades$10(this, ent), 40L);
        }
    }
    
    @EventHandler
    public void PlayerMov(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (Abilidades.wateratack.contains(p.getName())) {
            p.teleport((Entity)p);
        }
    }
    
    @EventHandler
    public void VelotrolClick(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.MINECART && KitAPI.Velotrol.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR) {
                event.setCancelled(true);
            }
            if (Tempo.cadd(p)) {
                p.sendMessage("§7Cooldown §c" + Tempo.time(p) + "s");
                return;
            }
            p.setVelocity(p.getEyeLocation().getDirection().multiply(this.boost).add(new Vector(0, 0, 0)));
            p.getPlayer().getWorld().playEffect(p.getPlayer().getLocation(), Effect.SMOKE, 10, 0);
            final Location loc = p.getLocation();
            Abilidades.velotrol.add(p.getName());
            Abilidades.fall.add(p.getName());
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$11(this, p), 15L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$12(this, p), 14L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$13(this, p), 13L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$14(this, p), 12L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$15(this, p), 11L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$16(this, p), 10L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$17(this, p), 9L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$18(this, p, loc), 30L);
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$19(this, p), 50L);
            p.getWorld().playSound(loc, Sound.ENDERMAN_TELEPORT, 5.0f, -5.0f);
            Tempo.add(p, 30);
        }
    }
    
    @EventHandler
    public void BloodClick(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (event.getPlayer().getItemInHand().getType() == Material.WOOD_HOE && KitAPI.BloodGun.contains(event.getPlayer().getName())) {
            if (event.getAction() == Action.RIGHT_CLICK_BLOCK || event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK) {
                event.setCancelled(true);
            }
            if (Tempo.cadd(p)) {
                p.sendMessage("§7Cooldown §c" + Tempo.time(p) + "s");
            }
            else {
                final Vector velo1 = p.getLocation().getDirection().normalize().multiply(10);
                final Fireball boladenve = (Fireball)p.launchProjectile((Class)Fireball.class);
                boladenve.setIsIncendiary(false);
                boladenve.setYield(0.0f);
                boladenve.setVelocity(velo1);
                final Location location = p.getEyeLocation();
                final BlockIterator blocksToAdd = new BlockIterator(location, 0.0, 30);
                while (blocksToAdd.hasNext()) {
                    final Location blockToAdd = blocksToAdd.next().getLocation();
                    final Effect a = Effect.STEP_SOUND;
                    p.getWorld().playEffect(blockToAdd, a, 152);
                    Tempo.add(p, 15);
                }
            }
        }
    }
    
    @EventHandler
    public void onAttemp(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            if (!KitAPI.Kangaroo.contains(e.getEntity())) {
                return;
            }
            Abilidades.cantkanga.add((Player)e.getEntity());
            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$20(this, e), 60L);
        }
    }
    
    @EventHandler
    public void onKangaroo(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (!KitAPI.Kangaroo.contains(p.getName())) {
            return;
        }
        if (p.getItemInHand().getType() != Material.FIREWORK) {
            return;
        }
        if (e.getAction() == Action.LEFT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR) {
            e.setCancelled(true);
            if (Abilidades.cantkanga.contains(p)) {
                return;
            }
            if (Abilidades.kanga.get(p) == 0) {
                return;
            }
            Abilidades.kanga.put(p, Abilidades.kanga.get(p) - 1);
            if (p.isSneaking()) {
                final Vector vector = p.getEyeLocation().getDirection();
                vector.multiply(1.35f);
                vector.setY(0.66);
                p.setVelocity(vector);
            }
            else {
                final Vector vector = p.getEyeLocation().getDirection();
                vector.multiply(0.6f);
                vector.setY(1.0f);
                p.setVelocity(vector);
            }
            p.setFallDistance(-5.0f);
        }
    }
    
    @EventHandler
    public void onFall(final EntityDamageEvent e) {
        final Player p;
        if (e.getEntity() instanceof Player && KitAPI.Kangaroo.contains(p = (Player)e.getEntity()) && e.getCause() == EntityDamageEvent.DamageCause.FALL && e.getDamage() > 7.0) {
            e.setCancelled(true);
            p.damage(7.0);
        }
    }
    
    @EventHandler
    public void onKangaMove(final PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (!KitAPI.Kangaroo.contains(p.getName())) {
            return;
        }
        if (p.isOnGround()) {
            Abilidades.kanga.put(p, 2);
        }
    }
    
    @EventHandler
    public void onSlot(final PlayerItemHeldEvent e) {
        if (this.hooks.containsKey(e.getPlayer())) {
            this.hooks.get(e.getPlayer()).remove();
            this.hooks.remove(e.getPlayer());
        }
    }
    
    @EventHandler
    public void GrapplerDamageNoLeash(final EntityDamageEvent event) {
        if (!(event.getEntity() instanceof Player)) {
            return;
        }
        final Player player = (Player)event.getEntity();
        if (event.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (this.hooks.containsKey(player) && this.hooks.get(player).isHooked() && event.getDamage() > 3.0) {
            event.setDamage(3.0);
        }
    }
    
    @EventHandler
    public void onMove(final PlayerMoveEvent e) {
        if (this.hooks.containsKey(e.getPlayer()) && !e.getPlayer().getItemInHand().getType().equals((Object)Material.LEASH)) {
            this.hooks.get(e.getPlayer()).remove();
            this.hooks.remove(e.getPlayer());
        }
    }
    
    @EventHandler
    public void onLeash(final PlayerLeashEntityEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.Grappler.contains(p.getName()) && e.getPlayer().getItemInHand().getType().equals((Object)Material.LEASH)) {
            e.setCancelled(true);
            e.getPlayer().updateInventory();
            e.setCancelled(true);
            if (!this.hooks.containsKey(p)) {
                return;
            }
            if (!this.hooks.get(p).isHooked()) {
                return;
            }
            final double t;
            final double d = t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
            final double v_x = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
            final double v_y = (1.0 + 0.03 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
            final double v_z = (1.0 + 0.07 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
            final Vector v = p.getVelocity();
            v.setX(v_x);
            v.setY(v_y);
            v.setZ(v_z);
            p.setVelocity(v);
        }
    }
    
    @EventHandler
    public void onClick(final PlayerInteractEvent e) {
        final Player p = e.getPlayer();
        if (KitAPI.Grappler.contains(p.getName()) && e.getPlayer().getItemInHand().getType().equals((Object)Material.LEASH)) {
            e.setCancelled(true);
            if (e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                if (this.hooks.containsKey(p)) {
                    this.hooks.get(p).remove();
                }
                final Cordinha nmsHook = new Cordinha(p.getWorld(), (EntityHuman)((CraftPlayer)p).getHandle());
                nmsHook.spawn(p.getEyeLocation().add(p.getLocation().getDirection().getX(), p.getLocation().getDirection().getY(), p.getLocation().getDirection().getZ()));
                nmsHook.move(p.getLocation().getDirection().getX() * 5.0, p.getLocation().getDirection().getY() * 5.0, p.getLocation().getDirection().getZ() * 5.0);
                this.hooks.put(p, nmsHook);
            }
            else {
                if (!this.hooks.containsKey(p)) {
                    return;
                }
                if (!this.hooks.get(p).isHooked()) {
                    return;
                }
                final double t;
                final double d = t = this.hooks.get(p).getBukkitEntity().getLocation().distance(p.getLocation());
                final double v_x = (1.0 + 0.2 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getX() - p.getLocation().getX()) / t;
                final double v_y = (1.0 + 0.03 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getY() - p.getLocation().getY()) / t;
                final double v_z = (1.0 + 0.2 * t) * (this.hooks.get(p).getBukkitEntity().getLocation().getZ() - p.getLocation().getZ()) / t;
                final Vector v = p.getVelocity();
                v.setX(v_x);
                v.setY(v_y);
                v.setZ(v_z);
                p.setVelocity(v);
            }
        }
    }
    
    @EventHandler
    public void Wrun(final PlayerInteractEvent event) {
        final Player p = event.getPlayer();
        if (!KitAPI.Batman.contains(p.getName())) {
            return;
        }
        if (p.getItemInHand().getType() != Material.BLAZE_ROD) {
            return;
        }
        if (Tempo.cadd(p)) {
            p.sendMessage("§7Cooldown §c" + Tempo.time(p) + "s");
            return;
        }
        Tempo.add(p, 30);
        final Location bat2l = new Location(p.getWorld(), p.getLocation().getX() - 1.0, p.getLocation().getY(), p.getLocation().getZ());
        final Location bat3l = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY(), p.getLocation().getZ());
        final Bat bat1 = (Bat)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(p.getLocation(), EntityType.BAT);
        final Bat bat2 = (Bat)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(bat2l, EntityType.BAT);
        final Bat bat3 = (Bat)Bukkit.getWorld(p.getWorld().getName()).spawnEntity(bat3l, EntityType.BAT);
        bat1.setVelocity(p.getEyeLocation().getDirection().multiply(5.0));
        bat2.setVelocity(p.getEyeLocation().getDirection().multiply(5.0));
        bat3.setVelocity(p.getEyeLocation().getDirection().multiply(5.0));
        bat1.setCustomName("§c§lasdsdk");
        bat2.setCustomName("§c§lasdsdk");
        bat3.setCustomName("Batman");
        bat1.setCustomNameVisible(true);
        bat2.setCustomNameVisible(true);
        bat3.setCustomNameVisible(true);
        p.getWorld().playSound(p.getLocation(), Sound.BAT_HURT, 5.0f, 5.0f);
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$21(this, p, bat1, bat2, bat3), 40L);
        while (!bat1.isDead()) {
            final List<Entity> prox = (List<Entity>)bat1.getNearbyEntities(3.0, 3.0, 3.0);
            final Iterator localIterator = prox.iterator();
            final Entity nearb = localIterator.next();
            if (nearb.equals(p)) {
                return;
            }
            ((Player)nearb).damage(1.0);
            localIterator.hasNext();
        }
        while (!bat2.isDead()) {
            final List<Entity> prox2 = (List<Entity>)bat1.getNearbyEntities(3.0, 3.0, 3.0);
            final Iterator localIterator2 = prox2.iterator();
            final Entity nearb2 = localIterator2.next();
            if (nearb2.equals(p)) {
                return;
            }
            ((Player)nearb2).damage(1.0);
            localIterator2.hasNext();
        }
        while (!bat3.isDead()) {
            final List<Entity> prox3 = (List<Entity>)bat1.getNearbyEntities(3.0, 3.0, 3.0);
            final Iterator localIterator3 = prox3.iterator();
            final Entity nearb3 = localIterator3.next();
            if (nearb3.equals(p)) {
                return;
            }
            ((Player)nearb3).damage(1.0);
            localIterator3.hasNext();
        }
    }
    
    @EventHandler
    public void anda(final PlayerRespawnEvent e) {
        KitAPI.FireBoost.remove(e.getPlayer().getName());
    }
    
    private int tickForSec(final int i) {
        return i * 20;
    }
    
    @EventHandler
    public void fireboost(final PlayerToggleSneakEvent e) {
        final Player p = e.getPlayer();
        if (e.isSneaking()) {
            if (KitAPI.FireBoost.contains(p.getName())) {
                this.shift.put(p, System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(15L));
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$22(this, p), (long)(this.tickForSec(10) / 4));
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$23(this, p), (long)(this.tickForSec(10) / 2));
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$24(this, p), (long)(this.tickForSec(10) / 2 + 50));
                Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$25(this, p), (long)this.tickForSec(10));
            }
            else if (this.shift.containsKey(p)) {
                this.shift.remove(p);
                p.sendMessage(String.valueOf(Main.p) + "§7Carregamento Cancelado");
            }
        }
    }
    
    public static void retirar(final Player p) {
        Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$26(p), 1000L);
    }
    
    @EventHandler
    public void fire(final EntityDamageEvent e) throws Exception {
        if (e.getEntity() instanceof Player & e.getCause() == EntityDamageEvent.DamageCause.FALL) {
            final Player p = (Player)e.getEntity();
            if (KitAPI.FireBoost.contains(p.getName())) {
                final double d = e.getDamage();
                radarEffect(p);
                for (final Entity alvo : p.getNearbyEntities(5.0, 5.0, 5.0)) {
                    if (alvo instanceof Player) {
                        if (!((Player)alvo).isSneaking()) {
                            ((Player)alvo).damage(5);
                            alvo.setFireTicks(200);
                            removecu(p);
                            radarEffect(p);
                        }
                        ((Player)alvo).playSound(alvo.getLocation(), Sound.FIRE, 4.0f, 4.0f);
                    }
                    else if (alvo instanceof LivingEntity) {
                        ((LivingEntity)alvo).damage(5);
                        alvo.setFireTicks(200);
                        removecu(p);
                    }
                    if (e.getDamage() >= 2.0) {
                        e.setDamage(2);
                        removecu(p);
                        p.playSound(p.getLocation(), Sound.FIRE, 4.0f, 4.0f);
                    }
                }
                if (e.getDamage() >= 2.0) {
                    e.setDamage(2);
                    removecu(p);
                    p.playSound(p.getLocation(), Sound.FIRE, 4.0f, 4.0f);
                }
            }
        }
    }
    
    @EventHandler
    public void quit(final PlayerQuitEvent e) {
        final Player p = e.getPlayer();
        KitAPI.FireBoost.remove(p.getName());
    }
    
    public static void radarEffect(final Player p) {
        final float radius = 0.2f;
        final double radialsPerStep = 0.174532925199433;
        if (!Abilidades.countdown_id.containsKey(p)) {
            final int i = Bukkit.getServer().getScheduler().runTaskTimer(Main.plugin, (Runnable)new Abilidades.Abilidades$27(p), 0L, 0L).getTaskId();
            Abilidades.countdown_id.put(p, i);
        }
        else {
            stopRotation(p);
        }
    }
    
    public static void stopRotation(final Player p) {
        if (Abilidades.countdown_id.containsKey(p)) {
            Bukkit.getServer().getScheduler().cancelTask((int)Abilidades.countdown_id.get(p));
            Abilidades.countdown_id.remove(p);
        }
    }
    
    public static void removecu(final Player p) {
        Bukkit.getScheduler().scheduleSyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$28(p), 30L);
    }
    
    @EventHandler
    public void AnchorEvent(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            final Player d = (Player)e.getDamager();
            if (KitAPI.Anchor.contains(d.getName())) {
                p.setVelocity(new Vector());
                Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$29(this, p), 1L);
            }
        }
    }
    
    @EventHandler
    public void AnchorKiller(final EntityDamageByEntityEvent e) {
        if (e.getEntity() instanceof Player && e.getDamager() instanceof Player) {
            final Player p = (Player)e.getEntity();
            if (KitAPI.Anchor.contains(p.getName())) {
                p.setVelocity(new Vector());
                Bukkit.getServer().getScheduler().scheduleAsyncDelayedTask(Main.plugin, (Runnable)new Abilidades.Abilidades$30(this, p), 1L);
            }
        }
    }
    
    @EventHandler(priority = EventPriority.HIGH)
    public void onPlayerStomp(final EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        final Player p = (Player)e.getEntity();
        if (e.getCause() != EntityDamageEvent.DamageCause.FALL) {
            return;
        }
        if (KitAPI.Stomper.contains(p.getName())) {
            for (final Entity ent : p.getNearbyEntities(4.0, 1.5, 4.0)) {
                if (ent instanceof Player) {
                    final Player plr = (Player)ent;
                    if (e.getDamage() <= 4.0) {
                        e.setCancelled(true);
                        return;
                    }
                    if (plr.isSneaking()) {
                        plr.damage(6.0, (Entity)p);
                        plr.sendMessage("§7Voc\u00ea foi stompado por:§c " + p.getName());
                    }
                    else {
                        plr.damage(e.getDamage(), (Entity)p);
                        plr.sendMessage("§7Voc\u00ea foi stompado por:§c " + p.getName());
                    }
                }
            }
            e.setDamage(4.0);
        }
    }
}
