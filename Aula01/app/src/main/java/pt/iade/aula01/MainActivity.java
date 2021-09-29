package pt.iade.aula01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText et_userName, et_password;
    Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // #1 - Ligar design ao código
        et_userName = findViewById(R.id.et_userName);
        et_password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.bt_login);
    }

    // #2 - Criar interação com o botão
    public void login(View view){
        Log.i("INFO", "Login");
        // #3 - Tirar texto
        Log.i("USERNAME", et_userName.getText().toString());
        Log.i("PASSWORD", et_password.getText().toString());
    }
}