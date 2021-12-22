package pt.iade.teste02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Equipa e1;
    EditText jogadorNome, jogadorSalario;
    ListView listViewJogadores;
    ArrayAdapter<Jogador> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jogadorNome = findViewById(R.id.jogadorNome);
        jogadorSalario = findViewById(R.id.jogadorSalario);
        listViewJogadores = findViewById(R.id.listViewJogadores);

        e1 = new Equipa("Grêmio");
        e1.addJogador(new Jogador("Douglas", 2700));
        e1.addJogador(new Jogador("Martinho", 3450));
        e1.addJogador(new Jogador("Romario", 55600));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, e1.getJogadores());
        listViewJogadores.setAdapter(adapter);

        listViewJogadores.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, InfoJogador.class);
                intent.putExtra("nome", e1.getJogadores().get(i).getNome());
                intent.putExtra("salario", e1.getJogadores().get(i).getSalario());
            }
        });
    }

    public void addJogador(View view) {
        String nome = jogadorNome.getText().toString();
        Double salario = Double.parseDouble(jogadorSalario.getText().toString());
        e1.addJogador(new Jogador(nome, salario));
    }
}