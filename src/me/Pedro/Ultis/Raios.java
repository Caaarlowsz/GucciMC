package me.Pedro.Ultis;

import org.bukkit.Location;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import com.github.caaarlowsz.guccimc.kitpvp.GucciPvP;

public class Raios {
	public static double cos(final double i) {
		return Math.cos(i);
	}

	public static double sin(final double i) {
		return Math.sin(i);
	}

	public static void coneEffect(final Location loc) {
		new BukkitRunnable() {
			double phi = 0.0;

			public void run() {
				this.phi += 0.39269908169872414;
				for (double t = 0.0; t <= 6.283185307179586; t += 0.19634954084936207) {
					for (double i = 0.0; i <= 1.0; ++i) {
						final double x = 0.4 * (6.283185307179586 - t) * 0.5
								* Raios.cos(t + this.phi + i * 3.141592653589793);
						final double y = 0.5 * t;
						final double z = 0.4 * (6.283185307179586 - t) * 0.5
								* Raios.sin(t + this.phi + i * 3.141592653589793);
						loc.add(x, y, z);
						ParticleEffect.HEART.display(loc, 0.0f, 0.0f, 0.0f, 0.0f, 1);
						loc.subtract(x, y, z);
					}
				}
				if (this.phi > 31.41592653589793) {
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) GucciPvP.instance, 0L, 3L);
	}

	public static void kitaguala(final Location loc) {
		new BukkitRunnable() {
			double phi = 0.0;

			public void run() {
				this.phi += 0.3141592653589793;
				for (double t = 0.0; t <= 15.707963267948966; t += 0.07853981633974483) {
					final double r = 1.2;
					final double x = r * Raios.cos(t) * Raios.sin(this.phi);
					final double y = r * Raios.cos(this.phi) + 1.2;
					final double z = r * Raios.sin(t) * Raios.sin(this.phi);
					loc.add(x, y, z);
					ParticleEffect.DRIP_WATER.display(loc, 0.0f, 0.0f, 0.0f, 0.0f, 1);
					loc.subtract(x, y, z);
				}
				if (this.phi > 3.141592653589793) {
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) GucciPvP.instance, 0L, 1L);
	}

	public static void arround(final Location loc) {
		final Location location1 = loc.clone().add(0.0, 0.5, 0.0);
		final int particles = 30;
		final float radius = 2.5f;
		for (int i = 0; i < particles; ++i) {
			final double angle = 6.283185307179586 * i / particles;
			final double x = Math.cos(angle) * radius;
			final double z = Math.sin(angle) * radius;
			location1.add(x, 0.0, z);
			ParticleEffect.FLAME.display(location1, 0.0f, 0.0f, 0.0f, 0.0f, 1);
			location1.subtract(x, 0.0, z);
		}
	}

	public static void FireBender(final Location loc) {
		new BukkitRunnable() {
			double phi = 0.0;

			public void run() {
				this.phi += 0.3141592653589793;
				for (double t = 0.0; t <= 15.707963267948966; t += 0.07853981633974483) {
					final double r = 1.2;
					final double x = r * Raios.cos(t) * Raios.sin(this.phi);
					final double y = r * Raios.cos(this.phi) + 1.2;
					final double z = r * Raios.sin(t) * Raios.sin(this.phi);
					loc.add(x, y, z);
					ParticleEffect.FLAME.display(loc, 0.0f, 0.0f, 0.0f, 0.0f, 1);
					loc.subtract(x, y, z);
				}
				if (this.phi > 3.141592653589793) {
					this.cancel();
				}
			}
		}.runTaskTimer((Plugin) GucciPvP.instance, 0L, 1L);
	}
}
