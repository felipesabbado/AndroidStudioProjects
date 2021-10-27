package pt.idade.mod03ex01;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void speak(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.doyouspeakenglish);
        mediaPlayer.start();
    }

    public void good(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.goodevening);
        mediaPlayer.start();
    }

    public void hello(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.hello);
        mediaPlayer.start();
    }

    public void howAre(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.howareyou);
        mediaPlayer.start();
    }

    public void iLive(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.ilivein);
        mediaPlayer.start();
    }

    public void myName(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.mynameis);
        mediaPlayer.start();
    }

    public void please(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.please);
        mediaPlayer.start();
    }

    public void welcome(View view) {
        mediaPlayer = MediaPlayer.create(this, R.raw.welcome);
        mediaPlayer.start();
    }
}