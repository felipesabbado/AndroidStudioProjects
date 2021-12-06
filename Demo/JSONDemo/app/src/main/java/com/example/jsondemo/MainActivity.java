package com.example.jsondemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.example.jsondemo.downloadtasks.GetPersons;
import com.example.jsondemo.downloadtasks.PostPersons;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class MainActivity extends AppCompatActivity {

    JSONArray persons = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GetPersons getAppPersons = new GetPersons();

        try {
            /*persons = getAppPersons.execute("https://ulide.herokuapp.com/api/users").get();
            Log.i("SIZE", " -> " + persons.length());

            JSONObject aux = new JSONObject(persons.get(0).toString());
            Log.i("OBJECT", aux.toString());
            Log.i("NAME", aux.getString("usName"));

            JSONObject innerObject = new JSONObject(aux.getString("usTu"));
            Log.i("OBJC", innerObject.toString());*/

            Map<String, String> postData = new HashMap<>();
            postData.put("personName", "Zézinho");
            postData.put("personPhoneNumber", "123123123");
            postData.put("personEmail", "testinho@iade.pt");

            PostPersons task = new PostPersons(postData);
            task.execute("http://mechanic-on-the-go.herokuapp.com/api/persons");


        } catch (Exception e) {
            e.printStackTrace();
            persons = null;
        }
    }
}
