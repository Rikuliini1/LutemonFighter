package com.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BattleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_activity);
    }

    public void switchToHomeActivity(View view) {
        Intent homeIntent = new Intent(this, HomeActivity.class);
        startActivity(homeIntent);
    }
    public void switchToTrainingActivity(View view) {
        Intent trainingIntent = new Intent(this, TrainingActivity.class);
        startActivity(trainingIntent);
    }
    public void switchToBattleActivity(View view) {
        Intent battleIntent = new Intent(this, BattleActivity.class);
        startActivity(battleIntent);
    }
    public void switchToStatisticsActivity(View view) {
        Intent statisticsIntent = new Intent(this, StatisticsActivity.class);
        startActivity(statisticsIntent);
    }
}

// EOF
