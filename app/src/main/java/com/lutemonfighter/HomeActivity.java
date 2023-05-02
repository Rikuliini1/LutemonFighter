package com.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    private EditText lutemonName;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);
        lutemonName = findViewById(R.id.editTxtLutemonName);
        context = HomeActivity.this;
    }

    public void createNewLutemon(View view) {
        RadioGroup rgLutemonTypes = findViewById(R.id.rgLutemonTypes);
        switch (rgLutemonTypes.getCheckedRadioButtonId()) {
            case R.id.rbWater:
                Storage.getInstance().addLutemon(new WaterLutemon(lutemonName.getText().toString()));
                Toast.makeText(this, "New Water Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbFire:
                Storage.getInstance().addLutemon(new FireLutemon(lutemonName.getText().toString()));
                Toast.makeText(this, "New Fire Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbEarth:
                Storage.getInstance().addLutemon(new EarthLutemon(lutemonName.getText().toString()));
                Toast.makeText(this, "New Earth Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbAir:
                Storage.getInstance().addLutemon(new AirLutemon(lutemonName.getText().toString()));
                Toast.makeText(this, "New Air Lutemon created", Toast.LENGTH_LONG).show();
                break;
            case R.id.rbElectric:
                Storage.getInstance().addLutemon(new ElectricLutemon(lutemonName.getText().toString()));
                Toast.makeText(this, "New Electric Lutemon created", Toast.LENGTH_LONG).show();
                break;
            default:
                Toast.makeText(this, "Select a type first", Toast.LENGTH_LONG).show();
        }
    }

    public void saveLutemons(View view) {
        Storage.getInstance().saveLutemons(context);
        Toast.makeText(context, "Lutemons saved successfully", Toast.LENGTH_LONG).show();
    }

    public void loadLutemons(View view) {
        Storage.getInstance().loadLutemons(context);
        Toast.makeText(context, "Lutemons loaded successfully", Toast.LENGTH_LONG).show();
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
