package com.example.caps;
import android.util.Log;
import java.util.*;
import ca.roumani.i2c.*;



public class Game {
    private CountryDB db;

    public Game() {
        this.db = new CountryDB();

    }

    public String qa() {
       // CountryDB db = new CountryDB();
        Random rand = new Random();
        List<String> capitals = db.getCapitals();
        int n = capitals.size();
        int index = rand.nextInt(n) ;
        String c = capitals.get(index);
        Map<String, Country> data = db.getData();
        Country ref = data.get(c);
        //String s = String.format("What is the capital of %s?\n%s", ref.getName(), ref.getCapital());
        if (Math.random() < 0.5) {
String s=String.format("What is the capital of %s?\n%s",ref.getName(),ref.getCapital());
            return s;

        } else {
            String s=String.format("%s is the capital of?\n%s",ref.getCapital(),ref.getName());
            return s;




        }

    }
}
