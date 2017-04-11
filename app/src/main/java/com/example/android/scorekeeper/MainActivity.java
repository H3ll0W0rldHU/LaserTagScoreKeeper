package com.example.android.scorekeeper;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    int scoreTeamA = 0;
    int scoreTeamB = 0;
    int aliveAPlayers = 3;
    int aliveBPlayers = 3;
    int roundOfMatch = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    /**
     * Displays the the number of the current round.
     */
    public void displayRound(String roundText) {
        TextView scoreView = (TextView) findViewById(R.id.round_of_match);
        scoreView.setText(String.valueOf(roundText));
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayScoreForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayScoreForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }

    /**
     * Displays the number of the alive players from Team A.
     */
    public void displayAliveAPlayers(int aliveA) {
        TextView aliveView = (TextView) findViewById(R.id.team_a_remaining_players);
        aliveView.setText(String.valueOf(aliveA));
    }

    /**
     * Displays the number of the alive players from Team B.
     */
    public void displayAliveBPlayers(int aliveB) {
        TextView aliveView = (TextView) findViewById(R.id.team_b_remaining_players);
        aliveView.setText(String.valueOf(aliveB));
    }

    /**
     * Decreases the number of alive players from team B.
     * If the number reaches zero (everyone died), it displays a short toast message about the result of the round and initializes a new round.
     */
    public void teamAKilledAnEnemy(View view) {
        if (aliveBPlayers > 1) {
            aliveBPlayers--;
            displayAliveBPlayers(aliveBPlayers);
        } else {
            aliveBPlayers--;
            displayAliveBPlayers(aliveBPlayers);
            Toast.makeText(this, "Team A has won this round!", Toast.LENGTH_SHORT).show();
            scoreTeamA++;
            displayScoreForTeamA(scoreTeamA);
            newRound();
        }
    }

    /**
     * Increases the score of Team A, displays a short toast message about the result of the round and initializes a new round.
     */
    public void teamACapturedTheFlag(View view) {
        scoreTeamA++;
        displayScoreForTeamA(scoreTeamA);
        Toast.makeText(this, "Team A has won this round!", Toast.LENGTH_SHORT).show();
        newRound();
    }

    /**
     * Decreases the number of alive players from team A.
     * If the number reaches zero (everyone died), it displays a short toast message about the result of the round and initializes a new round.
     */
    public void teamBKilledAnEnemy(View view) {
        if (aliveAPlayers > 1) {
            aliveAPlayers--;
            displayAliveAPlayers(aliveAPlayers);
        } else {
            aliveAPlayers--;
            displayAliveAPlayers(aliveAPlayers);
            Toast.makeText(this, "Team B has won this round!", Toast.LENGTH_SHORT).show();
            scoreTeamB++;
            displayScoreForTeamB(scoreTeamB);
            newRound();
        }
    }

    /**
     * Increases the score of Team B and initializes a new round.
     */
    public void teamBCapturedTheFlag(View view) {
        scoreTeamB++;
        displayScoreForTeamB(scoreTeamB);
        Toast.makeText(this, "Team B has won this round!", Toast.LENGTH_SHORT).show();
        newRound();
    }

    /**
     * Resets the scores of the teams and the number of alive players.
     */
    public void resetScores(View view) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayScoreForTeamA(scoreTeamA);
        displayScoreForTeamB(scoreTeamB);
        newRound();
        roundOfMatch = 0;
        displayRound("Round " + roundOfMatch);
    }

    /**
     * Resets the number of alive players and increases the number of the current round.
     */
    public void newRound() {
        aliveAPlayers = 3;
        aliveBPlayers = 3;
        displayAliveAPlayers(aliveAPlayers);
        displayAliveBPlayers(aliveBPlayers);
        roundOfMatch++;
        displayRound("Round " + roundOfMatch);
    }

}
