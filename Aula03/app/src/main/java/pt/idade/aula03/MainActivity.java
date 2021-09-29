package pt.idade.aula03;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] country = {"Brasil", "México", "Portugal"};

        List countries = new ArrayList();

        for (int i = 0; i < country.length; i++){
            countries.add(country[i]);
        }
        Log.i("Países", countries.toString());

        countries.remove(1);
        Log.i("Países", countries.toString());

        countries.add("Angola");

        Log.i("Países", countries.toString());

    }
}