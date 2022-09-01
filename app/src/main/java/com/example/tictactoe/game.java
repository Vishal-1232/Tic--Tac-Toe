package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;

public class game extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    public int totalMatches = 0 , score1 = 0,score2 = 0,draws=0;
    public String [] name;
    public TextView status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        name = getIntent().getStringArrayExtra("PLAYER_NAMES");
        status = findViewById(R.id.textView2);

        status.setText(name[0]+"'s Turn - Tap To Play");

       // mediaPlayer = MediaPlayer.create(this,R.raw.on);
       // mediaPlayer.start();
    }

    boolean gameActive = true;

    /* Player representation
        0 --> O
        1 --> X
     */
    int activePlayer = 0;

    /*  State Meanings
        0 --> 0
        1 --> X
        2 --> NULL
    */
    int[] gameState = {2,2,2,2,2,2,2,2,2};

    int [][] winPositions = {{0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}};

    public void playerTap(View view)
    {
        ImageView img = (ImageView)view;
        int tappedImg = Integer.parseInt(img.getTag().toString());

        if (!gameActive)
        {
            gameReset(view);
            return;
        }
        if (gameState[tappedImg]==2)
        {
            gameState[tappedImg] = activePlayer;
            // img.setTranslationY(-1000f);
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.o);
                activePlayer = 1;

                status.setText(name[1]+"'s Turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.x);
                activePlayer = 0;

                status.setText(name[0]+"'s Turn - Tap to play");
            }
            //img.animate().translationXBy(1000f).setDuration(300);
        }
        // check if any player has won
        for (int[] win : winPositions)
        {
            if (gameState[win[0]] == gameState[win[1]] && gameState[win[1]] == gameState[win[2]] && gameState[win[0]] != 2)
            {
                // somebody has won, lets find who
                gameActive = false;
                String winner;
                if (gameState[win[0]] == 0)
                {
                    winner = name[0]+" has won";
                    score1++;
                }
                else
                {
                    winner = name[1]+" has won";
                    score2++;
                }

                totalMatches++;
                status.setText(winner);
            }
            else
            {   // match draw condition
                int count = 0;
                for (int i = 0; i < gameState.length;i++)
                {
                    if(gameState[i] != 2)
                    {
                        count++;
                    }
                }
                if (count==9)
                {
                    status.setText("Game is Draw");
                    draws++;
                    totalMatches++;
                    gameActive = false;
                    break;
                }
            }
        }

    }

    public void gameReset(View view)
    {
        gameActive = true;
        activePlayer = 0;
        Arrays.fill(gameState, 2);

        ((ImageView)findViewById(R.id.img0)).setImageResource(0);
        ((ImageView)findViewById(R.id.img1)).setImageResource(0);
        ((ImageView)findViewById(R.id.img2)).setImageResource(0);
        ((ImageView)findViewById(R.id.img3)).setImageResource(0);
        ((ImageView)findViewById(R.id.img4)).setImageResource(0);
        ((ImageView)findViewById(R.id.img5)).setImageResource(0);
        ((ImageView)findViewById(R.id.img6)).setImageResource(0);
        ((ImageView)findViewById(R.id.img7)).setImageResource(0);
        ((ImageView)findViewById(R.id.img8)).setImageResource(0);

        TextView status = findViewById(R.id.textView2);
        status.setText(name[0]+"'s Turn - Tap to play");
    }

    public void scoreSubmit(View view)
    {
        Intent intent = new Intent(this,score.class);
        int [] runs = {totalMatches,score1,score2,draws};
        intent.putExtra("FINAL_SCORE",runs);
        intent.putExtra("PlayerNames",new String[] {name[0],name[1]});
        startActivity(intent);
    }
}