package com.example.miniteste1m2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText nome, numero, idade;
    Disciplina mobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nome = findViewById(R.id.editTextNomeAluno);
        idade = findViewById(R.id.editTextIdadeAluno);
        numero = findViewById(R.id.editTextNumeroAluno);

        mobile = new Disciplina("Mobile");
    }

    // #### ADICIONAR ALUNO
    public void adicionarAluno(View v) {
        String nome = "";
        int idade = 0, numero = 0;

        if(!this.nome.getText().toString().isEmpty()) {
            nome = this.nome.getText().toString();

            if(!this.idade.getText().toString().isEmpty()) {
                idade = Integer.parseInt(this.idade.getText().toString());

                if(!this.numero.getText().toString().isEmpty()) {
                    numero = Integer.parseInt(this.numero.getText().toString());

                    Aluno a = new Aluno(nome, numero, idade);
                    this.mobile.inserirAluno(a);
                }
            }
        }
    }

    // ## NUMERO DE ALUNOS INSERIDOS
    public void numeroAlunos(View v) {
        Toast.makeText(this,
                "Já temos " + this.mobile.numeroAlunos() + " alunos!",
                Toast.LENGTH_SHORT).show();
    }

    // ## ALUNO MAIS VELHO
    public void alunoMaisVelho(View v) {

        Aluno a = this.mobile.alunoMaisVelho();

        Toast.makeText(this,
                "O aluno mais velho é o " + a.getNome()
                + " com " + a.getIdade() + " anos!!",
                Toast.LENGTH_SHORT).show();
    }

    public void maisEmenosAssiduo(View v) {
        Aluno maisAssiduo = this.mobile.maisAssiduo();
        Aluno menosAssiduo = this.mobile.menosAssiduo();

        Toast.makeText(this,
                "O aluno mais assiduo é " + maisAssiduo.getNome() +
                " com " + maisAssiduo.percentagemPresencas() + " % de presenças"
                + " E o aluno menos assiduo é " + menosAssiduo.getNome() +
                        " com " + menosAssiduo.percentagemPresencas() + " % de presenças",
                Toast.LENGTH_SHORT).show();
    }
}