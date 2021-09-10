package me.Pedro.CMD;

import java.util.Random;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.Pedro.Main;

public class SetArena implements CommandExecutor {
	public static Main plugin;

	public SetArena(final Main main) {
		SetArena.plugin = main;
	}

	public boolean onCommand(final CommandSender Sender, final Command Cmd, final String Label, final String[] Args) {
		final Player p = (Player) Sender;
		if (Cmd.getName().equalsIgnoreCase("SetArena") && !p.hasPermission("kitpvp.setarena")) {
			p.sendMessage(Main.semperm);
			return true;
		}
		if (Args.length == 0) {
			p.sendMessage(String.valueOf(Main.p) + "§7Ultilize /setarena 1 a 10");
			return true;
		}
		if (Args[0].equalsIgnoreCase("1")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena1.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena1.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena1.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena1.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena1.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena1.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("2")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena2.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena2.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena2.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena2.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena2.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena2.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("3")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena3.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena3.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena3.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena3.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena3.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena3.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("4")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena4.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena4.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena4.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena4.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena4.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena4.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("5")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena5.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena5.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena5.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena5.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena5.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena5.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("6")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena6.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena6.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena6.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena6.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena6.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena6.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("7")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena7.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena7.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena7.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena7.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena7.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena7.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("8")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena8.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena8.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena8.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena8.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena8.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena8.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("9")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena9.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena9.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena9.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena9.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena9.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena9.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		if (Args[0].equalsIgnoreCase("10")) {
			p.sendMessage(String.valueOf(Main.p) + "§7Voce setou a arena");
			SetArena.plugin.getConfig().set("Arena10.x", (Object) p.getLocation().getX());
			SetArena.plugin.getConfig().set("Arena10.y", (Object) p.getLocation().getY());
			SetArena.plugin.getConfig().set("Arena10.z", (Object) p.getLocation().getZ());
			p.getWorld();
			SetArena.plugin.getConfig().set("Arena10.pitch", (Object) p.getLocation().getPitch());
			SetArena.plugin.getConfig().set("Arena10.yaw", (Object) p.getLocation().getYaw());
			SetArena.plugin.getConfig().set("Arena10.world", (Object) p.getLocation().getWorld().getName());
			SetArena.plugin.saveConfig();
		}
		return false;
	}

	public static void TeleportArenaRandom(final Player p) {
		final Random dice = new Random();
		final int number = dice.nextInt(9);
		switch (number) {
		case 0: {
			final World w = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena1.world"));
			final double x = SetArena.plugin.getConfig().getDouble("Arena1.x");
			final double y = SetArena.plugin.getConfig().getDouble("Arena1.y");
			final double z = SetArena.plugin.getConfig().getDouble("Arena1.z");
			final Location lobby = new Location(w, x, y, z);
			lobby.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena1.pitch"));
			lobby.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena1.yaw"));
			p.teleport(lobby);
			break;
		}
		case 1: {
			final World w2 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena2.world"));
			final double x2 = SetArena.plugin.getConfig().getDouble("Arena2.x");
			final double y2 = SetArena.plugin.getConfig().getDouble("Arena2.y");
			final double z2 = SetArena.plugin.getConfig().getDouble("Arena2.z");
			final Location lobby2 = new Location(w2, x2, y2, z2);
			lobby2.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena2.pitch"));
			lobby2.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena2.yaw"));
			p.teleport(lobby2);
			break;
		}
		case 2: {
			final World w3 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena3.world"));
			final double x3 = SetArena.plugin.getConfig().getDouble("Arena3.x");
			final double y3 = SetArena.plugin.getConfig().getDouble("Arena3.y");
			final double z3 = SetArena.plugin.getConfig().getDouble("Arena3.z");
			final Location lobby3 = new Location(w3, x3, y3, z3);
			lobby3.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena3.pitch"));
			lobby3.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena3.yaw"));
			p.teleport(lobby3);
			break;
		}
		case 3: {
			final World w4 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena4.world"));
			final double x4 = SetArena.plugin.getConfig().getDouble("Arena4.x");
			final double y4 = SetArena.plugin.getConfig().getDouble("Arena4.y");
			final double z4 = SetArena.plugin.getConfig().getDouble("Arena4.z");
			final Location lobby4 = new Location(w4, x4, y4, z4);
			lobby4.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena4.pitch"));
			lobby4.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena4.yaw"));
			p.teleport(lobby4);
			break;
		}
		case 4: {
			final World w5 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena5.world"));
			final double x5 = SetArena.plugin.getConfig().getDouble("Arena5.x");
			final double y5 = SetArena.plugin.getConfig().getDouble("Arena5.y");
			final double z5 = SetArena.plugin.getConfig().getDouble("Arena5.z");
			final Location lobby5 = new Location(w5, x5, y5, z5);
			lobby5.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena5.pitch"));
			lobby5.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena5.yaw"));
			p.teleport(lobby5);
			break;
		}
		case 5: {
			final World w6 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena6.world"));
			final double x6 = SetArena.plugin.getConfig().getDouble("Arena6.x");
			final double y6 = SetArena.plugin.getConfig().getDouble("Arena6.y");
			final double z6 = SetArena.plugin.getConfig().getDouble("Arena6.z");
			final Location lobby6 = new Location(w6, x6, y6, z6);
			lobby6.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena6.pitch"));
			lobby6.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena6.yaw"));
			p.teleport(lobby6);
			break;
		}
		case 6: {
			final World w7 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena7.world"));
			final double x7 = SetArena.plugin.getConfig().getDouble("Arena7.x");
			final double y7 = SetArena.plugin.getConfig().getDouble("Arena7.y");
			final double z7 = SetArena.plugin.getConfig().getDouble("Arena7.z");
			final Location lobby7 = new Location(w7, x7, y7, z7);
			lobby7.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena7.pitch"));
			lobby7.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena7.yaw"));
			p.teleport(lobby7);
			break;
		}
		case 7: {
			final World w8 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena8.world"));
			final double x8 = SetArena.plugin.getConfig().getDouble("Arena8.x");
			final double y8 = SetArena.plugin.getConfig().getDouble("Arena8.y");
			final double z8 = SetArena.plugin.getConfig().getDouble("Arena8.z");
			final Location lobby8 = new Location(w8, x8, y8, z8);
			lobby8.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena8.pitch"));
			lobby8.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena8.yaw"));
			p.teleport(lobby8);
			break;
		}
		case 8: {
			final World w9 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena9.world"));
			final double x9 = SetArena.plugin.getConfig().getDouble("Arena9.x");
			final double y9 = SetArena.plugin.getConfig().getDouble("Arena9.y");
			final double z9 = SetArena.plugin.getConfig().getDouble("Arena9.z");
			final Location lobby9 = new Location(w9, x9, y9, z9);
			lobby9.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena9.pitch"));
			lobby9.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena9.yaw"));
			p.teleport(lobby9);
			break;
		}
		case 9: {
			final World w10 = Bukkit.getServer().getWorld(SetArena.plugin.getConfig().getString("Arena10.world"));
			final double x10 = SetArena.plugin.getConfig().getDouble("Arena10.x");
			final double y10 = SetArena.plugin.getConfig().getDouble("Arena10.y");
			final double z10 = SetArena.plugin.getConfig().getDouble("Arena10.z");
			final Location lobby10 = new Location(w10, x10, y10, z10);
			lobby10.setPitch((float) SetArena.plugin.getConfig().getDouble("Arena10.pitch"));
			lobby10.setYaw((float) SetArena.plugin.getConfig().getDouble("Arena10.yaw"));
			p.teleport(lobby10);
			break;
		}
		}
	}
}
