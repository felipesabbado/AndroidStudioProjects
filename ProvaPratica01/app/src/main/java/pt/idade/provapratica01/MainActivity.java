package pt.idade.provapratica01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_nomeAluno;
    EditText et_numAluno;
    EditText et_idadeAluno;
    Disciplina uc1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_nomeAluno = findViewById(R.id.et_nomeAluno);
        et_numAluno = findViewById(R.id.et_numAluno);
        et_idadeAluno = findViewById(R.id.et_idadeAluno);

        uc1 = new Disciplina("Dispositivos Móveis");
    }

    public void inserir(View view){
        String info = "";
        if (this.et_nomeAluno.getText().toString().isEmpty() ||
                this.et_numAluno.getText().toString().isEmpty() ||
                this.et_idadeAluno.getText().toString().isEmpty()){
            Toast.makeText(this, "Favor inserir todos os dados!", Toast.LENGTH_SHORT).show();
        } else {
            String nome = et_nomeAluno.getText().toString();
            int numero = Integer.parseInt(et_numAluno.getText().toString());
            int idade = Integer.parseInt(et_idadeAluno.getText().toString());
            uc1.setAlunos(nome, numero, idade);
            String msg = "Aluno " + nome + " cadastrado com o número " + numero;
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
            et_nomeAluno.setText("");
            et_idadeAluno.setText("");
            et_numAluno.setText("");

            // Log com o array de alunos
            for (int i = 0; i < uc1.numAlunos(); i++){
                info += "(" + uc1.getNomeAluno(i) + " - " + uc1.getIdade(i) + " anos), ";
            }
            Log.e("INFO", info);
        }
    }

    public void qtsAlunos(View view){
        int numAlunos = uc1.numAlunos();
        Toast.makeText(this, "Há " + numAlunos + " alunos na UC " + uc1.getNome(), Toast.LENGTH_SHORT).show();
    }

    public void velho(View view){
        int c = 0;
        String nome = "";
        for (int i = 0; i < uc1.numAlunos(); i++){
            if (uc1.getIdade(i) > c) {
                c = uc1.getIdade(i);
            }
        }

        for (int i = 0; i < uc1.numAlunos(); i++){
            if (uc1.getIdade(i) == c) {
                nome = uc1.getNomeAluno(i);
                break;
            }
        }
        Toast.makeText(this, "O aluno mais velho é " + nome, Toast.LENGTH_SHORT).show();
    }

    public void assiduidade(View view){
        double maior = 0;
        double menor = 100;
        String info = "";
        String alunoMaior = "";
        String alunoMenor = "";

        for (int i = 0; i < uc1.numAlunos(); i++){
            info += String.format("%s = %.2f / ", uc1.presencas(i), uc1.perPres(i));
        }
        Log.e("INFO", info);

        for (int i = 0; i < uc1.numAlunos(); i++){
            if (uc1.perPres(i) > maior){
                maior = uc1.perPres(i);
            }
            if (uc1.perPres(i) < menor){
                menor = uc1.perPres(i);
            }
        }
        for (int i = 0; i < uc1.numAlunos(); i++){
            if (uc1.perPres(i) == maior){
                alunoMaior = uc1.getNomeAluno(i);
                break;
            }
        }
        for (int i = 0; i < uc1.numAlunos(); i++){
            if (uc1.perPres(i) == menor){
                alunoMenor = uc1.getNomeAluno(i);
                break;
            }
        }
        String msg = "O aluno mais assíduo é " + alunoMaior + " e o menos assíduo é " + alunoMenor;
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}