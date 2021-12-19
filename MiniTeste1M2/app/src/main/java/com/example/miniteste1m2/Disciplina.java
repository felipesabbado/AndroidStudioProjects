package com.example.miniteste1m2;

import java.util.ArrayList;

public class Disciplina {

    private String nome;
    private ArrayList<Aluno> alunos;

    public Disciplina(String nome) {
        this.nome = nome;
        this.alunos = new ArrayList<Aluno>();
    }

    // ## INSERIR ALUNO
    public void inserirAluno(Aluno a){
        this.alunos.add(a);
    }

    // ## REMOVER ALUNO
    public void removerAluno(Aluno a) {
        this.alunos.remove(a);
    }
    public void removerAluno(int pos) {
        this.alunos.remove(pos);
    }
    public void removerAlunoPeloNumero(int nAluno) {
        for(int i=0; i< this.alunos.size(); i++)
        {
            if(this.alunos.get(i).getNumero() == nAluno) {
                this.alunos.remove(i);
            }
        }
    }

    // ## NÚMERO ALUNOS
    public int numeroAlunos(){
        return this.alunos.size();
    }

    // ## DEVOLVER PERCENTAGEM ALUNOS
    public double percentagemPresencas() {
        int total = 0;

        for(int i=0; i< this.alunos.size(); i++)
        {
            total += this.alunos.get(i).percentagemPresencas();
        }

        return total/this.alunos.size()*100;
    }

    // ## DEVOLVER O ALUNO MAIS VELHO
    public Aluno alunoMaisVelho(){
        Aluno maisVelho = this.alunos.get(0);

        for(int i=0; i<this.alunos.size(); i++) {
            if(this.alunos.get(i).getIdade() >= maisVelho.getIdade()){
                maisVelho = this.alunos.get(i);
            }
        }

        return maisVelho;
    }

    // ## MAIS ASSIDUO
    public Aluno maisAssiduo() {
        Aluno maisAssiduo = this.alunos.get(0);

        for(int i=0; i<this.alunos.size(); i++) {
            if(this.alunos.get(i).percentagemPresencas() >= maisAssiduo.percentagemPresencas()){
                maisAssiduo = this.alunos.get(i);
            }
        }

        return maisAssiduo;
    }

    // ## MENOS ASSIDUO
    public Aluno menosAssiduo() {
        Aluno menosAssiduo = this.alunos.get(0);

        for(int i=0; i<this.alunos.size(); i++) {
            if(this.alunos.get(i).percentagemPresencas() <= menosAssiduo.percentagemPresencas()){
                menosAssiduo = this.alunos.get(i);
            }
        }

        return menosAssiduo;
    }
}
