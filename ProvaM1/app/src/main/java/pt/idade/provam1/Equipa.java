package pt.idade.provam1;

import java.util.ArrayList;

public class Equipa {
    private String nome;
    private ArrayList<Jogador> jogadores;

    public Equipa(String nome) {
        this.nome = nome;
        this.jogadores = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void addJogador(Jogador jogador) {
        this.jogadores.add(jogador);
    }

    public void removeJogador(Jogador jogador) {
        this.jogadores.remove(jogador);
    }

    public int numJogadores() {
        return this.jogadores.size();
    }

    public Jogador melhorMarcador() {
        Jogador melhor = this.jogadores.get(0);
        for (int i = 1; i < this.numJogadores(); i++) {
            if (melhor.saldoGolos() < this.jogadores.get(i).saldoGolos()){
                melhor = this.jogadores.get(i);
            }
        }
        return melhor;
    }

    public Jogador maiorSalario() {
        Jogador maxSal = this.jogadores.get(0);
        for (int i = 1; i < this.jogadores.size(); i++){
            if (maxSal.getSalario() < this.jogadores.get(i).getSalario()) {
                maxSal = this.jogadores.get(i);
            }
        }
        return maxSal;
    }

    public Jogador jogador(int i) {
        return this.jogadores.get(i);
    }
}
