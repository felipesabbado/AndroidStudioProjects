package com.example.trycatchdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void testingTryCatch(View view)
    {
        // Declarar um array de 3 inteiros
        int[] array = new int[3];

        try {
            for (int i = 0; i < 4; i++) {
                array[i] = i;
            }
        }catch(ArrayIndexOutOfBoundsException e) {
            Log.i("Error", "Out of bounds");
        }
        catch(Exception e)
        {
            Log.i("Error", "There was a problem" + e);
        }

        Log.i("Info", "Array is equal to" + Arrays.toString(array));
    }

}
