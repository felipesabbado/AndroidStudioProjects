package pt.iade.testetipo2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class InfoAlunos extends AppCompatActivity {
    private ListView listViewInfoAlunos;
    private Intent intent;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> infoAlunos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_alunos);

        listViewInfoAlunos = findViewById(R.id.listViewInfoAlunos);

        intent = getIntent();
        infoAlunos = new ArrayList<>();
        infoAlunos.add("Nome: " + intent.getExtras().getString("name"));
        infoAlunos.add("Idade: " + String.valueOf(intent.getExtras().getInt("idade")));
        infoAlunos.add("Número: " + String.valueOf(intent.getExtras().getInt("numero")));

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, infoAlunos);
        listViewInfoAlunos.setAdapter(adapter);
    }
}