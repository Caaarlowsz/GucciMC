package me.Pedro.ScoreBoard;

import org.bukkit.ChatColor;

public final class Strings {
	public static String format(final String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}

	public static String repeat(final String string, final int count) {
		if (count <= 1) {
			return (count == 0) ? "" : string;
		}
		final int len = string.length();
		final long longSize = len * count;
		final int size = (int) longSize;
		if (size != longSize) {
			throw new ArrayIndexOutOfBoundsException("Required array size too large: " + longSize);
		}
		final char[] array = new char[size];
		string.getChars(0, len, array, 0);
		int n;
		for (n = len; n < size - n; n <<= 1) {
			System.arraycopy(array, 0, array, n, n);
		}
		System.arraycopy(array, 0, array, n, size - n);
		return new String(array);
	}
}
