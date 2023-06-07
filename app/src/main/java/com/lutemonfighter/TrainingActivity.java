package com.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class TrainingActivity extends AppCompatActivity {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static TrainingActivity trainingActivity = null;
    private Lutemon lutemon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.training_activity);
    }

    public static TrainingActivity getInstance() {
        if (trainingActivity == null) {
            trainingActivity = new TrainingActivity();
        }
        return trainingActivity;
    }

    public void trainLutemon(Lutemon lutemon) {
        this.lutemon = lutemon;
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
