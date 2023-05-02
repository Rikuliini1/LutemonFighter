package com.lutemonfighter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.res.ResourcesCompat;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class LutemonView extends androidx.appcompat.widget.AppCompatImageView {

    private Storage storage;
    // the vector drawable of the lutemons below
    private Drawable lutemonDrawableFire;
    private Drawable lutemonDrawableEarth;
    private Drawable lutemonDrawableElectric;
    private Drawable lutemonDrawableWater;
    private Drawable lutemonDrawableAir;

    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private float scaleFactor = 0.2f;

    public LutemonView(@NonNull Context context) {
        super(context);
        storage = Storage.getInstance();
        this.lutemonDrawableFire = ResourcesCompat.getDrawable(getResources(), R.drawable.fire, null);
        this.lutemonDrawableEarth = ResourcesCompat.getDrawable(getResources(), R.drawable.earth, null);
        this.lutemonDrawableElectric = ResourcesCompat.getDrawable(getResources(), R.drawable.electric, null);
        this.lutemonDrawableWater = ResourcesCompat.getDrawable(getResources(), R.drawable.water, null);
        this.lutemonDrawableAir = ResourcesCompat.getDrawable(getResources(), R.drawable.air, null);
        this.lutemons = lutemons;

        init(null);
    }


    public LutemonView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        storage = Storage.getInstance();
        this.lutemonDrawableFire = ResourcesCompat.getDrawable(getResources(), R.drawable.fire, null);
        this.lutemonDrawableEarth = ResourcesCompat.getDrawable(getResources(), R.drawable.earth, null);
        this.lutemonDrawableElectric = ResourcesCompat.getDrawable(getResources(), R.drawable.electric, null);
        this.lutemonDrawableWater = ResourcesCompat.getDrawable(getResources(), R.drawable.water, null);
        this.lutemonDrawableAir = ResourcesCompat.getDrawable(getResources(), R.drawable.air, null);
        this.lutemons = lutemons;
        init(attrs);
    }

    public LutemonView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        storage = Storage.getInstance();
        this.lutemonDrawableFire = ResourcesCompat.getDrawable(getResources(), R.drawable.fire, null);
        this.lutemonDrawableEarth = ResourcesCompat.getDrawable(getResources(), R.drawable.earth, null);
        this.lutemonDrawableElectric = ResourcesCompat.getDrawable(getResources(), R.drawable.electric, null);
        this.lutemonDrawableWater = ResourcesCompat.getDrawable(getResources(), R.drawable.water, null);
        this.lutemonDrawableAir = ResourcesCompat.getDrawable(getResources(), R.drawable.air, null);
        this.lutemons = lutemons;
        init(attrs);
    }

    private void init(@Nullable AttributeSet set){

    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Random rand = new Random();
        for (int i=0;i<storage.getLutemons().size();i++) {
            canvas.save();
            canvas.translate((100+rand.nextInt(600)),(50+rand.nextInt(350)));
            canvas.scale(3.0f, 3.0f); // scale the drawable by 3x

            lutemons = storage.getLutemons();

            if(Objects.equals(lutemons.get(i).getType(), "Fire")){
                lutemonDrawableFire.setBounds(0, 0, lutemonDrawableFire.getIntrinsicWidth(), lutemonDrawableFire.getIntrinsicHeight());
                lutemonDrawableFire.draw(canvas);
            }
            else if(Objects.equals(lutemons.get(i).getType(), "Earth")){
                lutemonDrawableEarth.setBounds(0, 0, lutemonDrawableEarth.getIntrinsicWidth(), lutemonDrawableEarth.getIntrinsicHeight());
                lutemonDrawableEarth.draw(canvas);
            }
            else if(Objects.equals(lutemons.get(i).getType(), "Electric")){
                lutemonDrawableElectric.setBounds(0, 0, lutemonDrawableElectric.getIntrinsicWidth(), lutemonDrawableElectric.getIntrinsicHeight());
                lutemonDrawableElectric.draw(canvas);
            }
            else if(Objects.equals(lutemons.get(i).getType(), "Water")){
                lutemonDrawableWater.setBounds(0, 0, lutemonDrawableWater.getIntrinsicWidth(), lutemonDrawableWater.getIntrinsicHeight());
                lutemonDrawableWater.draw(canvas);
            }
            else if(Objects.equals(lutemons.get(i).getType(), "Air")){
                lutemonDrawableAir.setBounds(0, 0, lutemonDrawableAir.getIntrinsicWidth(), lutemonDrawableAir.getIntrinsicHeight());
                lutemonDrawableAir.draw(canvas);
            }


            canvas.restore();
        }
    }
}