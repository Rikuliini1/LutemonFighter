package com.lutemonfighter;

import android.content.Context;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Storage {
    private ArrayList<Lutemon> lutemons = new ArrayList<>();
    private static Storage storage = null;

    public static Storage getInstance() {
        if (storage == null) {
            storage = new Storage();
        }
        return storage;
    }

    public void addLutemon(Lutemon lutemon) {
        lutemons.add(lutemon);
    }

    public ArrayList<Lutemon> getLutemons() {
        return lutemons;
    }

    public void removeLutemon(int id) {
        int i = 0;
        String wantedLutemonID = Integer.toString(id);
        for(Lutemon lutemon : lutemons) {
            if (Integer.toString(lutemon.getId()).equals(wantedLutemonID)) {
                break;
            }
            i++;
        }
        lutemons.remove(i);
    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemons);
            lutemonWriter.close();
            System.out.println("Jeee");
        } catch (IOException e) {
            System.out.println("Oh nooo");
            Toast.makeText(context, "Unable to save Lutemons", Toast.LENGTH_LONG).show();
        }
    }

    public void loadLutemons(Context context) {
        try {
            ObjectInputStream lutemonReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemons = (ArrayList<Lutemon>) lutemonReader.readObject();
            lutemonReader.close();
        } catch (FileNotFoundException e) {
            Toast.makeText(context, "Unable to load Lutemons", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (IOException e) {
            Toast.makeText(context, "Unable to load Lutemons", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            Toast.makeText(context, "Unable to load Lutemons", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
    }
}

// EOF
