package me.Pedro.Ultis;

import org.bukkit.plugin.Plugin;
import me.Pedro.Main;
import org.bukkit.Location;

public class Raios
{
    public static double cos(final double i) {
        return Math.cos(i);
    }
    
    public static double sin(final double i) {
        return Math.sin(i);
    }
    
    public static void coneEffect(final Location loc) {
        new Raios.Raios$1(loc).runTaskTimer((Plugin)Main.instance, 0L, 3L);
    }
    
    public static void kitaguala(final Location loc) {
        new Raios.Raios$2(loc).runTaskTimer((Plugin)Main.instance, 0L, 1L);
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
        new Raios.Raios$3(loc).runTaskTimer((Plugin)Main.instance, 0L, 1L);
    }
}
