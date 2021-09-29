package pt.iade.conversormoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    TextView msg;
    EditText value;
    Button converter;
    static double rate = 1.12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = findViewById(R.id.msg);
        value = findViewById(R.id.value);
        converter = findViewById(R.id.converter);
    }

    public void converter(View v){
        Log.i("INFO", "Converter");

        double valueDollar = Double.parseDouble(value.getText().toString());
        double valueEuros = valueDollar * rate;
        DecimalFormat round = new DecimalFormat("#.##");

        msg.setText(String.valueOf("US$" + round.format(valueDollar) + " equivale a €" + round.format(valueEuros)));

        String aviso = "Convertendo...";
        Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
    }
}