package pt.idade.provapratica01;

import java.util.Random;

public class Aluno {
    private final String nome;
    private int num;
    private int idade;
    private final boolean[] presencas = new boolean[14];
    private final Random random = new Random();

    public Aluno(String nome){
        this.nome = nome;
    }

    public Aluno(String nome, int num, int idade){
        this.nome = nome;
        this.num = num;
        this.idade = idade;
        for (int i = 0; i < presencas.length; i++){
            presencas[i] = random.nextBoolean();
        }
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean getPresencas(int num) {
        return presencas[num];
    }

    public int getLengthPresenca(){
        return presencas.length;
    }

    public void setPresenca (int num, boolean pres){
        this.presencas[num] = pres;
    }
}
