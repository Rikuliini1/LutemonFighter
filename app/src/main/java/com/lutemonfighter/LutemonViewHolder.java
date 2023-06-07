package com.lutemonfighter;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {

    ImageView lutemonTypeImage, lutemonDeleteIcon;
    TextView lutemonName, lutemonType, attackAndDefense, experienceAndMaxHealth;
    Button lutemonTrainButton, lutemonBattleButton;

    ImageView lutemonTypeImage;
    TextView lutemonName, lutemonType, attackAndDefense, experienceAndMaxHealth;


    public LutemonViewHolder(@NonNull View item) {
        super(item);
        lutemonTypeImage = itemView.findViewById(R.id.ivLutemonTypeImage);
        lutemonName = itemView.findViewById(R.id.tvLutemonName);
        lutemonType = itemView.findViewById(R.id.tvLutemonType);
        attackAndDefense = itemView.findViewById(R.id.tvAttackAndDefense);
        experienceAndMaxHealth = itemView.findViewById(R.id.tvExperienceAndMaxHealth);

        lutemonDeleteIcon = itemView.findViewById(R.id.ivDeleteIcon);
        lutemonTrainButton = item.findViewById(R.id.btnTrain);
        lutemonBattleButton = item.findViewById(R.id.btnBattle);

    }
}

// EOF
