package pt.iade.jogadores;

public class Player {
    private String name;
    private int score;

    public Player(String n, int s){
        this.name = n;
        this.score = s;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
