package pt.idade.timervisibility;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // # Identificar quem vai executar a tarefa
        final Handler handler = new Handler();

        // # Criar a tarefa a executar
        Runnable run = new Runnable() {
            @Override
            public void run() {
                Log.i("TEMPO DECORRIDO", "Passaram dez segundos");

                handler.postDelayed(this, 10000);
            }
        };

        // # Iniciar a tarefa
        handler.post(run);

        new CountDownTimer(10000, 1000) {
            @Override
            public void onFinish() {
                Log.e("ALARME", "ACABOU O TEMPO!");
            }

            @Override
            public void onTick(long l) {
                Log.i("SEGUNDO", String.valueOf(l/1000));
            }
        }.start();
    }
}