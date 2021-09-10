package me.Pedro.Ultis;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public enum ParticleEffect {
	HUGE_EXPLOSION("HUGE_EXPLOSION", 0, "hugeexplosion"), LARGE_EXPLODE("LARGE_EXPLODE", 1, "largeexplode"),
	FIREWORKS_SPARK("FIREWORKS_SPARK", 2, "fireworksSpark"), BUBBLE("BUBBLE", 3, "bubble"),
	SUSPEND("SUSPEND", 4, "suspend"), DEPTH_SUSPEND("DEPTH_SUSPEND", 5, "depthSuspend"),
	TOWN_AURA("TOWN_AURA", 6, "townaura"), CRIT("CRIT", 7, "crit"), MAGIC_CRIT("MAGIC_CRIT", 8, "magicCrit"),
	SMOKE("SMOKE", 9, "smoke"), MOB_SPELL("MOB_SPELL", 10, "mobSpell"),
	MOB_SPELL_AMBIENT("MOB_SPELL_AMBIENT", 11, "mobSpellAmbient"), SPELL("SPELL", 12, "spell"),
	INSTANT_SPELL("INSTANT_SPELL", 13, "instantSpell"), WITCH_MAGIC("WITCH_MAGIC", 14, "witchMagic"),
	NOTE("NOTE", 15, "note"), PORTAL("PORTAL", 16, "portal"),
	ENCHANTMENT_TABLE("ENCHANTMENT_TABLE", 17, "enchantmenttable"), EXPLODE("EXPLODE", 18, "explode"),
	FLAME("FLAME", 19, "flame"), LAVA("LAVA", 20, "lava"), FOOTSTEP("FOOTSTEP", 21, "footstep"),
	SPLASH("SPLASH", 22, "splash"), WAKE("WAKE", 23, "wake"), LARGE_SMOKE("LARGE_SMOKE", 24, "largesmoke"),
	CLOUD("CLOUD", 25, "cloud"), RED_DUST("RED_DUST", 26, "reddust"),
	SNOWBALL_POOF("SNOWBALL_POOF", 27, "snowballpoof"), DRIP_WATER("DRIP_WATER", 28, "dripWater"),
	DRIP_LAVA("DRIP_LAVA", 29, "dripLava"), SNOW_SHOVEL("SNOW_SHOVEL", 30, "snowshovel"), SLIME("SLIME", 31, "slime"),
	HEART("HEART", 32, "heart"), ANGRY_VILLAGER("ANGRY_VILLAGER", 33, "angryVillager"),
	HAPPY_VILLAGER("HAPPY_VILLAGER", 34, "happyVillager");

	private static Constructor<?> packetPlayOutWorldParticles;
	private static Method getHandle;
	private static Field playerConnection;
	private static Method sendPacket;
	private static final Map<String, ParticleEffect> NAME_MAP;
	private final String name;

	static {
		NAME_MAP = new HashMap<String, ParticleEffect>();
		ParticleEffect[] values;
		for (int length = (values = values()).length, i = 0; i < length; ++i) {
			final ParticleEffect p = values[i];
			ParticleEffect.NAME_MAP.put(p.name, p);
		}
		try {
			ParticleEffect.packetPlayOutWorldParticles = ReflectionHandler.getConstructor(
					ReflectionHandler.PacketType.PLAY_OUT_WORLD_PARTICLES.getPacket(),
					new Class[] { String.class, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE, Float.TYPE,
							Float.TYPE, Integer.TYPE });
			ParticleEffect.getHandle = ReflectionHandler.getMethod("CraftPlayer",
					ReflectionHandler.SubPackageType.ENTITY, "getHandle", new Class[0]);
			ParticleEffect.playerConnection = ReflectionHandler.getField("EntityPlayer",
					ReflectionHandler.PackageType.MINECRAFT_SERVER, "playerConnection");
			ParticleEffect.sendPacket = ReflectionHandler.getMethod(ParticleEffect.playerConnection.getType(),
					"sendPacket", new Class[] {
							ReflectionHandler.getClass("Packet", ReflectionHandler.PackageType.MINECRAFT_SERVER) });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private ParticleEffect(final String s, final int n, final String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public static ParticleEffect fromName(final String name) {
		if (name != null) {
			for (final Map.Entry<String, ParticleEffect> e : ParticleEffect.NAME_MAP.entrySet()) {
				if (e.getKey().equalsIgnoreCase(name)) {
					return e.getValue();
				}
			}
		}
		return null;
	}

	private static List<Player> getPlayers(final Location center, final double range) {
		final List<Player> players = new ArrayList<Player>();
		final String name = center.getWorld().getName();
		final double squared = range * range;
		Player[] onlinePlayers;
		for (int length = (onlinePlayers = Bukkit.getOnlinePlayers()).length, i = 0; i < length; ++i) {
			final Player p = onlinePlayers[i];
			if (p.getWorld().getName().equals(name) && p.getLocation().distanceSquared(center) <= squared) {
				players.add(p);
			}
		}
		return players;
	}

	private static Object instantiatePacket(final String name, final Location center, final float offsetX,
			final float offsetY, final float offsetZ, final float speed, final int amount) {
		if (amount < 1) {
			throw new PacketInstantiationException("Amount cannot be lower than 1");
		}
		try {
			return ParticleEffect.packetPlayOutWorldParticles.newInstance(name, (float) center.getX(),
					(float) center.getY(), (float) center.getZ(), offsetX, offsetY, offsetZ, speed, amount);
		} catch (Exception e) {
			throw new PacketInstantiationException("Packet instantiation failed", e);
		}
	}

	private static Object instantiateIconCrackPacket(final int id, final Location center, final float offsetX,
			final float offsetY, final float offsetZ, final float speed, final int amount) {
		return instantiatePacket("iconcrack_" + id, center, offsetX, offsetY, offsetZ, speed, amount);
	}

	private static Object instantiateBlockCrackPacket(final int id, final byte data, final Location center,
			final float offsetX, final float offsetY, final float offsetZ, final int amount) {
		return instantiatePacket("blockcrack_" + id + "_" + data, center, offsetX, offsetY, offsetZ, 0.0f, amount);
	}

	private static Object instantiateBlockDustPacket(final int id, final byte data, final Location center,
			final float offsetX, final float offsetY, final float offsetZ, final float speed, final int amount) {
		return instantiatePacket("blockdust_" + id + "_" + data, center, offsetX, offsetY, offsetZ, speed, amount);
	}

	private static void sendPacket(final Player p, final Object packet) {
		try {
			ParticleEffect.sendPacket.invoke(
					ParticleEffect.playerConnection.get(ParticleEffect.getHandle.invoke(p, new Object[0])), packet);
		} catch (Exception e) {
			throw new PacketSendingException("Failed to send a packet to player '" + p.getName() + "'", e);
		}
	}

	private static void sendPacket(final Collection<Player> players, final Object packet) {
		for (final Player p : players) {
			sendPacket(p, packet);
		}
	}

	public void display(final Location center, final float offsetX, final float offsetY, final float offsetZ,
			final float speed, final int amount, final Player players) {
		sendPacket(Arrays.asList(players),
				instantiatePacket(this.name, center, offsetX, offsetY, offsetZ, speed, amount));
	}

	public void display(final Location center, final double range, final float offsetX, final float offsetY,
			final float offsetZ, final float speed, final int amount) {
		if (range > 16.0) {
			throw new IllegalArgumentException("Range cannot exceed the maximum value of 16");
		}
		sendPacket(getPlayers(center, range),
				instantiatePacket(this.name, center, offsetX, offsetY, offsetZ, speed, amount));
	}

	public void display(final Location center, final float offsetX, final float offsetY, final float offsetZ,
			final float speed, final int amount) {
		this.display(center, 16.0, offsetX, offsetY, offsetZ, speed, amount);
	}

	public static void displayIconCrack(final Location center, final int id, final float offsetX, final float offsetY,
			final float offsetZ, final float speed, final int amount, final Player[] players) {
		sendPacket(Arrays.asList(players),
				instantiateIconCrackPacket(id, center, offsetX, offsetY, offsetZ, speed, amount));
	}

	public static void displayIconCrack(final Location center, final double range, final int id, final float offsetX,
			final float offsetY, final float offsetZ, final float speed, final int amount) {
		if (range > 16.0) {
			throw new IllegalArgumentException("Range has to be lower/equal the maximum of 16");
		}
		sendPacket(getPlayers(center, range),
				instantiateIconCrackPacket(id, center, offsetX, offsetY, offsetZ, speed, amount));
	}

	public static void displayIconCrack(final Location center, final int id, final float offsetX, final float offsetY,
			final float offsetZ, final float speed, final int amount) {
		displayIconCrack(center, 16.0, id, offsetX, offsetY, offsetZ, speed, amount);
	}

	public static void displayBlockCrack(final Location center, final int id, final byte data, final float offsetX,
			final float offsetY, final float offsetZ, final int amount, final Player[] players) {
		sendPacket(Arrays.asList(players),
				instantiateBlockCrackPacket(id, data, center, offsetX, offsetY, offsetZ, amount));
	}

	public static void displayBlockCrack(final Location center, final double range, final int id, final byte data,
			final float offsetX, final float offsetY, final float offsetZ, final int amount) {
		if (range > 16.0) {
			throw new IllegalArgumentException("Range has to be lower/equal the maximum of 16");
		}
		sendPacket(getPlayers(center, range),
				instantiateBlockCrackPacket(id, data, center, offsetX, offsetY, offsetZ, amount));
	}

	public static void displayBlockCrack(final Location center, final int id, final byte data, final float offsetX,
			final float offsetY, final float offsetZ, final int amount) {
		displayBlockCrack(center, 16.0, id, data, offsetX, offsetY, offsetZ, amount);
	}

	public static void displayBlockDust(final Location center, final int id, final byte data, final float offsetX,
			final float offsetY, final float offsetZ, final float speed, final int amount, final Player[] players) {
		sendPacket(Arrays.asList(players),
				instantiateBlockDustPacket(id, data, center, offsetX, offsetY, offsetZ, speed, amount));
	}

	public static void displayBlockDust(final Location center, final double range, final int id, final byte data,
			final float offsetX, final float offsetY, final float offsetZ, final float speed, final int amount) {
		if (range > 16.0) {
			throw new IllegalArgumentException("Range has to be lower/equal the maximum of 16");
		}
		sendPacket(getPlayers(center, range),
				instantiateBlockDustPacket(id, data, center, offsetX, offsetY, offsetZ, speed, amount));
	}

	public static void displayBlockDust(final Location center, final int id, final byte data, final float offsetX,
			final float offsetY, final float offsetZ, final float speed, final int amount) {
		displayBlockDust(center, 16.0, id, data, offsetX, offsetY, offsetZ, speed, amount);
	}

	private static final class PacketInstantiationException extends RuntimeException {
		private static final long serialVersionUID = 3203085387160737484L;

		public PacketInstantiationException(final String message) {
		}

		public PacketInstantiationException(final String message, final Throwable cause) {
			super(cause);
		}
	}

	private static final class PacketSendingException extends RuntimeException {
		private static final long serialVersionUID = 3203085387160737484L;

		public PacketSendingException(final String message, final Throwable cause) {
			super(cause);
		}
	}
}
