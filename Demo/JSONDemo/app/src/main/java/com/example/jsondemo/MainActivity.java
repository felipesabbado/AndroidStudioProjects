package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    JSONArray objUsTu = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
    }

    public void getWeather(View view) {
        DownloadTask task = new DownloadTask();
        try {
            objUsTu = task.execute("https://ulide.herokuapp.com/api/routes").get();
        } catch (ExecutionException e) {
            e.printStackTrace();
            objUsTu = null;
        } catch (InterruptedException e) {
            e.printStackTrace();
            objUsTu = null;
        }

        JSONObject obj = null;
        ArrayList<String> routes = new ArrayList<>();
        if(objUsTu != null) {
            for(int i = 0; i < objUsTu.length(); i++) {
                try {
                    obj = objUsTu.getJSONObject(i);
                    routes.add(obj.getString("rtName"));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        textView.setText(routes.toString());
    }
}
