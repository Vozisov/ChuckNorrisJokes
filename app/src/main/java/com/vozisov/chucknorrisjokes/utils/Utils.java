package com.vozisov.chucknorrisjokes.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

public class Utils {

    public static ArrayList convertToArrayList(JSONArray jsonObject) throws JSONException {

        ArrayList<String> listdata = new ArrayList<>();

        if (jsonObject != null) {
            for (int i = 0; i < jsonObject.length(); i++) {
                listdata.add(jsonObject.getString(i));
            }
        }
        return listdata;
    }

    public static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm != null) {
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            return netInfo != null && netInfo.isConnectedOrConnecting();
        } else {
            return false;
        }
    }
}
