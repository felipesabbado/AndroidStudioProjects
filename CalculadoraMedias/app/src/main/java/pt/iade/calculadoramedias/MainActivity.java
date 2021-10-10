package pt.iade.calculadoramedias;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView tv_media;
    EditText et_nota;
    CalcMedia media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_media = findViewById(R.id.tv_media);
        et_nota = findViewById(R.id.et_nota);
        media = new CalcMedia();
    }

    public void setBt_nota(View bt1){
        if (et_nota.getText().toString().isEmpty()){
            Toast.makeText(this, "Digite um valor!", Toast.LENGTH_SHORT).show();
        } else {
            String msg = "Nota " + et_nota.getText().toString() + " adicionada!";
            Log.e("INFO", "" + msg);
            media.setNotas(Double.parseDouble(et_nota.getText().toString()));
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
        Log.e("INFO", "" + media.getNotas());
    }

    public void setBt_media(View bt2){
        DecimalFormat round = new DecimalFormat("#.##");
        if (media.getNotas().isEmpty()) {
            tv_media.setText("Calcule a sua média!");
            Toast.makeText(this, "Digite sua notas!", Toast.LENGTH_SHORT).show();
            Log.e("INFO", "Array vazio");
        } else {
            Toast.makeText(this, "Calculando...", Toast.LENGTH_SHORT).show();
            String msg = "A média das suas notas é " + round.format(media.calcMedia());
            tv_media.setText(msg);
            Log.e("INFO", "Média = " + media.calcMedia());
        }
        media = new CalcMedia();
    }
}