package pt.iade.testetipo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Aluno> alunos;
    private EditText alunoNome, alunoIdade, alunoNumero;
    private ListView listViewAlunos;
    private ArrayAdapter<Aluno> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        alunoNome = findViewById(R.id.alunoNome);
        alunoIdade = findViewById(R.id.alunoIdade);
        alunoNumero = findViewById(R.id.alunoNumero);
        listViewAlunos = findViewById(R.id.listViewAlunos);

        alunos = new ArrayList<>();

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, alunos);
        listViewAlunos.setAdapter(adapter);

        listViewAlunos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, InfoAlunos.class);
                intent.putExtra("name", alunos.get(i).getName());
                intent.putExtra("idade", alunos.get(i).getIdade());
                intent.putExtra("numero", alunos.get(i).getNumero());

                startActivity(intent);
            }
        });
    }

    public void adicionarAluno(View view) {
        String nome;
        int idade, numero;

        if (!this.alunoNome.getText().toString().isEmpty()) {
            nome = alunoNome.getText().toString();

            if (!this.alunoIdade.getText().toString().isEmpty()) {
                idade = Integer.parseInt(alunoIdade.getText().toString());

                if (!this.alunoNumero.getText().toString().isEmpty()) {
                    numero = Integer.parseInt(alunoNumero.getText().toString());

                    this.alunos.add(new Aluno(nome, idade, numero));
                }
            }
        }

        alunoNome.setText("");
        alunoNumero.setText("");
        alunoIdade.setText("");
    }
}