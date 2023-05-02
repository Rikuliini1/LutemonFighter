package com.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private EditText lutemonName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        lutemonName = findViewById(R.id.editTxtLutemonName);
    }

    public void createNewLutemon(View view) {
        RadioGroup rgLutemonTypes = findViewById(R.id.rgLutemonTypes);
        switch (rgLutemonTypes.getCheckedRadioButtonId()) {
            case R.id.rbWater:
                Storage.getInstance().addLutemon(new WaterLutemon());
                Toast.makeText(this, "New Water Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbFire:
                Storage.getInstance().addLutemon(new FireLutemon());
                Toast.makeText(this, "New Fire Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbEarth:
                Storage.getInstance().addLutemon(new EarthLutemon());
                Toast.makeText(this, "New Earth Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbAir:
                Storage.getInstance().addLutemon(new AirLutemon());
                Toast.makeText(this, "New Air Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbElectric:
                Storage.getInstance().addLutemon(new ElectricLutemon());
                Toast.makeText(this, "New Electric Lutemon created", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(this, "Select a type first", Toast.LENGTH_LONG).show();
        }
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
