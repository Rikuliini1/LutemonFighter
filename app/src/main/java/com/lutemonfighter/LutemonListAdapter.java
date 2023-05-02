package com.lutemonfighter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LutemonListAdapter extends RecyclerView.Adapter<LutemonViewHolder> {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
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
    }

    @Override
    public int getItemCount() {
        return lutemons.size();
    }
}

// EOF
