package pt.iade.testetipo2;

public class Aluno {
    private String name;
    private int numero;
    private int idade;

    public Aluno(String name, int numero, int idade) {
        this.name = name;
        this.numero = numero;
        this.idade = idade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return getName();
    }
}
