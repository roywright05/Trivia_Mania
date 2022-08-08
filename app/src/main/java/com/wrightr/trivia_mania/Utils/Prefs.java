package com.wrightr.trivia_mania.Utils;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;

public class Prefs {

    private SharedPreferences preferences;

    public Prefs(Activity context){

        this.preferences = context.getPreferences(Context.MODE_PRIVATE);
    }

    public void saveHighestScore (int score){}

    public int getHighestScore (){
        return 0;
    }
}
