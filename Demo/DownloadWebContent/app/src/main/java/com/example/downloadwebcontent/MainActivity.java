 package com.example.downloadwebcontent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Criar um objeto do tipo DownloadTask
        DownloadTask task = new DownloadTask();
        // Variável para guardar o resultado da task
        String resultFromTask = null;

        try{
            // Executar a tarefa
            resultFromTask = task.execute("http://10.72.121.170:8888/MAMP/").get();

            Log.i("Info", "Após a tarefa");
        } catch(Exception e){
            e.printStackTrace();
        }

        Log.i("Result", resultFromTask);

    }
}
