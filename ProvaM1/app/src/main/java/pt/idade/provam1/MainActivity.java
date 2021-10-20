package pt.idade.provam1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText et_nomeJogador, et_salarioJogador;
    Equipa e1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nomeJogador = findViewById(R.id.et_nomeJogador);
        et_salarioJogador = findViewById(R.id.et_salarioJogador);
        e1 = new Equipa("Grêmio");
    }

    public void adicionar (View v) {
        if (this.et_nomeJogador.toString().isEmpty() || this.et_salarioJogador.toString().isEmpty()) {
            Toast.makeText(this, "Insira os dados!", Toast.LENGTH_SHORT).show();
        } else {
            String nome = et_nomeJogador.getText().toString().toUpperCase();
            double salario = Double.parseDouble(et_salarioJogador.getText().toString());
            Jogador j = new Jogador(nome, salario);
            e1.addJogador(j);
            Toast.makeText(this, "Jogador " + j.getNome()
                    + " adicionado!", Toast.LENGTH_SHORT).show();
            et_nomeJogador.setText("");
            et_salarioJogador.setText("");
        }

        // Log com o array de jogadores
        String info = "";
        for (int i = 0; i < e1.numJogadores(); i++){
            info += "[" + e1.jogador(i).getNome() + " / €" + e1.jogador(i).getSalario()
                    + " / " + e1.jogador(i).saldoGolos() + " golos]; ";
        }
        Log.e("INFO", info);
    }

    public void qtsJogadores (View v) {
        Toast.makeText(this, "Há " + e1.numJogadores()
                + " jogadores na equipa " + e1.getNome(), Toast.LENGTH_SHORT).show();
    }

    public void maxSalario (View v) {
        Toast.makeText(this, "" + e1.maiorSalario().getNome()
                + " recebe o maior salário, cujo valor é de €" + e1.maiorSalario().getSalario(), Toast.LENGTH_SHORT).show();
    }

    public void melhorMarcador (View v) {
        Toast.makeText(this, "" + e1.melhorMarcador().getNome()
                + " é o melhor marcador com " + e1.melhorMarcador().saldoGolos() + " golos.",
                Toast.LENGTH_SHORT).show();
    }
}