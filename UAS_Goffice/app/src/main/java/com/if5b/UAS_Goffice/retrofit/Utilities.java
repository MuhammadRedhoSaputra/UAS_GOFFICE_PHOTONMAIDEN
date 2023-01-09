package com.if5b.UAS_Goffice.retrofit;

import android.content.Context;
import android.content.SharedPreferences;

import retrofit2.Retrofit;

public class Utilities {
    private static final String PREFERENCE_FILE_KEY = "Goffice";
    private static final String BASE_URL = "https://uasgofficepab2.000webhostapp.com/api/";
    private static Retrofit retrofit;

    public static void setValue(Context context, String xPref, String xValue){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(xPref, xValue);
        editor.commit();
    }

    public static String getValue(Context context, String xPref){
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        String xValue = sp.getString(xPref, null);
        return xValue;

    }

    public static boolean checkValue(Context context, String xPref) {
        SharedPreferences sp = context.getSharedPreferences(PREFERENCE_FILE_KEY, Context.MODE_PRIVATE);
        String xValue = sp.getString(xPref, null);
        return xValue != null;
    }
}
