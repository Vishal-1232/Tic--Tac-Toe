package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this,R.raw.open);
        mediaPlayer.start();
    }

    public void playButtonClick(View view)
    {
        Intent intent = new Intent(this,playerSetup.class);
        startActivity(intent);
    }
    public void exitButtonClick(View view)
    {
        finishAndRemoveTask();
    }
}