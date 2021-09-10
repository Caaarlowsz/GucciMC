package me.Pedro.ScoreBoard;

import java.util.LinkedList;
import java.util.List;

public final class ConstrutorDeEntrada {
	private final LinkedList<Entrada> entradas;

	public ConstrutorDeEntrada() {
		this.entradas = new LinkedList<Entrada>();
	}

	public ConstrutorDeEntrada emBranco() {
		return this.proximo("");
	}

	public ConstrutorDeEntrada proximo(final String string) {
		this.entradas.add(new Entrada(this.adaptar(string), this.entradas.size()));
		return this;
	}

	public List<Entrada> construir() {
		for (final Entrada entrada : this.entradas) {
			entrada.setPosition(this.entradas.size() - entrada.getPosition());
		}
		return this.entradas;
	}

	private String adaptar(String entrada) {
		if (entrada.length() > 48) {
			entrada = entrada.substring(0, 47);
		}
		return Strings.format(entrada);
	}
}
