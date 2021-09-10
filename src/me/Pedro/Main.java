package me.Pedro;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.CommandExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import iLucasUS.Pedro.Lauchers.Diamante;
import iLucasUS.Pedro.Lauchers.Esmeralda;
import iLucasUS.Pedro.Lauchers.Ferro;
import iLucasUS.Pedro.Lauchers.Redstone;
import me.Pedro.CMD.Admin;
import me.Pedro.CMD.Aplicar;
import me.Pedro.CMD.Arena;
import me.Pedro.CMD.AutoSoup;
import me.Pedro.CMD.Build;
import me.Pedro.CMD.Chat;
import me.Pedro.CMD.Dano;
import me.Pedro.CMD.Fake;
import me.Pedro.CMD.Gamemode;
import me.Pedro.CMD.Kit;
import me.Pedro.CMD.MacroTest;
import me.Pedro.CMD.Ping;
import me.Pedro.CMD.Rankss;
import me.Pedro.CMD.Regras;
import me.Pedro.CMD.Report;
import me.Pedro.CMD.SetArena;
import me.Pedro.CMD.StaffChat;
import me.Pedro.CMD.Tag;
import me.Pedro.CMD.Tp;
import me.Pedro.CMD.Tpall;
import me.Pedro.CMD.Youtuber;
import me.Pedro.CMD.sKit;
import me.Pedro.Eventos.Abilidades;
import me.Pedro.Eventos.ChatFormat;
import me.Pedro.Eventos.DropEventos;
import me.Pedro.Eventos.Ip;
import me.Pedro.Eventos.KillEvent;
import me.Pedro.Eventos.KitAPI;
import me.Pedro.Eventos.Players;
import me.Pedro.Eventos.Plugins;
import me.Pedro.Eventos.Sopa;
import me.Pedro.Eventos.Tab;
import me.Pedro.Eventos.TheTitle;
import me.Pedro.Inventarios.Kits;
import me.Pedro.Inventarios.Menu;
import me.Pedro.Inventarios.MenuDeWarps;
import me.Pedro.Inventarios.MiniGamesInventario;
import me.Pedro.Inventarios.Ranks;
import me.Pedro.Minigames.ClickTest;
import me.Pedro.Minigames.Minigames;
import me.Pedro.Minigames.SetSpawn;
import me.Pedro.ScoreBoard.Status;
import me.Pedro.Ultis.Foguinho;
import me.Pedro.Ultis.N\u00e3oExplodirOMapa;
import me.Pedro.Ultis.Smoke;
import me.Pedro.Warps.SetFPS;
import me.Pedro.Warps.SetGlad;
import me.Pedro.Warps.SetKnock;
import me.Pedro.Warps.SetLavaChallenger;
import me.Pedro.Warps.SetMlg;
import me.Pedro.Warps.SetVoidChallenger;
import me.Pedro.Warps.irFPS;
import me.Pedro.Warps.irGlad;
import me.Pedro.Warps.irKnock;
import me.Pedro.Warps.irLavaFacil;
import me.Pedro.Warps.irMlg;
import me.Pedro.Warps.irSpawn;
import me.Pedro.Warps.irVoid;
import me.Pedro.XP.MyConfigManager;
import me.Pedro.XP.XpM;

public class Main extends JavaPlugin {
	public static Plugin plugin;
	public static Main instance;
	public static MyConfigManager manager;
	public static Integer score;
	public static String p;
	public static String semperm;
	public static ArrayList<String> ss;

	static {
		Main.score = null;
		Main.p = "§f§lGUCCI§6§lMC §7-";
		Main.semperm = "§f§lGUCCI§6§lMC §7-";
	}

	public static Main getInstance() {
		return Main.instance;
	}

	public static Plugin getPlugin() {
		return Main.plugin;
	}

