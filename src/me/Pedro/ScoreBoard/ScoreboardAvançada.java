package me.Pedro.ScoreBoard;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Team;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import me.Pedro.Main;

public class ScoreboardAvan\u00e7ada implements Scoreboard {
	private static int QUANTIDADE_DE_TIME;
	private final org.bukkit.scoreboard.Scoreboard scoreboard;
	private final Objective objetivo;
	protected Player jogador;
	protected long intervaloAtualizar;
	private boolean ativada;
	private GerenciadorDaScoreboard gerenciador;
	private Map<JogadorFake, Integer> entradaCache;
	private Table<String, Integer, JogadorFake> jogadorCache;
	private Table<Team, String, String> timeCache;
	private BukkitRunnable tarefaAtualizar;

	static {
		ScoreboardAvan\u00e7ada.QUANTIDADE_DE_TIME = 0;
	}

	public ScoreboardAvan\u00e7ada(final Player jogador) {
		this.intervaloAtualizar = 10L;
		this.entradaCache = new ConcurrentHashMap<JogadorFake, Integer>();
		this.jogadorCache = HashBasedTable.create();
		this.timeCache = HashBasedTable.create();
		this.jogador = jogador;
		this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
		this.scoreboard.registerNewObjective("board", "dummy").setDisplaySlot(DisplaySlot.SIDEBAR);
		this.objetivo = this.scoreboard.getObjective(DisplaySlot.SIDEBAR);
	}

	@Override
	public void ativar() {
		if (this.ativada) {
			return;
		}
		if (this.gerenciador == null) {
			throw new IllegalArgumentException("Gerenciador da scoreboard invalido ou nao setado");
		}
		this.ativada = true;
		this.jogador.setScoreboard(this.scoreboard);
		(this.tarefaAtualizar = new BukkitRunnable() {
			public void run() {
				ScoreboardAvan\u00e7ada.this.update();
			}
		}).runTaskTimer(Main.getPlugin(), 0L, this.intervaloAtualizar);
	}

	@Override
	public void desativar() {
		if (!this.ativada) {
			return;
		}
		this.ativada = false;
		if (this.jogador.isOnline()) {
			synchronized (this) {
				this.jogador.setScoreboard(Bukkit.getScoreboardManager().getMainScoreboard());
			}
		}
		for (final Team team : this.timeCache.rowKeySet()) {
			team.unregister();
		}
		this.tarefaAtualizar.cancel();
	}

	@Override
	public boolean estaAtivado() {
		return this.ativada;
	}

	@Override
	public GerenciadorDaScoreboard pegarGerenciador() {
		return this.gerenciador;
	}

	@Override
	public Scoreboard setarGerenciador(final GerenciadorDaScoreboard gerenciador) {
		this.gerenciador = gerenciador;
		return this;
	}

	@Override
	public long pegarIntervaloDeAtualizacao() {
		return this.intervaloAtualizar;
	}

	@Override
	public ScoreboardAvan\u00e7ada setarIntervaloDeAtualizacao(final long intervaloAtualizar) {
		if (this.ativada) {
			throw new IllegalStateException("Scoreboard ja esta ativada");
		}
		this.intervaloAtualizar = intervaloAtualizar;
		return this;
	}

	@Override
	public Player pegarJogador() {
		return this.jogador;
	}

	private void update() {
		if (!this.jogador.isOnline()) {
			this.desativar();
			return;
		}
		final String gerenciarTitulo = this.gerenciador.pegarTitulo(this.jogador);
		final String finalTitle = Strings
				.format((gerenciarTitulo != null) ? gerenciarTitulo : ChatColor.BOLD.toString());
		if (!this.objetivo.getDisplayName().equals(finalTitle)) {
			this.objetivo.setDisplayName(Strings.format(finalTitle));
		}
		final List<Entrada> passou = this.gerenciador.pegarEntradas(this.jogador);
		final Map<String, Integer> aparecido = new HashMap<String, Integer>();
		final Map<JogadorFake, Integer> atual = new HashMap<JogadorFake, Integer>();
		if (passou == null) {
			return;
		}
		for (final Entrada entrada : passou) {
			String chave = entrada.getName();
			final Integer score = entrada.getPosition();
			if (chave.length() > 48) {
				chave = chave.substring(0, 47);
			}
			String aparencia;
			if (chave.length() > 16) {
				aparencia = chave.substring(16);
			} else {
				aparencia = chave;
			}
			if (!aparecido.containsKey(aparencia)) {
				aparecido.put(aparencia, -1);
			}
			aparecido.put(aparencia, aparecido.get(aparencia) + 1);
			final JogadorFake faker = this.pegarJogadorFake(chave, aparecido.get(aparencia));
			this.objetivo.getScore((OfflinePlayer) faker).setScore((int) score);
			this.entradaCache.put(faker, score);
			atual.put(faker, score);
		}
		aparecido.clear();
		for (final JogadorFake faker2 : this.entradaCache.keySet()) {
			if (!atual.containsKey(faker2)) {
				this.entradaCache.remove(faker2);
				this.scoreboard.resetScores(faker2.getName());
			}
		}
	}

