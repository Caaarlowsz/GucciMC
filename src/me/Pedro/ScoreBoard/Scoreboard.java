package me.Pedro.ScoreBoard;

import org.bukkit.entity.Player;

public interface Scoreboard
{
    void ativar();
    
    void desativar();
    
    boolean estaAtivado();
    
    GerenciadorDaScoreboard pegarGerenciador();
    
    Scoreboard setarGerenciador(final GerenciadorDaScoreboard p0);
    
    long pegarIntervaloDeAtualizacao();
    
    Scoreboard setarIntervaloDeAtualizacao(final long p0);
    
    Player pegarJogador();
}
