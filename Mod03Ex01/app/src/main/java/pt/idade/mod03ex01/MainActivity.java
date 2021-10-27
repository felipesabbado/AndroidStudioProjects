package pt.idade.mod03ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PlaySound(View view) {
        Button pressedButton = (Button) view;
        mediaPlayer = MediaPlayer.create(this,
                getResources().getIdentifier(pressedButton.getTag().toString(),
                        "raw", getPackageName()));
        mediaPlayer.start();
    }
}