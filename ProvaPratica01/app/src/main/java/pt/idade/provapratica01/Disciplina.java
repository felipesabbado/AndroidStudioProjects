package pt.idade.provapratica01;

import java.util.ArrayList;

public class Disciplina {
    private final String nome;
    private ArrayList<Aluno> alunos;

    public Disciplina(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<Aluno>();
    }

    public String getNome() {
        return nome;
    }

    public String getNomeAluno(int n){
        return this.alunos.get(n).getNome();
    }

    public int getIdade(int n){
        return this.alunos.get(n).getIdade();
    }

    public void setAlunos(String nome, int numero, int idade) {
        Aluno aluno = new Aluno(nome, numero, idade);
        this.alunos.add(aluno);
    }

    public void removeAlunos(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public int numAlunos() {
        return this.alunos.size();
    }

    public double perPres(int n) {
        double assid = 0;

        for (int j = 0; j < alunos.get(n).getLengthPresenca(); j++){
            if (alunos.get(n).getPresencas(j)){
                assid++;
            }
        }
            return (assid/14) * 100;
    }

    public String presencas(int n){
        String presencas = "";
        for (int i = 0; i < alunos.get(n).getLengthPresenca(); i++){
            presencas += String.valueOf(alunos.get(n).getPresencas(i)) + ";";
        }
        return presencas;
    }
}
