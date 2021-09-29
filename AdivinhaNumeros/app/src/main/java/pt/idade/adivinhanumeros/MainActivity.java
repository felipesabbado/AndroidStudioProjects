package pt.idade.adivinhanumeros;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText palpite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        palpite = findViewById(R.id.palpite);
    }

    public void tentativa(View v){
        Random rand = new Random();
        String num = String.valueOf(rand.nextInt(21));

        if (palpite.equals(num)){
            Toast.makeText(this, "Acertou!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Tente novamente", Toast.LENGTH_SHORT).show();
        }
    }
}