package com.lutemonfighter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class LutemonViewHolder extends RecyclerView.ViewHolder {
    ImageView lutemonTypeImage;
    TextView lutemonName, lutemonType, lutemonAttack, lutemonDefense, lutemonExperience, lutemonMaxHealth;

    public LutemonViewHolder(@NonNull View itemView) {
        super(itemView);
        lutemonTypeImage = itemView.findViewById(R.id.ivLutemonTypeImage);
        lutemonName = itemView.findViewById(R.id.tvLutemonName);
        lutemonType = itemView.findViewById(R.id.tvLutemonType);
        lutemonAttack = itemView.findViewById(R.id.tvLutemonAttack);
        lutemonDefense = itemView.findViewById(R.id.tvLutemonDefense);
        lutemonExperience = itemView.findViewById(R.id.tvLutemonExperience);
        lutemonMaxHealth = itemView.findViewById(R.id.tvLutemonMaxHealth);
    }
}

// EOF
