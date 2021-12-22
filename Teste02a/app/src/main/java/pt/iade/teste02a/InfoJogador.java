package pt.iade.teste02a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoJogador extends AppCompatActivity {
    TextView textViewNomeJogador, textViewSalarioJogador;
    ListView listViewGolos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_jogador);
        textViewNomeJogador = findViewById(R.id.textViewNomeJogador);
        textViewSalarioJogador = findViewById(R.id.textViewSalarioJogador);
        listViewGolos = findViewById(R.id.listViewGolos);

        Intent intent = getIntent();

        String nome = intent.getStringExtra("nome");
        String salario = String.valueOf(intent.getExtras().getDouble("salario"));
        ArrayList<Integer> golos = new ArrayList<>();
        golos = intent.getIntegerArrayListExtra("golos");

        Log.e("GetSalario", salario);

        textViewNomeJogador.setText("Nome: " + nome);
        textViewSalarioJogador.setText("Salário: €" + salario);

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, golos);
        listViewGolos.setAdapter(adapter);
    }
}