	private JogadorFake pegarJogadorFake(final String texto, int offset) {
		Team team = null;
		String name;
		if (texto.length() <= 16) {
			name = String.valueOf(texto) + Strings.repeat(" ", offset);
		} else {
			String suffix = "";
			++offset;
			final String prefix = texto.substring(0, 16 - offset);
			name = texto.substring(16 - offset);
			if (name.length() > 16) {
				name = name.substring(0, 16);
			}
			if (texto.length() > 32) {
				suffix = texto.substring(32 - offset);
			}
			for (final Team other : this.timeCache.rowKeySet()) {
				if (other.getPrefix().equals(prefix) && other.getSuffix().equals(suffix)) {
					team = other;
				}
			}
			if (team == null) {
				team = this.scoreboard.registerNewTeam("Scoreboard_" + ScoreboardAvan\u00e7ada.QUANTIDADE_DE_TIME++);
				team.setPrefix(prefix);
				team.setSuffix(suffix);
				this.timeCache.put(team, prefix, suffix);
			}
		}
		JogadorFake faker;
		if (!this.jogadorCache.contains((Object) name, (Object) offset)) {
			faker = new JogadorFake(name, team, offset);
			this.jogadorCache.put(name, offset, faker);
			if (faker.getTeam() != null) {
				faker.getTeam().addPlayer((OfflinePlayer) faker);
			}
		} else {
			faker = (JogadorFake) this.jogadorCache.get((Object) name, (Object) offset);
			if (team != null && faker.getTeam() != null) {
				faker.getTeam().removePlayer((OfflinePlayer) faker);
			}
			faker.setTeam(team);
			if (faker.getTeam() != null) {
				faker.getTeam().addPlayer((OfflinePlayer) faker);
			}
		}
		return faker;
	}

	public Objective pegarObjetivo() {
		return this.objetivo;
	}

	public org.bukkit.scoreboard.Scoreboard pegarScoreboard() {
		return this.scoreboard;
	}

	private static class JogadorFake implements OfflinePlayer {
		private final String name;
		private Team team;
//		private int offset;

		JogadorFake(final String name, final Team team, final int offset) {
			this.name = name;
			this.team = team;
//			this.offset = offset;
		}

		public Team getTeam() {
			return this.team;
		}

		public void setTeam(final Team team) {
			this.team = team;
		}

//		public int getOffset() {
//			return this.offset;
//		}
//
//		public String getFullName() {
//			if (this.team == null) {
//				return this.name;
//			}
//			if (this.team.getSuffix() == null) {
//				return String.valueOf(this.team.getPrefix()) + this.name;
//			}
//			return String.valueOf(this.team.getPrefix()) + this.name + this.team.getSuffix();
//		}

		public boolean isOnline() {
			return true;
		}

		public String getName() {
			return this.name;
		}

		public UUID getUniqueId() {
			return UUID.randomUUID();
		}

		public boolean isBanned() {
			return false;
		}

		public void setBanned(final boolean banned) {
		}

		public boolean isWhitelisted() {
			return false;
		}

		public void setWhitelisted(final boolean whitelisted) {
		}

		public Player getPlayer() {
			return null;
		}

		public long getFirstPlayed() {
			return 0L;
		}

		public long getLastPlayed() {
			return 0L;
		}

		public boolean hasPlayedBefore() {
			return false;
		}

		public Location getBedSpawnLocation() {
			return null;
		}

		public Map<String, Object> serialize() {
			return null;
		}

		public boolean isOp() {
			return false;
		}

		public void setOp(final boolean op) {
		}

		@Override
		public String toString() {
			return "FakePlayer{name='" + this.name + '\'' + ", team=" + this.team + '}';
		}
	}
}
