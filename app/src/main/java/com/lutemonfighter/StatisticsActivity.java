package com.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class StatisticsActivity extends AppCompatActivity {
    private Storage storage;
    private RecyclerView recyclerView;
    private static StatisticsActivity statisticsActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_activity);

        storage = Storage.getInstance();
        recyclerView = findViewById(R.id.rvLutemonList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new LutemonListAdapter(storage.getLutemons(), getApplicationContext()));
    }

    public static StatisticsActivity getInstance() {
        if (statisticsActivity == null) {
            statisticsActivity = new StatisticsActivity();
        }
        return statisticsActivity;
    }

    public void lutemonMovedToTraining() {
        Toast.makeText(this, "Lutemon moved to training", Toast.LENGTH_LONG).show();
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
