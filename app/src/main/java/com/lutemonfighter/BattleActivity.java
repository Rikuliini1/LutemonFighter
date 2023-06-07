package com.lutemonfighter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

import java.util.ArrayList;

public class BattleActivity extends AppCompatActivity {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();

    private Storage storage;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battle_activity);
        storage = Storage.getInstance();
        lutemons = storage.getLutemons();

        Lutemon fighter1 = lutemons.get(0); //TODO: get fighters from the fighter list
        Lutemon fighter2 = lutemons.get(1);

        TextView textView = findViewById(R.id.battleTextView);
        Button battleButton = findViewById(R.id.button);

        textView.setMovementMethod(new ScrollingMovementMethod());

        battleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                battle(fighter1,fighter2);
            }
        });
    }

    private int calculateDamage(Lutemon attacker, Lutemon defender){
        Random rand = new Random();

        int damage = (attacker.getAttack() - defender.getDefense() / 2) + rand.nextInt(2);

        if (damage < 1) {
            damage = 1; //if defense is too strong
        }
        return damage;
    }

    private void battle(Lutemon fighter1, Lutemon fighter2){
        TextView textView = findViewById(R.id.battleTextView);
        boolean fighter1Turn = true;

        StringBuilder battleText = new StringBuilder("Stats:");

        battleText.append("\nFighter 1:"+fighter1.getName()+", ATK:"+fighter1.getAttack()+", DEF:"+fighter1.getDefense()+", HP:"+fighter1.getMaxHealth());
        battleText.append("\nFighter 2:"+fighter2.getName()+", ATK:"+fighter2.getAttack()+", DEF:"+fighter2.getDefense()+", HP:"+fighter2.getMaxHealth());
        battleText.append("\nLet the battle begin!\n");

        while(fighter1.getHealth() > 0 && fighter2.getHealth() > 0){

            battleText.append("\n"+fighter1.getName()+"'s HP:" +fighter1.getHealth() +" / "+fighter1.getMaxHealth());
            battleText.append("\n"+fighter2.getName()+"'s HP:" +fighter2.getHealth() +" / "+fighter2.getMaxHealth());

            if (fighter1Turn){
                int damage = calculateDamage(fighter1,fighter2);

                fighter2.setHealth(fighter2.getHealth()-damage);

                battleText.append("\n"+fighter1.getName()+" Attacks "+fighter2.getName()+" for "+damage+" damage!");
                fighter1Turn=false;
            }
            else{
                int damage = calculateDamage(fighter2,fighter1);

                fighter1.setHealth(fighter1.getHealth()-damage);

                battleText.append("\n"+fighter2.getName()+" Attacks "+fighter1.getName()+" for "+damage+" damage!");
                fighter1Turn=true;
            }

            if(fighter1.getHealth() <=0){
                battleText.append("\n"+fighter1.getName()+" Has fainted!\n\n\n\n");
                //reward xp, winner gets more
                fighter2.setExperience(fighter2.getExperience()+2);
                fighter1.setExperience(fighter2.getExperience()+1);
            }
            else if (fighter2.getHealth() <=0){
                battleText.append("\n"+fighter2.getName()+" Has fainted!\n\n\n\n");
                //reward xp, winner gets more
                fighter1.setExperience(fighter2.getExperience()+2);
                fighter2.setExperience(fighter2.getExperience()+1);
            }

            textView.setText(battleText);
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