	public void onEnable() {
		Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(Main.p) + "§A§lATIVADO");
		this.saveDefaultConfig();
		Main.instance = this;
		Main.plugin = (Plugin) this;
		this.getConfig().options().copyDefaults(true);
		this.getConfig().options().copyHeader(true);
		this.saveConfig();
		Main.manager = new MyConfigManager(this);
		XpM.loadMoneyManager();
		this.Eventos();
		this.Comandos();
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player all = onlinePlayers[i];
			all.teleport(all.getWorld().getSpawnLocation());
			KitAPI.remove(all);
			all.getInventory().clear();
			KitAPI.setitem(all, Material.BOOK, "§3§lMenu", 5, Enchantment.SILK_TOUCH, 0, false);
			KitAPI.setitem(all, Material.COMPASS, "§3§lWarps", 3, Enchantment.SILK_TOUCH, 0, false);
			KitAPI.setitem(all, Material.CHEST, "§3§lKits", 4, Enchantment.SILK_TOUCH, 0, false);
		}
	}

	public void onDisable() {
		Bukkit.getServer().getConsoleSender().sendMessage(String.valueOf(Main.p) + "§4§lDESATIVADO");
	}

	public void Eventos() {
		final PluginManager FanntPvP = Bukkit.getPluginManager();
		FanntPvP.registerEvents((Listener) new Players(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Minigames(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Menu(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new MiniGamesInventario(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new ClickTest(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new MenuDeWarps(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Ranks(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Kits(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Abilidades(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Sopa(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new DropEventos(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Smoke(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new N\u00e3oExplodirOMapa(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new KillEvent(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new StaffChat(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Foguinho(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Plugins(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Admin(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new MacroTest(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Status(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Arena(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new AutoSoup(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Tab(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new ChatFormat(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new TheTitle(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Build(), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Diamante(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Esmeralda(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Ferro(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Redstone(this), (Plugin) this);
		FanntPvP.registerEvents((Listener) new Ping(), (Plugin) this);
	}

	public void Comandos() {
		this.getCommand("sc").setExecutor((CommandExecutor) new StaffChat());
		this.getCommand("chat").setExecutor((CommandExecutor) new Chat(this));
		this.getCommand("regras").setExecutor((CommandExecutor) new Regras());
		this.getCommand("clicktest").setExecutor((CommandExecutor) new ClickTest(this));
		this.getCommand("setspawn").setExecutor((CommandExecutor) new SetSpawn(this));
		this.getCommand("glad").setExecutor((CommandExecutor) new irGlad(this));
		this.getCommand("setglad").setExecutor((CommandExecutor) new SetGlad(this));
		this.getCommand("setvoid").setExecutor((CommandExecutor) new SetVoidChallenger(this));
		this.getCommand("void").setExecutor((CommandExecutor) new irVoid(this));
		this.getCommand("macrotest").setExecutor((CommandExecutor) new MacroTest());
		this.getCommand("gm").setExecutor((CommandExecutor) new Gamemode());
		this.getCommand("spawn").setExecutor((CommandExecutor) new irSpawn(this));
		this.getCommand("fake").setExecutor((CommandExecutor) new Fake());
		this.getCommand("tp").setExecutor((CommandExecutor) new Tp());
		this.getCommand("tag").setExecutor((CommandExecutor) new Tag(this));
		this.getCommand("regras").setExecutor((CommandExecutor) new Regras());
		this.getCommand("ranks").setExecutor((CommandExecutor) new Rankss());
		this.getCommand("criarkit").setExecutor((CommandExecutor) new sKit(this));
		this.getCommand("setfps").setExecutor((CommandExecutor) new SetFPS(this));
		this.getCommand("dano").setExecutor((CommandExecutor) new Dano());
		this.getCommand("teleportall").setExecutor((CommandExecutor) new Tpall());
		this.getCommand("aplicar").setExecutor((CommandExecutor) new Aplicar());
		this.getCommand("report").setExecutor((CommandExecutor) new Report());
		this.getCommand("fps").setExecutor((CommandExecutor) new irFPS(this));
		this.getCommand("setknock").setExecutor((CommandExecutor) new SetKnock(this));
		this.getCommand("knock").setExecutor((CommandExecutor) new irKnock(this));
		this.getCommand("setmlg").setExecutor((CommandExecutor) new SetMlg(this));
		this.getCommand("mlg").setExecutor((CommandExecutor) new irMlg(this));
		this.getCommand("setchallenge").setExecutor((CommandExecutor) new SetLavaChallenger(this));
		this.getCommand("challenge").setExecutor((CommandExecutor) new irLavaFacil(this));
		this.getCommand("kit").setExecutor((CommandExecutor) new Kit(this));
		this.getCommand("setarena").setExecutor((CommandExecutor) new SetArena(this));
		this.getCommand("ip").setExecutor((CommandExecutor) new Ip());
		this.getCommand("youtuber").setExecutor((CommandExecutor) new Youtuber());
		this.getCommand("admin").setExecutor((CommandExecutor) new Admin());
		this.getCommand("autosoup").setExecutor((CommandExecutor) new AutoSoup(this));
		this.getCommand("arena").setExecutor((CommandExecutor) new Arena());
		this.getCommand("build").setExecutor((CommandExecutor) new Build());
		this.getCommand("ping").setExecutor((CommandExecutor) new Ping());
	}
}
