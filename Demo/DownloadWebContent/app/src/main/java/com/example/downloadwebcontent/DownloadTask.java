package com.example.downloadwebcontent;

import android.os.AsyncTask;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DownloadTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        String result ="";
        URL url;
        HttpURLConnection urlConnection = null;

        try {

            // Criar a ligação
            url = new URL(urls[0]);
            urlConnection = (HttpURLConnection) url.openConnection();

            // Criar uma Stream para leitura de dados
            InputStream in = urlConnection.getInputStream();
            InputStreamReader reader = new InputStreamReader(in);

            // Ler os dados
            int data = reader.read();
            while(data!=-1) {
                char current = (char)data;
                result += current;
                data = reader.read();
            }

            // Devolver os dados
            return result;

        } catch (Exception e) {
            e.printStackTrace();

            return "Failed";
        }

    }
}
