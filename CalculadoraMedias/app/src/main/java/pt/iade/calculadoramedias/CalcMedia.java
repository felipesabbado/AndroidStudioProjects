package pt.iade.calculadoramedias;

import java.util.ArrayList;

public class CalcMedia {
    private ArrayList<Double> notas = new ArrayList<>();

    public CalcMedia(){
    }

    public void setNotas(double n){
        this.notas.add(n);
    }

    public double calcMedia(){
        double media;
        double soma = 0;
        for (int i = 0; i < notas.size(); i++){
            soma += notas.get(i);
        }
        media = soma/notas.size();

        return media;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }
}
