package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class score extends AppCompatActivity {
    private TextView p1name,p2name,p1score,p2score,total,draw;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        p1name = findViewById(R.id.p1Name);
        p2name = findViewById(R.id.p2Name);
        p1score = findViewById(R.id.p1Score);
        p2score = findViewById(R.id.p2Score);
        total = findViewById(R.id.total);
        draw = findViewById(R.id.draws);

        String[] players = getIntent().getStringArrayExtra("PlayerNames");
        int[] results = getIntent().getIntArrayExtra("FINAL_SCORE");

        p1name.setText(players[0]);
        p2name.setText(players[1]);

        total.setText("Total Matches Played : "+ Integer.toString(results[0]));
        p1score.setText(Integer.toString(results[1]));
        p2score.setText(Integer.toString(results[2]));
        draw.setText("Matches Draws : "+Integer.toString(results[3]));

    }

    public void homeButtonClick(View view)
    {
       // System.exit(0);
        Intent intent = new Intent(this,MainActivity.class);
        //intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
       // intent.putExtra("EXIT",true);
        startActivity(intent);


        finish();
       // System.exit(0);
    }

}