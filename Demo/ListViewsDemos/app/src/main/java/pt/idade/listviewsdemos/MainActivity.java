package pt.idade.listviewsdemos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lvFirst);

        ArrayList<String> disciplinas = new ArrayList<String>();
        disciplinas.add("Mobile");
        disciplinas.add("POO");
        disciplinas.add("BaseDados");
        disciplinas.add("Projeto");

        ArrayAdapter<String> myListAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, disciplinas);

        listView.setAdapter(myListAdapter);
    }
}