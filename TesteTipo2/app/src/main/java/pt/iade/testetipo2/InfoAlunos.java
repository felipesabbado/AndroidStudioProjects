package pt.iade.testetipo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class InfoAlunos extends AppCompatActivity {
    private TextView nome, idade, numero;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_alunos);

        nome = findViewById(R.id.tvNomeAluno);
        idade = findViewById(R.id.tvIdadeAluno);
        numero = findViewById(R.id.tvNumeroAluno);

        intent = getIntent();
        nome.setText("Nome: " + intent.getExtras().getString("name"));
        idade.setText("Idade: " + String.valueOf(intent.getExtras().getInt("idade")));
        numero.setText("Número: " + String.valueOf(intent.getExtras().getInt("numero")));
    }
}