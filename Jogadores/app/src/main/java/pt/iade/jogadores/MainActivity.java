package pt.iade.jogadores;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_jogador;
    EditText et_gols;
    EditText et_choice;
    TextView tv_result;
    public ArrayList<Player> players = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_jogador = findViewById(R.id.et_jogador);
        et_gols = findViewById(R.id.et_gols);
        et_choice = findViewById(R.id.et_choice);
        tv_result = findViewById(R.id.tv_result);
    }

    public void Salvar(View view){
        String info = "";
        String name;
        int score;
        if (et_jogador.getText().toString().isEmpty() || et_gols.getText().toString().isEmpty()){
            info += et_jogador.getText().toString() + " - " + et_gols.getText().toString();
            Log.e("INFO", info);
            Toast.makeText(this, "Insira os dados.", Toast.LENGTH_SHORT).show();
        } else {
            name = et_jogador.getText().toString();
            score = Integer.parseInt(et_gols.getText().toString());
            Player p = new Player(name, score);
            players.add(p);
            for (int i = 0; i < players.size(); i++){
                info += players.get(i).getName() + " - " + players.get(i).getScore() + " | ";
            }
            Log.e("INFO", info);
            String msg = "Jogador " + et_jogador.getText().toString() + " adicionado!";
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }

    public void Escolher(View view2){
        String name = et_choice.getText().toString();
        String msg = "";
        if (et_choice.getText().toString().isEmpty()){
            Log.e("INFO", "Campo vazio");
            Toast.makeText(this, "Escolha um jogador.", Toast.LENGTH_SHORT).show();
        } else {
            Log.e("INFO", name);
            for (int i = 0; i < players.size(); i++){
                if (players.get(i).getName().equals(name)) {
                    msg = String.format("%s fez %d gols.", name, players.get(i).getScore());
                    // Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                    Log.e("INFO", players.get(i).getName());
                    break;
                } else {
                    msg = "Este jogador não existe";
                    // Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
                }
            }
        }
        tv_result.setText(msg);
    }
}