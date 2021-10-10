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
    static double rate = 0.87;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = findViewById(R.id.msg);
        value = findViewById(R.id.value);
        converter = findViewById(R.id.converter);
        image = findViewById(R.id.image);
    }

    public void converter(View v){
        Log.i("INFO", "Converter");
        DecimalFormat round = new DecimalFormat("#.##");
        String mensagem;
        String aviso;

        if (value.getText().toString().isEmpty()){
            image.setImageResource(R.drawable.cifrao);
            mensagem = "Digite um valor válido";
            aviso = "Digite um valor";
            Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
        } else {
            double valueDollar = Double.parseDouble(value.getText().toString());
            double valueEuros = valueDollar * rate;
            mensagem = "US$" + round.format(valueDollar) + " equivale a €" + round.format(valueEuros);
            aviso = "Convertendo...";
            Toast.makeText(this, aviso, Toast.LENGTH_SHORT).show();
            image.setImageResource(R.drawable.euro);
        }

        msg.setText(mensagem);
    }
}