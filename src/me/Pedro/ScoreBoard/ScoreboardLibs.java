package me.Pedro.ScoreBoard;

import java.util.List;

import org.bukkit.entity.Player;

import me.Pedro.Main;
import me.Pedro.XP.XpM;

public class ScoreboardLibs {
	public static void iniciarScoreboard(final Player p) {
		criarScoreboard(p).setarGerenciador(new GerenciadorDaScoreboard() {
			private final HighlightedString scoreboard = new HighlightedString("FANNTPVP", "&6", "&f");

			@Override
			public String pegarTitulo(final Player p) {
				return this.scoreboard.next();
			}

			@Override
			public List<Entrada> pegarEntradas(final Player p) {
				return new ConstrutorDeEntrada().emBranco()
						.proximo("&fKills: &6"
								+ Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".kills"))
						.proximo("&fDeaths: &6"
								+ Main.plugin.getConfig().getInt("status." + p.getName().toLowerCase() + ".mortes"))
						.proximo("&fKillstreak: &6").emBranco().proximo("&fKit: &6" + Habilidade.getAbility(p))
						.proximo("&fRank: &6Unranked").proximo("&fXp: &6" + XpM.getPlayerMoney(p)).emBranco()
						.proximo("&7/score").proximo("&6§l@FanntNetwork").emBranco().construir();
			}
		}).setarIntervaloDeAtualizacao(5L).ativar();
	}

	public static ScoreboardAvan\u00e7ada criarScoreboard(final Player jogador) {
		return new ScoreboardAvan\u00e7ada(jogador);
	}
}
