package me.Pedro.ScoreBoard;

import org.bukkit.entity.Player;

public class ScoreboardLibs
{
    public static void iniciarScoreboard(final Player p) {
        criarScoreboard(p).setarGerenciador((GerenciadorDaScoreboard)new ScoreboardLibs.ScoreboardLibs$1()).setarIntervaloDeAtualizacao(5L).ativar();
    }
    
    public static ScoreboardAvan\u00e7ada criarScoreboard(final Player jogador) {
        return new ScoreboardAvan\u00e7ada(jogador);
    }
}
