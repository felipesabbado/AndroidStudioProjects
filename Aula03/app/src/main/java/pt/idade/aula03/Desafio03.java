package pt.idade.aula03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class Desafio03 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int[] num = {4, 5};
        Log.i("Num", Integer.toString(num[0]));
        Log.i("Num", Integer.toString(num[1]));

        int res;

        if (num[0] >= num[1]){
            res = (int) Math.pow(num[0],2);
        } else {
            res = (int) Math.pow(num[1],3);
        }

        Log.i("Resultado", Integer.toString(res));
    }
}