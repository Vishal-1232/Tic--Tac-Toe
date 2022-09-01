package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class playerSetup extends AppCompatActivity {

    private EditText player1;
    private EditText player2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_setup);

        player1 = findViewById(R.id.player1);
        player2 = findViewById(R.id.player2);
    }

    public void submitClick(View view)
    {
        String Player1 = player1.getText().toString();
        String Player2 = player2.getText().toString();

        Intent intent = new Intent(this,game.class);
        intent.putExtra("PLAYER_NAMES",new String[] {Player1,Player2});
        startActivity(intent);
    }
}