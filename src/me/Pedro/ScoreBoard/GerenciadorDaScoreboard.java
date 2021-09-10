package me.Pedro.ScoreBoard;

import java.util.List;

import org.bukkit.entity.Player;

public interface GerenciadorDaScoreboard {
	String pegarTitulo(final Player p0);

	List<Entrada> pegarEntradas(final Player p0);
}
