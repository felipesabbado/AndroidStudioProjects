package pt.idade.exercicio02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number;
    Numero numeroTestar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
    }

    public void palpite(View v){
        String mensagem;
        if(number.getText().toString().isEmpty()){
            mensagem = "Introduza um número!!";
        } else {
            numeroTestar = new Numero(Integer.parseInt(number.getText().toString()));

            mensagem = "" + number.getText().toString();

            if (numeroTestar.Primo() && numeroTestar.Quadrado()){
                mensagem += " é quadrado e é primo!!";
            } else if (numeroTestar.Quadrado()){
                mensagem += " é quadrado!!";
            } else if (numeroTestar.Primo()){
                mensagem += " é primo!!";
            } else {
                mensagem += " não é primo e nem quadrado!!";
            }
        }
        Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
    }
}