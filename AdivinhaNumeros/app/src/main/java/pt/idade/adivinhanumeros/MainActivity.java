package pt.idade.adivinhanumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText palpite;

    Random rand = new Random();
    int num = rand.nextInt(21);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palpite = findViewById(R.id.palpite);
    }

    public void tentativa(View v){
        Log.e("Valor", String.valueOf(num));
        int value = Integer.parseInt(palpite.getText().toString());

        if (value == num){
            Toast.makeText(this, "Acertou!", Toast.LENGTH_SHORT).show();
        } else if (value < num){
            Toast.makeText(this, "Maior. Tente novamente.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Menor. Tente novamente.", Toast.LENGTH_SHORT).show();
        }
    }
}