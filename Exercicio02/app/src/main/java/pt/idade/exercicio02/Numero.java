package pt.idade.exercicio02;

public class Numero {

    private double numeroInserido;

    public Numero(int n) {
        this.numeroInserido = n;
    }

    public boolean Quadrado(){
        double raizQ = Math.sqrt(this.numeroInserido);

        if (raizQ == Math.floor(this.numeroInserido)){
            return true;
        } else {
            return false;
        }
    }

    public boolean Primo(){
        int flag = 0;

        if (this.numeroInserido == 0 || this.numeroInserido == 1){
            flag = 1;
        } else {
            for(int i=2; i <= this.numeroInserido/2; i++){
                if(this.numeroInserido % i == 0){
                    flag = 1;
                    break;
                }
            }
        }

        if(flag == 0){
            return true;
        } else {
            return false;
        }
    }
}
