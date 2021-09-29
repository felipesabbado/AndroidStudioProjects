package pt.iade.aula02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et_name;
    Button bt_greeting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        bt_greeting = findViewById(R.id.bt_greeting);
    }

    public void button(View view){
        Log.i("INFO", "Button");
        String msg = "Olá, " + et_name.getText().toString() + "!!!";
        // Mostra msg temporária
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}