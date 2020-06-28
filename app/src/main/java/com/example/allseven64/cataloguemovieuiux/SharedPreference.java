package com.example.allseven64.cataloguemovieuiux;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreference {
    SharedPreferences sharedPreferences;

    public SharedPreference(Context context) {
        sharedPreferences = context.getSharedPreferences("filename", Context.MODE_PRIVATE);
    }

    public void setDarkModeState(Boolean state) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("DarkMode", state);
        editor.commit();

    }

    public Boolean loadDarkModeState() {
        Boolean state = sharedPreferences.getBoolean("DarkMode", false);
        return state;
    }
}
