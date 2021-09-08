package me.Pedro.ScoreBoard;

public class Entrada
{
    private String name;
    private int position;
    
    public Entrada(final String name, final int position) {
        this.name = Strings.format(name);
        this.position = position;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(final int position) {
        this.position = position;
    }
}
