package com.lutemonfighter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private List<Lutemon> lutemons;
    private Context context;

    public LutemonListAdapter(ArrayList<Lutemon> lutemons, Context context) {
        this.lutemons = lutemons;
        this.context = context;
    }

    @NonNull
    @Override
    public LutemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new LutemonViewHolder(LayoutInflater.from(context).inflate(R.layout.lutemon_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LutemonViewHolder holder, int position) {
        holder.lutemonName.setText(lutemons.get(position).getName());
        holder.lutemonType.setText(lutemons.get(position).getType());
        holder.attackAndDefense.setText("Attack: " + lutemons.get(position).getAttack() + "  Defense: " + lutemons.get(position).getDefense());
        holder.experienceAndMaxHealth.setText("Experience: " + lutemons.get(position).getExperience() + "   MaxHealth: " + lutemons.get(position).getMaxHealth());
        holder.lutemonTypeImage.setImageResource(lutemons.get(position).getLutemonTypeIcon());
        holder.lutemonDeleteIcon.setImageResource(lutemons.get(position).getLutemonDeleteIcon());
        holder.lutemonDeleteIcon.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
            Storage.getInstance().removeLutemon(lutemons.get(pos).getId());
            notifyItemRemoved(pos);
        });
        holder.lutemonTrainButton.setOnClickListener(view -> {
            Lutemon lutemon = lutemons.get(holder.getAdapterPosition());
            TrainingActivity.getInstance().trainLutemon(lutemon);
            Toast.makeText(context, "Lutemon moved to training", Toast.LENGTH_LONG).show();
        });
        holder.lutemonBattleButton.setOnClickListener(view -> {
            int pos = holder.getAdapterPosition();
        });
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

// EOF
