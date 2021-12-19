package com.example.miniteste1m2;

import java.util.Random;

public class Aluno {

    private String nome;
    private int numero;
    private int idade;
    private boolean[] aulas = {false, false, false, false, false, false, false,  false, false, false, false, false, false, false};

    // # CONSTRUTORES
    public Aluno(String nome){
        this.nome = nome;
    }

    public Aluno(String nome, int numero, int idade) {
        this.nome = nome;
        this.idade = idade;
        this.numero =  numero;
        gerarPresencas();
    }

    // ##### MÉTODOS | FUNÇÕES
    private void gerarPresencas()
    {
        for(int i=0; i<this.aulas.length; i++)
        {
            this.aulas[i] = new Random().nextBoolean();
        }

    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public int getNumero() {
        return numero;
    }

    public boolean[] getAulas() {
        return aulas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setAulas(boolean[] aulas) {
        this.aulas = aulas;
    }

    // ## CONSULTAR PRESENÇA NUMA AULA
    public boolean consultaPresenca(int nAula){

        int pos = nAula-1;
        boolean pres = false;

        if(pos >=0 && pos < this.aulas.length)
        {
            pres = this.aulas[pos];
        }

        return pres;
    }

    // ## MODIFICAR A PRESENCA NUMA AULA
    public void modificarPresenca(int nAula, boolean valorPresenca) {
        int pos = nAula -1;

        if(pos >=0 && pos < this.aulas.length)
        {
            this.aulas[pos] = valorPresenca;
        }
    }

    public double percentagemPresencas(){
        int total = 0;

        for(int i=0; i< this.aulas.length; i++)
        {
            if(this.aulas[i])
            {
                total++;
            }
        }

        return total/this.aulas.length*100;
    }
}
